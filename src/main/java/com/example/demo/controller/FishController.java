package com.example.demo.controller;

import com.example.demo.dto.CreateFishRequest;
import com.example.demo.dto.UpdateFishRequest;
import com.example.demo.entity.Fish;
import com.example.demo.service.FishService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fish")
public class FishController {

    private final FishService fishService;

    public FishController(FishService fishService) {
        System.out.println("FishController 생성!");
        this.fishService = fishService;
    }

    @GetMapping
    public List<Fish> getFish() {
        return fishService.findAll();
    }

    @GetMapping("/{id}")
    public Fish getFishById(@PathVariable Long id) {
        return fishService.findById(id);
    }

    @PostMapping
    public Fish createFish(@RequestBody CreateFishRequest request) {
        return fishService.save(request);
    }

    @PutMapping("/{id}")
    public Fish updateFish(@PathVariable Long id, @RequestBody UpdateFishRequest request) {
        return  fishService.update(id, request);
    }
}
