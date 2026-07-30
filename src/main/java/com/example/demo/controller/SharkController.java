package com.example.demo.controller;

import com.example.demo.dto.CreateSharkRequest;
import com.example.demo.dto.SharkResponse;
import com.example.demo.service.SharkService;
import com.example.demo.dto.UpdateSharkRequest;
import com.example.demo.entity.Shark;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sharks")
public class SharkController {

    private final SharkService sharkService;

    public SharkController(SharkService sharkService) {
        System.out.println("SharkController 생성!");
        this.sharkService = sharkService;
    }

    @GetMapping
    public Iterable<Shark> getSharks() {
        return sharkService.findAll();
    }

    @GetMapping("/{id}")
    public SharkResponse getSharkById(@PathVariable Long id) {
        return sharkService.findResponseById(id);
    }

    @PostMapping
    public Shark createShark(@Valid @RequestBody CreateSharkRequest request) {
        return sharkService.save(request);
    }

    @PutMapping("/{id}")
    public Shark updateShark(@PathVariable Long id, @RequestBody UpdateSharkRequest request) {
        return sharkService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteShark(@PathVariable Long id) {
        sharkService.delete(id);
    }
}
