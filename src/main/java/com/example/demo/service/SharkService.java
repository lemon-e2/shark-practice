package com.example.demo.service;

import com.example.demo.dto.CreateSharkRequest;
import com.example.demo.dto.SharkResponse;
import com.example.demo.exception.SharkNotFoundException;
import com.example.demo.repository.SharkRepository;
import com.example.demo.dto.UpdateSharkRequest;
import com.example.demo.entity.Shark;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SharkService {

    private final SharkRepository sharkRepository;

    public SharkService(SharkRepository sharkRepository) {
        this.sharkRepository = sharkRepository;
    }

    public Iterable<Shark> findAll() {
        return sharkRepository.findAll();
    }

    // Entity 찾기
    public Shark findById(Long id) {
        return sharkRepository.findById(id)
                .orElseThrow(() -> new SharkNotFoundException(id));
    }

    public SharkResponse findResponseById(Long id) {
        Shark shark = sharkRepository.findById(id)
                .orElseThrow();

        // 물고기 이름만 추출
        List<String> fishNames = shark.getFishes()
                .stream()
                .map(fish -> fish.getName())
                .toList();

        return new SharkResponse(
                shark.getId(),
                shark.getName(),
                shark.getSpecies(),
                fishNames
        );
    }

    public Shark save(CreateSharkRequest request) {

        // CreateSharkRequest라는 DTO요청상자를 받아서 그 안의 내용을 Shark 엔티티에 담고 sharkRepository 창고관리인에게 save를 주문한다.
        Shark shark = new Shark();

        shark.setName(request.getName());
        shark.setSpecies(request.getSpecies());

        return sharkRepository.save(shark);
    }

    public Shark update(Long id, UpdateSharkRequest request) {

        Shark existing = sharkRepository.findById(id)
                .orElseThrow(() -> new SharkNotFoundException(id));

        if (request.getName() != null) {
            existing.setName(request.getName());
        }

        if (request.getSpecies() != null) {
            existing.setSpecies(request.getSpecies());
        }

        return sharkRepository.save(existing);
    }

    public void delete(Long id) {

        Shark existing = sharkRepository.findById(id)
                .orElseThrow(() -> new SharkNotFoundException(id));

        sharkRepository.delete(existing);
    }
}