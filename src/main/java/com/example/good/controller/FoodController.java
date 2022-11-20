package com.example.good.controller;

import com.example.good.domain.food.Food;
import com.example.good.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/find")
    public String find(Model model, @PageableDefault(size = 5) Pageable pageable,
                       @RequestParam(required = false, defaultValue = "") String searchText) {
        Page<Food> foods = foodRepository.findByNameContaining(searchText, pageable);
        int startPage = Math.max(1,foods.getPageable().getPageNumber() - 4);
        int endPage = Math.min(foods.getTotalPages(),foods.getPageable().getPageNumber() + 4);

        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("foods",foods);
        return "foodPages/foodFind";
    }
}
