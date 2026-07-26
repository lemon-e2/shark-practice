package com.example.demo.dto;

import lombok.Getter;

@Getter
public class UpdateSharkRequest {

    private String name;
    private String species;

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }
}
