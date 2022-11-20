package com.example.good.domain.food;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;                  // 식품이름

    @Column(nullable = false)
    private int serving_wt;                   // 1회제공량 (g)

    @Column(nullable = false)
    private String nutr_cont1;                 //열량 (kcal)

    @Column(nullable = true)
    private String nutr_cont2;                 //탄수화물 (g)

    @Column(nullable = true)
    private String nutr_cont3;                 //단백질 (g)

    @Column(nullable = true)
    private String nutr_cont4;                 //지방 (g)

    @Column(nullable = true)
    private String nutr_cont5;                 //당류 (g)

    @Column(nullable = true)
    private String nutr_cont6;                 //나트륨 (mg)

    @Column(nullable = true)
    private String nutr_cont7;                 //콜레스테롤 (mg)

    @Column(nullable = true)
    private String nutr_cont8;                 //포화지방산 (g)

    @Column(nullable = true)
    private String nutr_cont9;                 //트랜스지방산 (g)

    //@Column(nullable = true, length = 30)
    //private String bgn_year;                   //구축년도

    //@Column(nullable = true, length = 30)
    //private String animal_plant;               //가공업체

}
