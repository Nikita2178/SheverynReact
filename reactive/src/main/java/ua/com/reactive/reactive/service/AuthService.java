package ua.com.reactive.reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.controller.UserDto;
import ua.com.reactive.reactive.entity.PasswordEncoderUtil;
import ua.com.reactive.reactive.entity.Role;
import ua.com.reactive.reactive.entity.User;
import ua.com.reactive.reactive.repository.UserRepository;
import org.springframework.r2dbc.core.DatabaseClient;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoderUtil passwordEncoderUtil;
    private final DatabaseClient databaseClient;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoderUtil passwordEncoderUtil, @Qualifier("databaseClient") DatabaseClient databaseClient) {
        this.userRepository = userRepository;
        this.passwordEncoderUtil = passwordEncoderUtil;
        this.databaseClient = databaseClient;
    }

    public Mono<User> authenticate(String username, String password) {
        return userRepository.findByUsername(username)
                .flatMap(user -> {
                    if (passwordEncoderUtil.getPasswordEncoder().matches(password, user.getPassword())) {
                        return Mono.just(user);
                    } else {
                        return Mono.error(new IllegalArgumentException("Невірний логін або пароль"));
                    }
                })
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Користувача не знайдено")));
    }

    public Mono<User> registerUser(UserDto userDto) {
        String hashedPassword = passwordEncoderUtil.encodePassword(userDto.getPassword());

        return databaseClient.sql("INSERT INTO users (username, password, name, surname, phone, role) " +
                        "VALUES (:username, :password, :name, :surname, :phone, :role)")
                .bind("username", userDto.getUsername())
                .bind("password", hashedPassword)
                .bind("name", userDto.getFirstName())
                .bind("surname", userDto.getLastName())
                .bind("phone", userDto.getPhone())
                .bind("role", "USER") // Роль за замовчуванням
                .fetch()
                .rowsUpdated()
                .doOnNext(rows -> {
                    System.out.println("Rows updated: " + rows);
                })
                .flatMap(rows -> {
                    if (rows > 0) {
                        return findUserByUsername(userDto.getUsername());
                    } else {
                        return Mono.error(new RuntimeException("Помилка під час реєстрації"));
                    }
                })
                .onErrorResume(e -> {
                    e.printStackTrace(); // Виводимо стек помилки
                    return Mono.error(new RuntimeException("Не вдалося зареєструвати користувача: " + e.getMessage()));
                });
    }



    private Mono<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
