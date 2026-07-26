package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 에러를 담는 종이 상자
@Getter
@AllArgsConstructor
public class ErrorResponse {

    private int status;
    private String message;

}
