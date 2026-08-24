package com.example.demo.service;

import com.example.demo.dto.CreateSharkRequest;
import com.example.demo.dto.SharkResponse;
import com.example.demo.entity.Fish;
import com.example.demo.exception.SharkNotFoundException;
import com.example.demo.repository.FishRepository;
import com.example.demo.repository.SharkRepository;
import com.example.demo.dto.UpdateSharkRequest;
import com.example.demo.entity.Shark;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SharkService {

    private final SharkRepository sharkRepository;
    private final FishService fishService;
    private final FishRepository fishRepository;

    public SharkService(
            SharkRepository sharkRepository,
            FishService fishService,
            FishRepository fishRepository
                        ) {
        this.sharkRepository = sharkRepository;
        this.fishService = fishService;
        this.fishRepository = fishRepository;
    }

    public List<SharkResponse> findAll() {
        List<Shark> sharks = sharkRepository.findAll();
        List<SharkResponse> sharkResponses = new ArrayList<>();

        for (Shark shark : sharks) {

            // shark에 fish 들이 있다면 돌면서 fish 이름을 가져오고 없다면 빈 []를 리턴
            List<String> fishNames = shark.getFishes()
                    .stream()
                    .map(fish -> fish.getName())
                    .toList();

            // 그렇게 하나하나씩 shark의 데이터를 sharkresponse에 차곡차곡 넣기
            SharkResponse response = new SharkResponse(
                    shark.getName(),
                    shark.getSpecies(),
                    fishNames
            );

            sharkResponses.add(response);
        }
        return sharkResponses;
    }

    public SharkResponse findResponseById(Long id) {
        // 아무것도 없으면 null을 반환하기 때문에 그것을 방지하기 위해 Optional로 분기를 나눔
        Shark shark = sharkRepository.findById(id)
                .orElseThrow();

        // 물고기 이름만 추출
        List<String> fishNames = shark.getFishes()
                .stream()
                .map(fish -> fish.getName())
                .toList();

        return new SharkResponse(
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

        // 기존 Shark 찾기
        Shark existing = sharkRepository.findById(id)
                .orElseThrow(() -> new SharkNotFoundException(id));

        // name이 들어왔다면 수정
        if (request.getName() != null) {
            existing.setName(request.getName());
        }

        // species가 들어왔다면 수정
        if (request.getSpecies() != null) {
            existing.setSpecies(request.getSpecies());
        }

        return sharkRepository.save(existing);
    }

    public void delete(Long id) {

        // shark 찾기
        Shark existing = sharkRepository.findById(id)
                .orElseThrow(() -> new SharkNotFoundException(id));

        //  shark에 연결된 fish 전부 순회
        for (Fish fish : existing.getFishes()) {

            // 상어 연결 끊기
            fish.setShark(null);

            // fish 저장
            fishRepository.save(fish);
        }

        // shark 삭제
        sharkRepository.delete(existing);
    }
}