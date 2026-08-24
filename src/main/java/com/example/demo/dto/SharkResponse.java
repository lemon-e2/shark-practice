package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
// 내가 원하는 모양으로 응답 만들기
public class SharkResponse {

    private String name;
    private String species;

    private List<String> fishes;
}
