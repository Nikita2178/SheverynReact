package ua.com.reactive.reactive.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import org.springframework.http.ResponseEntity;
import ua.com.reactive.reactive.entity.LoginRequest;

@RestController
public class AuthController {
    @PostMapping("/login")
    public Mono<ResponseEntity<String>> login(@RequestBody LoginRequest request) {
        // Додай логіку для аутентифікації користувача
        return Mono.just(ResponseEntity.ok("Успішний вхід"));
    }
}
