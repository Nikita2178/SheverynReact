package ua.com.reactive.reactive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

    // Кодування паролів за допомогою BCryptPasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Конфігурація безпеки
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http
                .csrf(csrf -> csrf.disable())  // Вимкнути CSRF-захист
                .authorizeExchange(exchange -> exchange
                        .pathMatchers("/", "/hello", "/registration")  // Доступні без авторизації
                        .permitAll()
                        .pathMatchers("/all")  // Доступ для ролі "USER"
                        .hasRole("USER")
                        .pathMatchers("/get_all")  // Доступ для ролі "ADMIN"
                        .hasRole("ADMIN")
                        .anyExchange()  // Усі інші запити вимагають аутентифікації
                        .authenticated()
                )
                .formLogin(Customizer.withDefaults())  // Включити форму логіну
                .build();
    }
}
