package com.example.good.service;

import com.example.good.domain.food.FoodEntity;

public class Difference {

public FoodEntity difference(FoodEntity A, FoodEntity B) {

	FoodEntity C = new FoodEntity(0,"temp",0,0,0,0,0,0,0,0,0,0);
		C.setNutr_cont1(A.getNutr_cont1() - B.getNutr_cont1());
		C.setNutr_cont2(A.getNutr_cont2() - B.getNutr_cont2());
		C.setNutr_cont3(A.getNutr_cont3() - B.getNutr_cont3());
		C.setNutr_cont4(A.getNutr_cont4() - B.getNutr_cont4());
		C.setNutr_cont5(A.getNutr_cont5() - B.getNutr_cont5());
		C.setNutr_cont6(A.getNutr_cont6() - B.getNutr_cont6());
		C.setNutr_cont7(A.getNutr_cont7() - B.getNutr_cont7());
		C.setNutr_cont8(A.getNutr_cont8() - B.getNutr_cont8());
		C.setNutr_cont9(A.getNutr_cont9() - B.getNutr_cont9());
	return C;
    }
}

