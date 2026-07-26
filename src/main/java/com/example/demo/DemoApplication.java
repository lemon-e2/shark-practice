package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
//
//    @Bean
//    CommandLineRunner init(SharkRepository sharkRepository) {
//        return args -> {
//
//            Shark shark = new Shark();
//
//            shark.setId(1L);
//            shark.setName("Blahaj");
//            shark.setSpecies("Blue Shark");
//
//            sharkRepository.save(shark);
//
//            System.out.println("상어 저장 완료!");
//        };
//    }
}
