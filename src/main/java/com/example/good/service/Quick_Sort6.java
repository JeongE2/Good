package com.example.good.service;

import com.example.good.domain.food.FoodEntity;

import java.util.ArrayList;

public class Quick_Sort6 {

    public ArrayList<FoodEntity> quickSort6(ArrayList<FoodEntity> li) {


        if (li.size() < 2) {
            return li;
        }
        ArrayList<FoodEntity> left = new ArrayList<>(); // 작은 값을 담을 좌 list
        ArrayList<FoodEntity> right = new ArrayList<>();// 큰 값을 넣을 우 list

        double pivot = li.get(li.size() / 2).getNutr_cont6();
        FoodEntity pivot_Food = li.get(li.size() / 2);
        li.remove(li.size() / 2);

        for (int i = 0; i < li.size(); i++) {
            if (li.get(i).getNutr_cont6() >= pivot) {
                left.add(li.get(i)); // 만약 배열의 숫자가 pivot보다 클 때 right에 저장

            } else {
                right.add(li.get(i)); // 만약 배열의 숫자가 pivot보다 작을 때 left에 저장

            }
        }
        left = quickSort6(left);
        right = quickSort6(right);
        ArrayList<FoodEntity> sortedList = new ArrayList<>();
        sortedList.addAll(left);
        sortedList.add(pivot_Food);
        sortedList.addAll(right);

        li.add(pivot_Food);


        return sortedList;

    }


}

