//package com.example.good.controller;
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
//@RestController
//@RequestMapping("/api/food")
//@RequiredArgsConstructor
//public class ApiController {
//
//    private final FoodListService foodListService;
//
//    @GetMapping("/search")
//    public FoodListDto search(@RequestParam String query){
//        return foodListService.search(query);
//    }
//
//    @PostMapping("")
//    public void add(@RequestBody FoodListDto foodListDto){
//        log.info("{}", foodListDto);
//        foodListService.insert(foodListDto);
//    }
//
//    @GetMapping("/all")
//    public List<FoodListDto> findAll(){
//        return foodListService.findAll();
//    }
//
//    @DeleteMapping("/{index}")
//    public void delete(@PathVariable Long index){
//        foodListService.delete(index); //delete anomaly
//    }
//
//
//}
