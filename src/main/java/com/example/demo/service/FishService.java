package com.example.demo.service;

import com.example.demo.dto.CreateFishRequest;
import com.example.demo.dto.UpdateFishRequest;
import com.example.demo.entity.Fish;
import com.example.demo.entity.Shark;
import com.example.demo.exception.FishNotFoundException;
import com.example.demo.exception.SharkNotFoundException;
import com.example.demo.repository.FishRepository;
import com.example.demo.repository.SharkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishService {

    private final FishRepository fishRepository;
    // sharkrepository.findbyid를 사용하기 위해 선언 및 아래에서 constructor로 추가
    private final SharkRepository sharkRepository;

    public FishService(
            FishRepository fishRepository,
            SharkRepository sharkRepository
                       ) {
        this.fishRepository = fishRepository;
        this.sharkRepository = sharkRepository;
    }

    public List<Fish> findAll() {
        return fishRepository.findAll();
    }

    // Entity 찾기
    public Fish findById(Long id) {
        return fishRepository.findById(id)
                .orElseThrow(() -> new FishNotFoundException(id));
    }

    public Fish save(CreateFishRequest request) {

        Fish fish = new Fish();

        fish.setName(request.getName());

        //입력받은 shark가 있는지 확인을 하고 그 shark가 정말 존재하는지도 체크
        if(request.getSharkId() != null) {
            Shark shark = sharkRepository.findById(request.getSharkId())
                            .orElseThrow(() -> new FishNotFoundException(request.getSharkId()));

            fish.setShark(shark);
            }

        return fishRepository.save(fish);
    }

    public Fish update(Long id, UpdateFishRequest request) {

        // 기존 Fish 찾기
        Fish existing = fishRepository.findById(id)
                .orElseThrow(() -> new FishNotFoundException(id));

        // name이 들어왔다면 수정
        if (request.getName() != null)
            existing.setName(request.getName());

        if (request.getSharkId() != null) {
            Shark shark = sharkRepository.findById(request.getSharkId()).
                    orElseThrow(() -> new SharkNotFoundException(request.getSharkId()));
            existing.setShark(shark);
        }

        return fishRepository.save(existing);
    }
}