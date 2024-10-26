package ua.com.reactive.reactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.Date;
import ua.com.reactive.reactive.entity.Nomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.entity.Nomer;
import ua.com.reactive.reactive.service.nomerService;



@RestController
@RequestMapping

public class NomerController {

    @GetMapping("/nomers")
    public Flux<Nomer> getRooms() {
        Flux<Nomer> rooms = Flux.just(
                        new Nomer(1L, "Room 101", "Single", new BigDecimal("500.00"), new Date(), new Date()),
                        new Nomer(2L, "Room 202", "Double",new BigDecimal("750.00"), new Date(), new Date()),
                        new Nomer(3L, "Room 303", "Suite", new BigDecimal("1500.00"), new Date(), new Date())
                )
                .skip(0)
                .take(5);

        return rooms;
    }
    private final nomerService nomerService;

    @Autowired
    public NomerController(nomerService nomerService) {
        this.nomerService = nomerService;
    }

    // Отримати всі номери
    @GetMapping
    public Flux<Nomer> getAllNomers() {
        return nomerService.getAllNomers();
    }

    // Отримати номер за ID
    @GetMapping("/{id}")
    public Mono<Nomer> getNomerById(@PathVariable Long id) {
        return nomerService.getNomerById(id);
    }

    // Створити новий номер
    @PostMapping("/nomers")
    public Mono<Nomer> createNomer(@RequestBody Nomer nomer) {
        return nomerService.createNomer(nomer);
    }

    // Оновити існуючий номер
    @PutMapping("/{id}")
    public Mono<Nomer> updateNomer(@PathVariable Long id, @RequestBody Nomer nomer) {
        return nomerService.updateNomer(id, nomer);
    }

    // Видалити номер за ID
    @DeleteMapping("/{id}")
    public Mono<Void> deleteNomer(@PathVariable Long id) {
        return nomerService.deleteNomer(id);
    }
}
