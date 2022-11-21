package com.example.good.service;

import com.example.good.domain.food.FoodEntity;

import java.util.ArrayList;

public class Food_Recommend {
    public ArrayList<FoodEntity> foodRecommend() {//ArrayList<FoodEntity> FoodList) {
        int i = 0;
        int j = 0;
        ArrayList<FoodEntity> FoodList = new ArrayList<>();//사용자가 먹은 음식들을 저장할 ArrayList
        ArrayList<FoodEntity> FoodList_sort_desc = new ArrayList<FoodEntity>();        //FoodList를 초과 영양성분 기준으로 내림차순 정렬해놓을 ArrayList
        ArrayList<FoodEntity> FoodList_sort_desc_temp = new ArrayList<FoodEntity>();    //ArrayList의 복사를 위한 임시 ArrayList
        ArrayList<FoodEntity> FoodList_remove = new ArrayList<FoodEntity>();        //제거한 음식들을 모아놓을 ArrayList

        FoodEntity criteria = new FoodEntity(0, "기준치", 200, 2000, 324, 55, 54, 100, 2000, 300, 15, 0.5);// 1일 영양소 기준치
        FoodEntity FoodList_sum = new FoodEntity(0, "영양성분총합", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);            //영양성분 합을 저장하기 위한 인스턴스
        FoodEntity required_nutr = new FoodEntity(0, "필요영양성분량", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);                //영양소 과다 음식을 모두 제거한 후 필요한 영양성분량

        Difference d = new Difference();    //영양성분을 뺄셈을 위한 클래스 인스턴스

        //임의로 음식 3개를 입력 (실제로는 사용자에게 임의의 여러 음식들을 입력받아야 함)

        FoodList.add(new FoodEntity(1, "라면", 200, 400, 100, 10, 6, 20, 150, 45, 1, 0.02));
        FoodList.add(new FoodEntity(2, "치킨", 800, 500, 90, 5, 7, 23, 250, 25, 2, 0.03));
        FoodList.add(new FoodEntity(3, "피자", 700, 600, 130, 6, 8, 25, 370, 43, 3, 0.09));
        FoodList.add(new FoodEntity(4, "삼겹살", 400, 330, 110, 12, 8, 20, 180, 44, 3.5, 0.06));
        FoodList.add(new FoodEntity(5, "스파게티", 650, 220, 80, 9, 7, 18, 330, 27, 5, 0.02));
        FoodList.add(new FoodEntity(6, "족발", 550, 720, 90, 7, 8, 16, 230, 16, 1, 0.08));

        for (i = 0; i < FoodList.size(); i++) {
            FoodList_sum.setNutr_cont1(FoodList_sum.getNutr_cont1() + FoodList.get(i).getNutr_cont1());
            FoodList_sum.setNutr_cont2(FoodList_sum.getNutr_cont2() + FoodList.get(i).getNutr_cont2());
            FoodList_sum.setNutr_cont3(FoodList_sum.getNutr_cont3() + FoodList.get(i).getNutr_cont3());
            FoodList_sum.setNutr_cont4(FoodList_sum.getNutr_cont4() + FoodList.get(i).getNutr_cont4());
            FoodList_sum.setNutr_cont5(FoodList_sum.getNutr_cont5() + FoodList.get(i).getNutr_cont5());
            FoodList_sum.setNutr_cont6(FoodList_sum.getNutr_cont6() + FoodList.get(i).getNutr_cont6());
            FoodList_sum.setNutr_cont7(FoodList_sum.getNutr_cont7() + FoodList.get(i).getNutr_cont7());
            FoodList_sum.setNutr_cont8(FoodList_sum.getNutr_cont8() + FoodList.get(i).getNutr_cont8());
            FoodList_sum.setNutr_cont9(FoodList_sum.getNutr_cont9() + FoodList.get(i).getNutr_cont9());
        }

        //음식 제거작업 시작
        Quick_Sort1 q = new Quick_Sort1();
        if (FoodList_sum.getNutr_cont1() > criteria.getNutr_cont1())    //열량이 기준치를 초과할 경우
        {
            FoodList_sort_desc.clear();        //기존 ArrayList 초기화

            FoodList_sort_desc_temp = q.quickSort1(FoodList,1);    //FoodList를 해당 영양소 기준으로 내림차순 정렬

            for (i = 0; i < FoodList_sort_desc_temp.size(); i++)    //ArrayList 복사
            {
                FoodList_sort_desc.add(new FoodEntity(FoodList_sort_desc_temp.get(i)));
            }

            i = 0;
            do {
                FoodList_sum = d.difference(FoodList_sum, FoodList_sort_desc.get(i));    // 해당 영양소에 대해 제일 큰 수치를 가진 0번 음식부터 제거

                for (j = 0; j < FoodList.size(); j++)        //FoodList에서도 해당 음식 제거
                {
                    if (FoodList.get(j).getId() == FoodList_sort_desc.get(i).getId()) {
                        FoodList.remove(j);
                        break;            //제거 즉시 for문 탈출
                    }
                }
                FoodList_remove.add(FoodList_sort_desc.get(i));        //제거한 음식은 제거목록에 추가
                i++;
            } while (FoodList_sum.getNutr_cont1() > criteria.getNutr_cont1());    // 여전히 수치를 초과한다면 계속 반복 제거
        }


        //여기서 getNutr_cont8은 60이 남음. FoodList 사이즈는 2


        if (FoodList_sum.getNutr_cont2() > criteria.getNutr_cont2()) {
            FoodList_sort_desc.clear();        //기존 ArrayList 초기화

            FoodList_sort_desc_temp = q.quickSort1(FoodList,2);    //FoodList를 해당 영양소 기준으로 내림차순 정렬

            for (i = 0; i < FoodList_sort_desc_temp.size(); i++)    //ArrayList 복사
            {
                FoodList_sort_desc.add(new FoodEntity(FoodList_sort_desc_temp.get(i)));
            }


            i = 0;

            do {

                FoodList_sum = d.difference(FoodList_sum, FoodList_sort_desc.get(i));    // 해당 영양소에 대해 제일 큰 수치를 가진 0번 음식부터 제거

                for (j = 0; j < FoodList.size(); j++)        //FoodList에서도 해당 음식 제거
                {
                    if (FoodList.get(j).getId() == FoodList_sort_desc.get(i).getId()) {
                        FoodList.remove(j);
                        break;            //제거 즉시 for문 탈출
                    }
                }

                FoodList_remove.add(FoodList_sort_desc.get(i));        //제거한 음식은 제거목록에 추가

                i++;

            } while (FoodList_sum.getNutr_cont2() > criteria.getNutr_cont2());    // 여전히 수치를 초과한다면 계속 반복 제거

            //해당 영양소 수치가 정상화 되었다면 while문 반복 멈추고 나옴
        }


        if (FoodList_sum.getNutr_cont3() > criteria.getNutr_cont3()) {
            FoodList_sort_desc.clear();        //기존 ArrayList 초기화

            FoodList_sort_desc_temp = q.quickSort1(FoodList,3);    //FoodList를 해당 영양소 기준으로 내림차순 정렬

            for (i = 0; i < FoodList_sort_desc_temp.size(); i++)    //ArrayList 복사
            {
                FoodList_sort_desc.add(new FoodEntity(FoodList_sort_desc_temp.get(i)));
            }


            i = 0;

            do {

                FoodList_sum = d.difference(FoodList_sum, FoodList_sort_desc.get(i));    // 해당 영양소에 대해 제일 큰 수치를 가진 0번 음식부터 제거

                for (j = 0; j < FoodList.size(); j++)        //FoodList에서도 해당 음식 제거
                {
                    if (FoodList.get(j).getId() == FoodList_sort_desc.get(i).getId()) {
                        FoodList.remove(j);
                        break;            //제거 즉시 for문 탈출
                    }
                }

                FoodList_remove.add(FoodList_sort_desc.get(i));        //제거한 음식은 제거목록에 추가

                i++;

            } while (FoodList_sum.getNutr_cont3() > criteria.getNutr_cont3());    // 여전히 수치를 초과한다면 계속 반복 제거

            //해당 영양소 수치가 정상화 되었다면 while문 반복 멈추고 나옴
        }

        //여기서 1개 더 제거되고 getNutr_cont8은 30남음


        if (FoodList_sum.getNutr_cont4() > criteria.getNutr_cont4()) {
            FoodList_sort_desc.clear();        //기존 ArrayList 초기화

            FoodList_sort_desc_temp = q.quickSort1(FoodList,4);    //FoodList를 해당 영양소 기준으로 내림차순 정렬

            for (i = 0; i < FoodList_sort_desc_temp.size(); i++)    //ArrayList 복사
            {
                FoodList_sort_desc.add(new FoodEntity(FoodList_sort_desc_temp.get(i)));
            }


            i = 0;

            do {

                FoodList_sum = d.difference(FoodList_sum, FoodList_sort_desc.get(i));    // 해당 영양소에 대해 제일 큰 수치를 가진 0번 음식부터 제거

                for (j = 0; j < FoodList.size(); j++)        //FoodList에서도 해당 음식 제거
                {
                    if (FoodList.get(j).getId() == FoodList_sort_desc.get(i).getId()) {
                        FoodList.remove(j);
                        break;            //제거 즉시 for문 탈출
                    }
                }

                FoodList_remove.add(FoodList_sort_desc.get(i));        //제거한 음식은 제거목록에 추가

                i++;

            } while (FoodList_sum.getNutr_cont4() > criteria.getNutr_cont4());    // 여전히 수치를 초과한다면 계속 반복 제거

            //해당 영양소 수치가 정상화 되었다면 while문 반복 멈추고 나옴
        }


        if (FoodList_sum.getNutr_cont5() > criteria.getNutr_cont5()) {
            FoodList_sort_desc.clear();        //기존 ArrayList 초기화

            FoodList_sort_desc_temp = q.quickSort1(FoodList,5);    //FoodList를 해당 영양소 기준으로 내림차순 정렬

            for (i = 0; i < FoodList_sort_desc_temp.size(); i++)    //ArrayList 복사
            {
                FoodList_sort_desc.add(new FoodEntity(FoodList_sort_desc_temp.get(i)));
            }


            i = 0;

            do {

                FoodList_sum = d.difference(FoodList_sum, FoodList_sort_desc.get(i));    // 해당 영양소에 대해 제일 큰 수치를 가진 0번 음식부터 제거

                for (j = 0; j < FoodList.size(); j++)        //FoodList에서도 해당 음식 제거
                {
                    if (FoodList.get(j).getId() == FoodList_sort_desc.get(i).getId()) {
                        FoodList.remove(j);
                        break;            //제거 즉시 for문 탈출
                    }
                }

                FoodList_remove.add(FoodList_sort_desc.get(i));        //제거한 음식은 제거목록에 추가

                i++;

            } while (FoodList_sum.getNutr_cont5() > criteria.getNutr_cont5());    // 여전히 수치를 초과한다면 계속 반복 제거

            //해당 영양소 수치가 정상화 되었다면 while문 반복 멈추고 나옴
        }


        if (FoodList_sum.getNutr_cont6() > criteria.getNutr_cont6()) {
            FoodList_sort_desc.clear();        //기존 ArrayList 초기화

            FoodList_sort_desc_temp = q.quickSort1(FoodList,6);    //FoodList를 해당 영양소 기준으로 내림차순 정렬

            for (i = 0; i < FoodList_sort_desc_temp.size(); i++)    //ArrayList 복사
            {
                FoodList_sort_desc.add(new FoodEntity(FoodList_sort_desc_temp.get(i)));
            }


            i = 0;

            do {

                FoodList_sum = d.difference(FoodList_sum, FoodList_sort_desc.get(i));    // 해당 영양소에 대해 제일 큰 수치를 가진 0번 음식부터 제거

                for (j = 0; j < FoodList.size(); j++)        //FoodList에서도 해당 음식 제거
                {
                    if (FoodList.get(j).getId() == FoodList_sort_desc.get(i).getId()) {
                        FoodList.remove(j);
                        break;            //제거 즉시 for문 탈출
                    }
                }

                FoodList_remove.add(FoodList_sort_desc.get(i));        //제거한 음식은 제거목록에 추가

                i++;

            } while (FoodList_sum.getNutr_cont6() > criteria.getNutr_cont6());    // 여전히 수치를 초과한다면 계속 반복 제거

            //해당 영양소 수치가 정상화 되었다면 while문 반복 멈추고 나옴
        }


        if (FoodList_sum.getNutr_cont7() > criteria.getNutr_cont7()) {
            FoodList_sort_desc.clear();        //기존 ArrayList 초기화

            FoodList_sort_desc_temp = q.quickSort1(FoodList,7);    //FoodList를 해당 영양소 기준으로 내림차순 정렬

            for (i = 0; i < FoodList_sort_desc_temp.size(); i++)    //ArrayList 복사
            {
                FoodList_sort_desc.add(new FoodEntity(FoodList_sort_desc_temp.get(i)));
            }


            i = 0;

            do {

                FoodList_sum = d.difference(FoodList_sum, FoodList_sort_desc.get(i));    // 해당 영양소에 대해 제일 큰 수치를 가진 0번 음식부터 제거

                for (j = 0; j < FoodList.size(); j++)        //FoodList에서도 해당 음식 제거
                {
                    if (FoodList.get(j).getId() == FoodList_sort_desc.get(i).getId()) {
                        FoodList.remove(j);
                        break;            //제거 즉시 for문 탈출
                    }
                }

                FoodList_remove.add(FoodList_sort_desc.get(i));        //제거한 음식은 제거목록에 추가

                i++;

            } while (FoodList_sum.getNutr_cont7() > criteria.getNutr_cont7());    // 여전히 수치를 초과한다면 계속 반복 제거

            //해당 영양소 수치가 정상화 되었다면 while문 반복 멈추고 나옴
        }


        if (FoodList_sum.getNutr_cont8() > criteria.getNutr_cont8()) {
            FoodList_sort_desc.clear();        //기존 ArrayList 초기화

            FoodList_sort_desc_temp = q.quickSort1(FoodList,8);    //FoodList를 해당 영양소 기준으로 내림차순 정렬

            for (i = 0; i < FoodList_sort_desc_temp.size(); i++)    //ArrayList 복사
            {
                FoodList_sort_desc.add(new FoodEntity(FoodList_sort_desc_temp.get(i)));
            }


            i = 0;


            do {

                FoodList_sum = d.difference(FoodList_sum, FoodList_sort_desc.get(i));    // 해당 영양소에 대해 제일 큰 수치를 가진 0번 음식부터 제거

                for (j = 0; j < FoodList.size(); j++)        //FoodList에서도 해당 음식 제거
                {
                    if (FoodList.get(j).getId() == FoodList_sort_desc.get(i).getId()) {

                        FoodList.remove(j);

                        break;            //제거 즉시 for문 탈출
                    }
                }

                FoodList_remove.add(FoodList_sort_desc.get(i));        //제거한 음식은 제거목록에 추가

                i++;

            } while (FoodList_sum.getNutr_cont8() > criteria.getNutr_cont8());    // 여전히 수치를 초과한다면 계속 반복 제거

            //해당 영양소 수치가 정상화 되었다면 while문 반복 멈추고 나옴
        }

        //여기서 나머지 1개까지 모두 제거완료, getNutr_cont8은 0이됨

        if (FoodList_sum.getNutr_cont9() > criteria.getNutr_cont9()) {
            FoodList_sort_desc.clear();        //기존 ArrayList 초기화

            FoodList_sort_desc_temp = q.quickSort1(FoodList,9);    //FoodList를 해당 영양소 기준으로 내림차순 정렬

            for (i = 0; i < FoodList_sort_desc_temp.size(); i++)    //ArrayList 복사
            {
                FoodList_sort_desc.add(new FoodEntity(FoodList_sort_desc_temp.get(i)));
            }


            i = 0;

            do {
                FoodList_sum = d.difference(FoodList_sum, FoodList_sort_desc.get(i));    // 해당 영양소에 대해 제일 큰 수치를 가진 0번 음식부터 제거

                for (j = 0; j < FoodList.size(); j++)        //FoodList에서도 해당 음식 제거
                {
                    if (FoodList.get(j).getId() == FoodList_sort_desc.get(i).getId()) {
                        FoodList.remove(j);
                        break;            //제거 즉시 for문 탈출
                    }
                }
                FoodList_remove.add(FoodList_sort_desc.get(i));        //제거한 음식은 제거목록에 추가

                i++;

            } while (FoodList_sum.getNutr_cont9() > criteria.getNutr_cont9());    // 여전히 수치를 초과한다면 계속 반복 제거

            //해당 영양소 수치가 정상화 되었다면 while문 반복 멈추고 나옴
        }
        required_nutr = d.difference(criteria, FoodList_sum);    //1일 기준치와 영양소 과다음식 제거 후 남은 영양성분 수치의 차를 구하여 최종적으로 필요해진 영양소량 계산
        FoodList_remove.add(required_nutr);
        return FoodList_remove;
    }
}


