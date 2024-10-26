package ua.com.reactive.reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.entity.User;
import ua.com.reactive.reactive.repository.UserRepository;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> authenticate(String username, String password) {
        return userRepository.findByUsername(username)
                .flatMap(user -> {
                    // Перевірка пароля
                    if (passwordEncoder.matches(password, user.getPassword())) {
                        return Mono.just(user); // Повертаємо користувача, якщо пароль вірний
                    } else {
                        return Mono.error(new IllegalArgumentException("Невірний логін або пароль"));
                    }
                })
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Користувача не знайдено")));
    }
}
