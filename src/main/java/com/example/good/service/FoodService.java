package com.example.good.service;

import com.example.good.domain.food.Food;
import com.example.good.domain.food.FoodRepository;
import com.example.good.godata.DataClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodService {
    private final FoodRepository foodRepository;


    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Food detail(Long id) {
        return foodRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다. id=" + id));
    }
}
