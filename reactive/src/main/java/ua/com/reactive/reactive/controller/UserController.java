package ua.com.reactive.reactive.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.entity.Role;
import ua.com.reactive.reactive.entity.User;
import ua.com.reactive.reactive.service.UserService;
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/all")
    public Flux<User> getAll() {
        return userService.findAll();
    }
    //    @PostMapping("/all")
//    public Mono<Users> createUser(@RequestBody Users user) {
//        return userService.save(user);
//    }
    @PostMapping("/registration")
    public Mono<User> registerUser(@RequestBody User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setRole(Role.ROLE_USER);
        return userService.save(user);
    }
}