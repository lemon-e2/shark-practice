package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

// 말 그대로 상어 설계도, 상어 정보 (매핑)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String species;

    // mappedBy: private Shark shark를 가리키고, 관계주인이 Fish.shark 라는 것을 JPA에게 알려준다.
    @OneToMany(
            mappedBy = "shark"
    )
    // 상어: 내가 먹은 물고기들을 알고 싶다.
    private List<Fish> fishes;
}
