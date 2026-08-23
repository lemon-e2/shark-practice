package com.example.demo.repository;

import com.example.demo.entity.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FishRepository extends JpaRepository<Fish,Long> {
    // Repository를 건드리는 이유는 필터링된 데이터를 DB에서 가져와야 하기 때문
    // JPA가 메서드 이름을 분석해서 쿼리 조건을 만들어줌
    List<Fish> findBySharkId(Long sharkId);
}
