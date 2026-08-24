package com.example.demo.controller;

import com.example.demo.dto.CreateFishRequest;
import com.example.demo.dto.FishResponse;
import com.example.demo.dto.UpdateFishRequest;
import com.example.demo.entity.Fish;
import com.example.demo.service.FishService;
import jakarta.validation.Valid;
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

    // required parameter
    @GetMapping
    public List<FishResponse> getFish(@RequestParam(required = false) Long sharkId) {
        return fishService.findAll(sharkId);
    }

    @GetMapping("/{id}")
    public FishResponse getFishById(@PathVariable Long id) {
        return fishService.findResponseById(id);
    }

    @PostMapping
    public Fish createFish(@Valid @RequestBody CreateFishRequest request) {
        return fishService.save(request);
    }

    @PutMapping("/{id}")
    public Fish updateFish(@PathVariable Long id, @RequestBody UpdateFishRequest request) {
        return  fishService.update(id, request);
    }
}
