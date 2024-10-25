package ua.com.reactive.reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.entity.Guest;
import ua.com.reactive.reactive.repository.GuestRepository;

@Service
public class guestService {

    private final GuestRepository guestRepository;

    @Autowired
    public guestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    // Отримати всіх гостей
    public Flux<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    // Отримати гостя за ID
    public Mono<Guest> getGuestById(Long id) {
        return guestRepository.findById(id);
    }

    // Створити нового гостя
    public Mono<Guest> createGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    // Оновити інформацію про гостя
    public Mono<Guest> updateGuest(Long id, Guest updatedGuest) {
        return guestRepository.findById(id)
                .flatMap(existingGuest -> {
                    existingGuest.setName(updatedGuest.getName());
                    existingGuest.setEmail(updatedGuest.getEmail());
                    existingGuest.setPhone(updatedGuest.getPhone());
                    return guestRepository.save(existingGuest);
                });
    }

    // Видалити гостя за ID
    public Mono<Void> deleteGuest(Long id) {
        return guestRepository.deleteById(id);
    }
}
