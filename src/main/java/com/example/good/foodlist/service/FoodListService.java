//package com.example.good.foodlist.service;
//
//
//import com.example.good.domain.food.Food;
//import com.example.good.foodlist.dto.FoodListDto;
//import com.example.good.foodlist.repository.FoodListRepository;
//import com.example.good.godata.DataClient;
//import com.example.good.godata.dto.SearchReq;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class FoodListService {
//
//    private final DataClient dataClient;
//    private final FoodListRepository foodListRepository;
//
//    public FoodListDto search(String query) {
//        // 지역 검색
//        var searchReq = new SearchReq();
//        searchReq.setDesc_kor(query);
//        var searchRes = dataClient.search(searchReq);
//
//        ///*
//        if (searchRes.getBody().getTotalCount() > 0) {
//            LinkedHashMap<String, String> item = (LinkedHashMap<String, String>) searchRes.getBody().getItems().get(0);
//            //var imageQuery = localItem.getTitle().replaceAll("<[^>]*>", "");
//
//            var result = new FoodListDto();
//            result.setDesc_kor(item.get("DESC_KOR"));
//            result.setServing_wt(Integer.parseInt(item.get("SERVING_WT")));
//            result.setNutr_cont1(item.get("NUTR_CONT1"));
//            result.setNutr_cont2(item.get("NUTR_CONT2"));
//            result.setNutr_cont3(item.get("NUTR_CONT3"));
//            result.setNutr_cont4(item.get("NUTR_CONT4"));
//            result.setNutr_cont5(item.get("NUTR_CONT5"));
//            result.setNutr_cont6(item.get("NUTR_CONT6"));
//            result.setNutr_cont7(item.get("NUTR_CONT7"));
//            result.setNutr_cont8(item.get("NUTR_CONT8"));
//            result.setNutr_cont9(item.get("NUTR_CONT9"));
//            result.setBgn_year(item.get("BGN_YEAR"));
//            result.setAnimal_plant(item.get("ANIMAL_PLANT"));
//            return result;
//        } //*/
//        return new FoodListDto();
//    }
//
//    public void insert(FoodListDto foodListDto) {
//
//        Food food = dtoToEntity(foodListDto);
//        foodListRepository.save(food);
//    }
//
//    private Food dtoToEntity(FoodListDto foodListDto){
//        var entity = Food.builder()
//                .id(foodListDto.getIndex())
//                .desc_kor(foodListDto.getDesc_kor())
//                .serving_wt(foodListDto.getServing_wt())
//                .nutr_cont1(foodListDto.getNutr_cont1())
//                .nutr_cont2(foodListDto.getNutr_cont2())
//                .nutr_cont3(foodListDto.getNutr_cont3())
//                .nutr_cont4(foodListDto.getNutr_cont4())
//                .nutr_cont5(foodListDto.getNutr_cont5())
//                .nutr_cont6(foodListDto.getNutr_cont6())
//                .nutr_cont7(foodListDto.getNutr_cont7())
//                .nutr_cont8(foodListDto.getNutr_cont8())
//                .nutr_cont9(foodListDto.getNutr_cont9())
//                .build();
//        return entity;
//    }
//
//    private FoodListDto entityToDto(Food food){
//        var dto = new FoodListDto();
//        dto.setIndex(food.getId());
//        dto.setDesc_kor(food.getDesc_kor());
//        dto.setServing_wt(food.getServing_wt());
//        dto.setNutr_cont1(food.getNutr_cont1());
//        dto.setNutr_cont2(food.getNutr_cont2());
//        dto.setNutr_cont3(food.getNutr_cont3());
//        dto.setNutr_cont4(food.getNutr_cont4());
//        dto.setNutr_cont5(food.getNutr_cont5());
//        dto.setNutr_cont6(food.getNutr_cont6());
//        dto.setNutr_cont7(food.getNutr_cont7());
//        dto.setNutr_cont8(food.getNutr_cont8());
//        dto.setNutr_cont9(food.getNutr_cont9());
//        return dto;
//    }
//
//    public List<FoodListDto> findAll() {
//        return foodListRepository.findAll().stream().map(it-> entityToDto(it)).collect(Collectors.toList());
//    }
//
//    public void delete(Long id) {
//        foodListRepository.deleteById(id);
//    }
//
////    public void addVisit(int index){
////        var wishItem = wishListRepository.findById(index);
////        if(wishItem.isPresent()){
////            var item = wishItem.get();
////            item.setVisit(true);
////            item.setVisitCount(item.getVisitCount()+1);
////        }
////    }
//    public List<FoodListDto> findByName(String name){
//        return foodListRepository.findByName(name);
//    }
//
//    public List<Food> findAlls() {
//        return foodListRepository.findAll();
//    }
//
//}
