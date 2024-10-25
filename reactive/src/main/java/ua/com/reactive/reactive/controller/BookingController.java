package ua.com.reactive.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.entity.Booking;
import ua.com.reactive.reactive.service.bookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final bookingService bookingService;

    @Autowired
    public BookingController(bookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Отримати всі бронювання
    @GetMapping
    public Flux<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // Отримати бронювання за ID
    @GetMapping("/{id}")
    public Mono<Booking> getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    // Створити нове бронювання
    @PostMapping
    public Mono<Booking> createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    // Оновити існуюче бронювання
    @PutMapping("/{id}")
    public Mono<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        return bookingService.updateBooking(id, booking);
    }

    // Видалити бронювання за ID
    @DeleteMapping("/{id}")
    public Mono<Void> deleteBooking(@PathVariable Long id) {
        return bookingService.deleteBooking(id);
    }
}
