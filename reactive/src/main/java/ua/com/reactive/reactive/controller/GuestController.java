package ua.com.reactive.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.entity.Guest;
import ua.com.reactive.reactive.service.guestService;

@RestController
@RequestMapping("/guests")
public class GuestController {

    private final guestService guestService;

    @Autowired
    public GuestController(guestService guestService) {
        this.guestService = guestService;
    }

    // Отримати всіх гостей
    @GetMapping
    public Flux<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }

    // Отримати гостя за ID
    @GetMapping("/{id}")
    public Mono<Guest> getGuestById(@PathVariable Long id) {
        return guestService.getGuestById(id);
    }

    // Створити нового гостя
    @PostMapping
    public Mono<Guest> createGuest(@RequestBody Guest guest) {
        return guestService.createGuest(guest);
    }

    // Оновити інформацію про гостя
    @PutMapping("/{id}")
    public Mono<Guest> updateGuest(@PathVariable Long id, @RequestBody Guest guest) {
        return guestService.updateGuest(id, guest);
    }

    // Видалити гостя за ID
    @DeleteMapping("/{id}")
    public Mono<Void> deleteGuest(@PathVariable Long id) {
        return guestService.deleteGuest(id);
    }
}
