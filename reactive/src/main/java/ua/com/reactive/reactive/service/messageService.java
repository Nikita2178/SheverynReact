package ua.com.reactive.reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.entity.Message;
import ua.com.reactive.reactive.repository.MessageRepository;
@Service
public class messageService {
    private final MessageRepository messageRepository;
    @Autowired
    public messageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    public Flux<Message> list() {
        return messageRepository.findAll();
    }
    public Mono<Message> addOne(Message message) {
        return messageRepository.save(message);
    }
}