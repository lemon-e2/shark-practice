package com.example.demo.repository;

import com.example.demo.entity.Shark;
import org.springframework.data.jpa.repository.JpaRepository;

// 창고 관리자 (일꾼)
public interface SharkRepository extends JpaRepository<Shark, Long> {
}
