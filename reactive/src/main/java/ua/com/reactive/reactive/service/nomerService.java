package ua.com.reactive.reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.reactive.reactive.entity.Nomer;
import ua.com.reactive.reactive.repository.NomerRepository;

@Service
public class nomerService {

    private final NomerRepository nomerRepository;

    @Autowired
    public nomerService(NomerRepository nomerRepository) {
        this.nomerRepository = nomerRepository;
    }

    // Отримати всі номери
    public Flux<Nomer> getAllNomers() {
        return nomerRepository.findAll();
    }

    // Отримати номер за ID
    public Mono<Nomer> getNomerById(Long id) {
        return nomerRepository.findById(id);
    }

    // Створити новий номер
    public Mono<Nomer> createNomer(Nomer nomer) {
        return nomerRepository.save(nomer);
    }

    // Оновити номер
    public Mono<Nomer> updateNomer(Long id, Nomer updatedNomer) {
        return nomerRepository.findById(id)
                .flatMap(existingNomer -> {
                    existingNomer.setRoomName(updatedNomer.getRoomName());
                    existingNomer.setRoomType(updatedNomer.getRoomType());
                    existingNomer.setPrice(updatedNomer.getPrice());
                    existingNomer.setAvailableFrom(updatedNomer.getAvailableFrom());
                    existingNomer.setAvailableTo(updatedNomer.getAvailableTo());
                    return nomerRepository.save(existingNomer);
                });
    }

    // Видалити номер за ID
    public Mono<Void> deleteNomer(Long id) {
        return nomerRepository.deleteById(id);
    }
}
