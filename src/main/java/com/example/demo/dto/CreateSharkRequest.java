package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateSharkRequest {

    // 사용자가 id를 함부러 넣으면 안되니 CreateSharkRequest는 검증하는 역할을 한다!
    @NotBlank(message = "이름은 필수입니다. 꽥!")
    @Size(min = 2, max = 20, message = "이름은 2~20자여야 합니다. 꽥!")
    private String name;

    @NotBlank(message = "종은 필수입니다. 꽥!")
    private String species;
}
