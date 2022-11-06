package com.example.good.controller;

import com.example.good.domain.food.Food;
import com.example.good.repository.FoodRepository;
import com.example.good.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FoodController {
    //private final FoodService foodService;

    @Autowired
    private FoodRepository foodRepository;

//    @GetMapping("/foods/{id}")
//    public String detail(@PathVariable Long id, Model model){
//        model.addAttribute("food", foodService.detail(id));
//        return "foodPages/food_detail";
//    }

    @GetMapping("/foods")
    List<Food> all(@RequestParam(required = false) String name){
        if(StringUtils.isEmpty(name)){
            return foodRepository.findAll();
        } else{
            return foodRepository.findByName(name);
        }
    }
}
