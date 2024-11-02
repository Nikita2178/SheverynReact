package ua.com.reactive.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping; // Не забудьте імпорт
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.entity.LoginRequest;
import ua.com.reactive.reactive.service.AuthService;
import ua.com.reactive.reactive.entity.User;
import ua.com.reactive.reactive.controller.UserDto; // Імпорт UserDto

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public Mono<ResponseEntity<Map<String, String>>> login(@RequestBody LoginRequest request) {
        return authService.authenticate(request.getUsername(), request.getPassword())
                .map(user -> {
                    Map<String, String> response = new HashMap<>();
                    response.put("message", "Успішний вхід");
                    return ResponseEntity.ok(response);
                })
                .onErrorResume(e -> Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Collections.singletonMap("message", "Невірний логін або пароль"))));
    }

    @PostMapping("/register")
    public Mono<ResponseEntity<Map<String, String>>> registerUser(@RequestBody UserDto userDto) {
        return authService.registerUser(userDto)
                .map(user -> {
                    Map<String, String> response = new HashMap<>();
                    response.put("message", "Успішна реєстрація");
                    return ResponseEntity.ok(response);
                })
                .onErrorResume(e -> Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(Collections.singletonMap("message", "Помилка під час реєстрації"))));
    }

    @GetMapping("/registration")
    public Mono<Rendering> registrationForm() {
        return Mono.just(Rendering.view("registration").build());
    }

}
