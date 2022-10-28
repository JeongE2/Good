package com.example.good.godata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchReq {

    private String desc_kor = "";

    private int numOfRows = 1;

    private String type = "json";

    private String en_desc = "";

    public void setDesc_kor(String desc_kor) {
        this.desc_kor = desc_kor;
        try {
            en_desc = URLEncoder.encode(desc_kor,"utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public MultiValueMap<String, String> toMultiValueMap(){
        var map = new LinkedMultiValueMap<String, String>();

        map.add("desc_kor", en_desc);
        map.add("numOfRows",String.valueOf(numOfRows));
        map.add("type",type);
        return map;
    }
}