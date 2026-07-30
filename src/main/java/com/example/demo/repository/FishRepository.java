package com.example.demo.repository;

import com.example.demo.entity.Fish;
import org.springframework.data.repository.CrudRepository;

public interface FishRepository extends CrudRepository<Fish,Long> {
}
