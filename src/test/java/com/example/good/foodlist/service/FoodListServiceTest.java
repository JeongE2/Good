package com.example.good.foodlist.service;
import com.example.good.foodlist.dto.FoodListDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class FoodListServiceTest {

    @Autowired
    private FoodListService foodListService;

    @Test
    public void searchTest(){
        FoodListDto result = foodListService.search("갈비");
        System.out.println(result.toString());
        Assertions.assertNotNull(result);
    }

    @Test
    public void findTest(){
        List<FoodListDto> foodlist = foodListService.findAll();
        System.out.println(foodlist.get(0).getDesc_kor());
    }

    @Test
    public void insertTest(){
        FoodListDto result = foodListService.search("삼계탕");
        System.out.println(result.toString());
        foodListService.insert(result);
    }
}

