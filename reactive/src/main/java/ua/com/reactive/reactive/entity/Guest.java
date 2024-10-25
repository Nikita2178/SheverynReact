package ua.com.reactive.reactive.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Guest {
    @Id
    private Long id;
    private String name;
    private String email;
    private String phone;
}
