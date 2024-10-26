package ua.com.reactive.reactive.entity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderUtil {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String rawPassword1 = "1111";
        String rawPassword2 = "2222";

        String encodedPassword1 = passwordEncoder.encode(rawPassword1);
        String encodedPassword2 = passwordEncoder.encode(rawPassword2);

        System.out.println("Encoded Password for '1111': " + encodedPassword1);
        System.out.println("Encoded Password for '2222': " + encodedPassword2);
    }
}