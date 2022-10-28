package com.example.good.domain;

import com.example.good.domain.food.Food;
import com.example.good.foodlist.repository.FoodListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FoodListRepositoryTest {

    @Autowired
    FoodListRepository foodListRepository;

    /*
    @AfterEach
    public void cleanup() {
        foodRepository.deleteAll();
    }*/

    @Test
    public void newFoodTest() {
        foodListRepository.save(Food.builder()
                .desc_kor("새로운 음식")
                .serving_wt(100)
                .nutr_cont1("10.0")
                .nutr_cont2("10.0")
                .nutr_cont3("10.0")
                .nutr_cont4("10.0")
                .nutr_cont5("10.0")
                .nutr_cont6("10.0")
                .nutr_cont7("10.0")
                .nutr_cont8("10.0")
                .nutr_cont9("10.0")
                .build());

        List<Food> foodList = foodListRepository.findAll();

        //then
        Food food = foodList.get(0);
        assertThat(food.getDesc_kor()).isEqualTo("새로운 음식");
        assertThat(food.getServing_wt()).isEqualTo(100);

    }
}
