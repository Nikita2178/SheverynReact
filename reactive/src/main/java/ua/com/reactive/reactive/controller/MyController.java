package ua.com.reactive.reactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ua.com.reactive.reactive.entity.Client;

@RestController

public class MyController {

    @GetMapping("/clients")

    public Flux<Client> getClients() {
        Flux<Client> clients = Flux.just(
                        new Client(1L, "Vasya", "Pypkin", "Kiev Hrechatik"),
                        new Client(2L, "Iva", "Pypkina", "Kiev Obolon"),
                        new Client(3L, "Inna", "Pypkina", "+Brovary Centr!")
                )
                .skip(0)
                .take(2);

        return clients;
    }

}
