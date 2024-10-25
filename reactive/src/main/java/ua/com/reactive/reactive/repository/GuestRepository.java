package ua.com.reactive.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ua.com.reactive.reactive.entity.Guest;

public interface GuestRepository extends ReactiveCrudRepository<Guest, Long> {
}