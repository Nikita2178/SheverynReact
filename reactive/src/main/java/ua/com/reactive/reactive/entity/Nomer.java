package ua.com.reactive.reactive.entity;

import lombok.*;
import java.sql.Time;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Nomer {
    private Long id;
    private String rommName;
    private String roomType;
    private String price;
    private Date availableFrom;
    private Date availableTo;
}