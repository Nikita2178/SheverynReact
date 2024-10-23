package ua.com.reactive.reactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ua.com.reactive.reactive.entity.Client;

@RestController
// Замовлення готелю
public class MyController {

    @GetMapping("/clients")

    public Flux<Client> getClients() {
        Flux<Client> clients = Flux.just(
                        new Client(1L, "Vasya", "Pypkin", "Kiev Hrechatik","Vasya@gmail.com"),
                        new Client(2L, "Iva", "Pypkina", "Kiev Obolon","IVA@gmail.com"),
                        new Client(3L, "Inna", "Pypkina", "Brovary Centr!" ,"Inna@gmail.com"),
                        new Client(4L, "Nikita", "Anat", "Lviv Centr" ,"Nikita@gmail.com"),
                        new Client(5L, "Sasha", "Veronshk", "Odessa!" ,"Sasha@gmail.com")
                )
                .skip(0)
                .take(5);

        return clients;
    }

}
