package ua.com.reactive.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ua.com.reactive.reactive.entity.Message;

public interface MessageRepository extends ReactiveCrudRepository<Message, Long> {
}