package com.example.good.godata;


import com.example.good.godata.dto.SearchReq;
import com.example.good.godata.dto.SearchRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class DataClient {

    @Value("${godata.client.servicekey}")
    private StringBuilder serviceKey;

    @Value("${godata.url.search}")
    private String godataSearchUrl;

    public SearchRes search(SearchReq searchReq){//SearchRes

        var uri = UriComponentsBuilder.fromUriString(godataSearchUrl)
                .queryParam("serviceKey",serviceKey)
                .queryParams(searchReq.toMultiValueMap())
                .build()
                //.encode()
                //.toUri();
                .toUriString();
        URI godUri = URI.create(uri);

        System.out.println(uri);
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Accept", "*/*;q=0.9");
        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<SearchRes>(){};//

        var responseEntity = new RestTemplate().exchange(
                godUri,
                HttpMethod.GET,
                httpEntity,
                //String.class
                responseType
        );
        return responseEntity.getBody();
    }
}
