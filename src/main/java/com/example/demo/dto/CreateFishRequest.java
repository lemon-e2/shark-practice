package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
// new CreateFishRequest()를 할 수 있게 해주는 기본 생성자
@NoArgsConstructor
public class CreateFishRequest {

    @NotBlank(message = "이름은 필수입니다. 꽥!")
    @Size(min = 2, max = 20, message = "이름은 2~20자여야 합니다. 꽥!")
    private String name;

    private Long sharkId;
}
