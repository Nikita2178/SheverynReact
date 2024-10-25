package ua.com.reactive.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ua.com.reactive.reactive.entity.Nomer;

public interface NomerRepository extends ReactiveCrudRepository<Nomer, Long> {
}