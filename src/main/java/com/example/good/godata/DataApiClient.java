//package com.example.good.godata;
//
//
//import com.example.good.foodlist.repository.FoodListRepository;
//import com.example.good.godata.dto.SearchReq;
//import com.example.good.godata.dto.SearchRes;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.client.ClientHttpResponse;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//@Service
//public class DataApiClient {
//    private final RestTemplate restTemplate;
//    private final FoodListRepository foodListRepository;
//
//    @Value("${godata.client.servicekey}")
//    private StringBuilder serviceKey;
//
//    @Value("${godata.url.search}")
//    private String godataSearchUrl;
//
//    @Autowired
//    public DataApiClient(RestTemplate resTemplate, FoodListRepository foodListRepository) {
//        this.restTemplate = resTemplate;
//        this.foodListRepository = foodListRepository;
//    }
//
//
//    public SearchRes requestFood(SearchReq searchReq) {
//        var uri = UriComponentsBuilder.fromUriString(godataSearchUrl)
//                .queryParam("serviceKey",serviceKey)
//                .queryParams(searchReq.toMultiValueMap())
//                .build()
//                //.encode()
//                //.toUri();
//                .toUriString();
//
//        restTemplate.getInterceptors().add((request, body, execution) -> {
//            ClientHttpResponse response = execution.execute(request, body);
//            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
//            return response;
//        });
//        final HttpHeaders headers = new HttpHeaders();
//        final HttpEntity<?> entity = new HttpEntity<>(headers);
//
//        SearchRes body = restTemplate.exchange(uri, HttpMethod.GET, entity, SearchRes.class).getBody();
//        return body;
//    }
//}
