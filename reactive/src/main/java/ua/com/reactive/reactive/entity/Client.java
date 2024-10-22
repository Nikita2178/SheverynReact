package ua.com.reactive.reactive.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Client {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
}