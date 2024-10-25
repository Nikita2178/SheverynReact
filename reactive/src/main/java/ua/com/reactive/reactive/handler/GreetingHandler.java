package ua.com.reactive.reactive.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.entity.Client;
import ua.com.reactive.reactive.entity.Greeting;
import ua.com.reactive.reactive.entity.Nomer;

import java.util.Date;


@Component

public class GreetingHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Greeting("Hello, Spring")));
    }

    public Mono<ServerResponse> home(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Sheveryn Nikita!"));
    }

    public Mono<ServerResponse> getClients(ServerRequest request) {

        String start = request
                .queryParam("start")
                .orElse("0");


        Flux<Client> clients = Flux.just(
                        new Client(1L, "Vasya", "Pypkin", "Kiev Hrechatik","Vasya@gmail.com"),
                        new Client(2L, "Iva", "Pypkina", "Kiev Obolon","IVA@gmail.com"),
                        new Client(3L, "Inna", "Pypkina", "Brovary Centr!" ,"Inna@gmail.com"),
                        new Client(4L, "Nikita", "Anat", "Lviv Centr" ,"Nikita@gmail.com"),
                        new Client(5L, "Sasha", "Veronshk", "Odessa!" ,"Sasha@gmail.com")
                )
                .skip(Long.valueOf(start))
                .take(5);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(clients, Client.class);
    }
    public Mono<ServerResponse> getNomer(ServerRequest request) {
        String start = request
                .queryParam("start")
                .orElse("0");
        Flux<Nomer> nomers = Flux.just(
                        new Nomer(1L, "Room 101", "Single", "500 UAH", new Date(), new Date()),
                        new Nomer(2L, "Room 202", "Double", "750 UAH", new Date(), new Date()),
                        new Nomer(3L, "Room 303", "Suite", "1500 UAH", new Date(), new Date())
                )
                .skip(Long.valueOf(start))
                .take(5);
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(nomers, Nomer.class);
    }
    public Mono<ServerResponse> registration(ServerRequest request) {
        return ServerResponse.ok().render("registration");
    }
}
