package ua.com.reactive.reactive.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Booking {
    @Id
    private Long id;
    private Long roomId;
    private Long guestId;
    private String checkInDate;
    private String checkOutDate;
}
