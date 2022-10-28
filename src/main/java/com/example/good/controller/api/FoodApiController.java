//package com.example.good.controller.api;
//
//import com.example.good.foodlist.dto.FoodListDto;
//import com.example.good.foodlist.service.FoodListService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Slf4j
//@RequiredArgsConstructor
//@RequestMapping("/api/food")
//@RestController
//public class FoodApiController {
//    private final FoodListService foodListService;
//
//    @GetMapping("/search")
//    public FoodListDto search(@RequestParam String query){
//        return foodListService.search(query);
//    }
//
//    @GetMapping("/all")
//    public List<FoodListDto> findAll(){
//        return foodListService.findAll();
//    }
//
//}
