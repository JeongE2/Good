//package com.example.good.controller;
//
//import com.example.good.service.FoodService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@RequiredArgsConstructor
//@Controller
//public class IndexController {
//
//    private final FoodService foodService;
//
//    @GetMapping("/")
//    public String index(Model model) {
//        model.addAttribute("foods", foodService.findAll());
//        return "index";
//    }
//}
