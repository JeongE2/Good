package com.example.good.godata;

import com.example.good.godata.dto.SearchReq;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataClientTest {
    @Autowired
    private DataClient dataClient;

    @Test
    public void searchTest(){

        var search = new SearchReq();
        search.setDesc_kor("갈비");

        //System.out.println(search.toString());

        var result = dataClient.search(search);


        System.out.println("결과는 " + result);
        ///*
        if (result.getBody().getTotalCount() > 0) {
            var item = result.getBody().getItems();
            //var imageQuery = localItem.getTitle().replaceAll("<[^>]*>", "");

            System.out.println("result = " + item.toString());
            System.out.println(item.get(0));
        }//*/
        //System.out.println(result);
        //Assertions.assertNotNull(result.getItems().stream().findFirst().get().getServing_wt());
    }
}
