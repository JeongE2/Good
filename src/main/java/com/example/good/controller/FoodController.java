//package com.example.good.controller;
//
//import com.example.good.service.FoodService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@RequiredArgsConstructor
//@Controller
//public class FoodController {
//    private final FoodService foodService;
//
//    @GetMapping("/food/{id}")
//    public String detail(@PathVariable Long id, Model model){
//        model.addAttribute("food", foodService.detail(id));
//        return "foodPages/food_detail";
//    }
//
//}
