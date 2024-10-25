package ua.com.reactive.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ua.com.reactive.reactive.entity.Booking;

public interface BookingRepository extends ReactiveCrudRepository<Booking, Long> {
}