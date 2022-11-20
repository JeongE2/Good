package com.example.good.service;

import com.example.good.domain.food.Food;
import com.example.good.domain.food.FoodEntity;
import com.example.good.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FoodService {
    private final FoodRepository foodRepository;

    public FoodEntity getEntitybyId(Long id) {
        //id로 음식 찾고
        Food food =  foodRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다. id=" + id));
        //Food -> FoodEntity로 변환
        FoodEntity entity = dtoToEntity(food);
        return entity;
    }

    private FoodEntity dtoToEntity(Food food) {
        FoodEntity entity = new FoodEntity();
        entity.setId(food.getId());
        entity.setName(food.getName());
        entity.setServing_wt(food.getServing_wt());
        entity.setNutr_cont1(Double.parseDouble(food.getNutr_cont1().equals("N/A")?"0":food.getNutr_cont1())); //String에서 Double로 변환
        entity.setNutr_cont1(Double.parseDouble(food.getNutr_cont2().equals("N/A")?"0":food.getNutr_cont2()));
        entity.setNutr_cont1(Double.parseDouble(food.getNutr_cont3().equals("N/A")?"0":food.getNutr_cont3()));
        entity.setNutr_cont1(Double.parseDouble(food.getNutr_cont4().equals("N/A")?"0":food.getNutr_cont4()));
        entity.setNutr_cont1(Double.parseDouble(food.getNutr_cont5().equals("N/A")?"0":food.getNutr_cont5()));
        entity.setNutr_cont1(Double.parseDouble(food.getNutr_cont6().equals("N/A")?"0":food.getNutr_cont6()));
        entity.setNutr_cont1(Double.parseDouble(food.getNutr_cont7().equals("N/A")?"0":food.getNutr_cont7()));
        entity.setNutr_cont1(Double.parseDouble(food.getNutr_cont8().equals("N/A")?"0":food.getNutr_cont8()));
        entity.setNutr_cont1(Double.parseDouble(food.getNutr_cont9().equals("N/A")?"0":food.getNutr_cont9()));
        return entity;
    }
}
