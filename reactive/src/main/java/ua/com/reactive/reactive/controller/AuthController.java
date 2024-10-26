package ua.com.reactive.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import ua.com.reactive.reactive.entity.LoginRequest;
import ua.com.reactive.reactive.service.AuthService;

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
                .onErrorResume(e -> Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("message", "Невірний логін або пароль"))));
    }

}
