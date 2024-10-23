package ua.com.reactive.reactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import java.util.Date;
import ua.com.reactive.reactive.entity.Nomer;


@RestController
public class NomerController {

    @GetMapping("/nomers")
    public Flux<Nomer> getRooms() {
        Flux<Nomer> rooms = Flux.just(
                        new Nomer(1L, "Room 101", "Single", "500 UAH", new Date(), new Date()),
                        new Nomer(2L, "Room 202", "Double", "750 UAH", new Date(), new Date()),
                        new Nomer(3L, "Room 303", "Suite", "1500 UAH", new Date(), new Date())
                )
                .skip(0)
                .take(5);

        return rooms;
    }
}
