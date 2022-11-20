package com.example.good.controller;

import com.example.good.domain.food.Food;
import com.example.good.domain.food.FoodEntity;
import com.example.good.domain.food.FoodIn;
import com.example.good.repository.FoodRepository;
import com.example.good.service.FoodService;
import com.example.good.service.Food_Recommend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private FoodService foodService;

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

    @GetMapping("/find")
    public String find(Model model, @PageableDefault(size = 2) Pageable pageable,
                       @RequestParam(required = false, defaultValue = "") String searchText) {
        Page<Food> foods = foodRepository.findByNameContaining(searchText, pageable);
        int startPage = Math.max(1,foods.getPageable().getPageNumber() - 4);
        int endPage = Math.min(foods.getTotalPages(),foods.getPageable().getPageNumber() + 4);

        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("foods",foods);
        return "foodPages/foodFind";
    }

    @PostMapping("/analyze")
    public String analyze(Model model, FoodIn food){
        String[] foods = food.getId().split(",");
        List<FoodEntity> foodlist = new ArrayList<>();
        for (int i = 0; i < foods.length; i++) {
            System.out.println(foods[i]);
            Long id = Long.parseLong(foods[i]);
            //idx 번호로 음식 찾아서 식단 분석의 Food 엔티티로 변환  //밑으로의 함수는 service에서 처리
            FoodEntity entity = foodService.getEntitybyId(id);
            //엔티티를 리스트에 추가
            foodlist.add(entity);
        }
        for (int i = 0; i < foodlist.size(); i++) {
            System.out.println(foodlist.get(i).getName());
        }
        Food_Recommend fr = new Food_Recommend();

        //결과 받기
        ArrayList<FoodEntity> result = fr.foodRecommend();
        //결과 출력
        /*
        for (int i = 0; i < result.size()-1; i++)        //식단에서 제거해야할 음식들을 차례로 출력해줌
        {
            System.out.printf("%s ", result.get(i).getName());
        }
        System.out.println("을(를) 안먹고 다른 음식을 먹어보세요.\n");

        FoodEntity need = result.get(result.size()-1);

        System.out.printf("필요한 열량 : %f kcal\n", need.getNutr_cont1());
        System.out.printf("필요한 탄수화물 : %f g\n", need.getNutr_cont2());
        System.out.printf("필요한 단백질 : %f g\n", need.getNutr_cont3());
        System.out.printf("필요한 지방 : %f g\n", need.getNutr_cont4());
        System.out.printf("필요한 당 : %f g\n", need.getNutr_cont5());
        System.out.printf("필요한 나트륨 : %f mg\n", need.getNutr_cont6());
        System.out.printf("필요한 콜레스테롤 : %f mg\n", need.getNutr_cont7());
        System.out.printf("필요한 포화지방산 : %f g\n", need.getNutr_cont8());
        System.out.printf("필요한 트랜스지방산 : %f g\n", need.getNutr_cont9());
        //이 필요한 영양성분들을 가진 음식들을 추천해줌 ( 모든 영양성분 수치 조건들을 and로 연산 )*/

        model.addAttribute("result",result);
        return "foodPages/food_diet_result";
    }
}
