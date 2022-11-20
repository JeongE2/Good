package com.example.good.domain.food;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FoodEntity {
    long id;
    String name;			//식품 이름
    double serving_wt;		//1회 제공량 (g)
    double nutr_cont1;		//열량 (kcal)
    double nutr_cont2;		//탄수화물 (g)
    double nutr_cont3;		//단백질 (g)
    double nutr_cont4;		//지방 (g)
    double nutr_cont5;		//당류 (g)
    double nutr_cont6;		//나트륨 (mg)
    double nutr_cont7;		//콜레스테롤 (mg)
    double nutr_cont8;		//포화지방산 (g)
    double nutr_cont9;		//트랜스지방산 (g)

    public FoodEntity(FoodEntity f){		//복사 생성자
        this.id = f.getId();
        this.name = f.getName();
        this.serving_wt = f.getServing_wt();
        this.nutr_cont1 = f.getNutr_cont1();
        this.nutr_cont2 = f.getNutr_cont2();
        this.nutr_cont3 = f.getNutr_cont3();
        this.nutr_cont4 = f.getNutr_cont4();
        this.nutr_cont5 = f.getNutr_cont5();
        this.nutr_cont6 = f.getNutr_cont6();
        this.nutr_cont7 = f.getNutr_cont7();
        this.nutr_cont8 = f.getNutr_cont8();
        this.nutr_cont9 = f.getNutr_cont9();
    }
}
