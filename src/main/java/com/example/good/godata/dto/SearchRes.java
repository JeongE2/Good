package com.example.good.godata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRes {
    private Searchbody body;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Searchbody {
        private int pageNo;
        private int totalCount;
        private int numOfRows;
        private List<Object> items;

    }
}