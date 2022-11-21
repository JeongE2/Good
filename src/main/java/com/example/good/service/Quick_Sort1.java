package com.example.good.service;

import com.example.good.domain.food.FoodEntity;

import java.util.ArrayList;

public class Quick_Sort1 {

    public ArrayList<FoodEntity> quickSort1(ArrayList<FoodEntity> li, int nutNum) {
        if (li.size() < 2) {
            return li;
        }
        ArrayList<FoodEntity> left = new ArrayList<>(); // 작은 값을 담을 좌 list
        ArrayList<FoodEntity> right = new ArrayList<>();// 큰 값을 넣을 우 list
        double pivot = 0;
        switch (nutNum) {
            case 1:
                pivot = li.get(li.size() / 2).getNutr_cont1();break;
            case 2:
                pivot = li.get(li.size() / 2).getNutr_cont2();break;
            case 3:
                pivot = li.get(li.size() / 2).getNutr_cont3();break;
            case 4:
                pivot = li.get(li.size() / 2).getNutr_cont4();break;
            case 5:
                pivot = li.get(li.size() / 2).getNutr_cont5();break;
            case 6:
                pivot = li.get(li.size() / 2).getNutr_cont6();break;
            case 7:
                pivot = li.get(li.size() / 2).getNutr_cont7();break;
            case 8:
                pivot = li.get(li.size() / 2).getNutr_cont8();break;
            case 9:
                pivot = li.get(li.size() / 2).getNutr_cont9();break;
        }
        FoodEntity pivot_Food = li.get(li.size() / 2);
        li.remove(li.size() / 2);

        double[] nuts = new double[li.size()];
        switch (nutNum) {
            case 1:
                for (int i = 0; i < nuts.length; i++) {
                    nuts[i] = li.get(i).getNutr_cont1();
                }
                break;
            case 2:
                for (int i = 0; i < nuts.length; i++) {
                    nuts[i] = li.get(i).getNutr_cont2();
                }
                break;
            case 3:
                for (int i = 0; i < nuts.length; i++) {
                    nuts[i] = li.get(i).getNutr_cont3();
                }
                break;
            case 4:
                for (int i = 0; i < nuts.length; i++) {
                    nuts[i] = li.get(i).getNutr_cont4();
                }break;
            case 5:
                for (int i = 0; i < nuts.length; i++) {
                    nuts[i] = li.get(i).getNutr_cont5();
                }break;
            case 6:
                for (int i = 0; i < nuts.length; i++) {
                    nuts[i] = li.get(i).getNutr_cont6();
                }break;
            case 7:
                for (int i = 0; i < nuts.length; i++) {
                    nuts[i] = li.get(i).getNutr_cont7();
                }break;
            case 8:
                for (int i = 0; i < nuts.length; i++) {
                    nuts[i] = li.get(i).getNutr_cont8();
                }break;
            case 9:
                for (int i = 0; i < nuts.length; i++) {
                    nuts[i] = li.get(i).getNutr_cont9();
                }break;
        }

        for (int i = 0; i < li.size(); i++) {
            if (nuts[i] >= pivot) {
                left.add(li.get(i)); // 만약 배열의 숫자가 pivot보다 클 때 right에 저장

            } else {
                right.add(li.get(i)); // 만약 배열의 숫자가 pivot보다 작을 때 left에 저장

            }
        }
        left = quickSort1(left, nutNum);
        right = quickSort1(right, nutNum);
        ArrayList<FoodEntity> sortedList = new ArrayList<>();
        sortedList.addAll(left);
        sortedList.add(pivot_Food);
        sortedList.addAll(right);
        li.add(pivot_Food);
        return sortedList;
    }
}




