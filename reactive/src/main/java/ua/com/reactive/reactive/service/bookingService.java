package ua.com.reactive.reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.entity.Booking;
import ua.com.reactive.reactive.repository.BookingRepository;

@Service
public class bookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public bookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // Отримати всі бронювання
    public Flux<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Отримати бронювання за ID
    public Mono<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    // Створити нове бронювання
    public Mono<Booking> createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    // Оновити бронювання
    public Mono<Booking> updateBooking(Long id, Booking updatedBooking) {
        return bookingRepository.findById(id)
                .flatMap(existingBooking -> {
                    existingBooking.setRoomId(updatedBooking.getRoomId());
                    existingBooking.setGuestId(updatedBooking.getGuestId());
                    existingBooking.setCheckInDate(updatedBooking.getCheckInDate());
                    existingBooking.setCheckOutDate(updatedBooking.getCheckOutDate());
                    return bookingRepository.save(existingBooking);
                });
    }

    // Видалити бронювання за ID
    public Mono<Void> deleteBooking(Long id) {
        return bookingRepository.deleteById(id);
    }
}
