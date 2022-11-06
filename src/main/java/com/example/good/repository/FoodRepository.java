package com.example.good.repository;

import com.example.good.domain.food.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findByName(String name);

    Page<Food> findByNameContaining(String name, Pageable pageable);
}
