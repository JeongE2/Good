package com.example.good.controller;

import com.example.good.domain.food.Food;
import com.example.good.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/list")
    public String list(Model model, @PageableDefault(size = 2) Pageable pageable,
                       @RequestParam(required = false, defaultValue = "") String searchText) {
        Page<Food> foods = foodRepository.findByNameContaining(searchText, pageable);
        int startPage = Math.max(1,foods.getPageable().getPageNumber() - 4);
        int endPage = Math.min(foods.getTotalPages(),foods.getPageable().getPageNumber() + 4);

        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("foods",foods);
        return "foodPages/food";
    }

    @GetMapping("/detail")
    public String detail(Model model, @RequestParam(required = false) Long id) {
        Food food = foodRepository.findById(Long.valueOf(id)).orElseThrow(IllegalArgumentException::new);
        model.addAttribute("food", food);
        return "foodPages/food_detail";
    }

    @GetMapping("/diet")
    public String diet(Model model) {
        return "foodPages/food_diet";
    }
}
