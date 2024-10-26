package ua.com.reactive.reactive.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("rooms")
public class Nomer {
    @Id
    private Long id;

    @Column("room_name")
    private String roomName;

    @Column("room_type")
    private String roomType;

    @Column("price")
    private BigDecimal price;

    @Column("available_from")
    private Date availableFrom;

    @Column("available_to")
    private Date availableTo;
}