package ua.com.reactive.reactive.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.Date;
@Data
@NoArgsConstructor
@Table("reservations")
public class Booking {

    @Id
    private Long id;

    private Long roomId;
    private Long userId; // змінено з guestId на userId, щоб відповідати структурі таблиці

    private String userName;
    private String userSurname;

    private Date checkInDate;
    private Date checkOutDate;

    private BigDecimal totalPrice;
}
