package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 말 그대로 상어 설계도, 상어 정보 (매핑)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shark {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String species;
}
