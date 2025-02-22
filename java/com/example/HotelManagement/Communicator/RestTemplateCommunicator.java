package com.example.HotelManagement.Communicator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateCommunicator {
    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateCommunicator(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Float getActualRating(Long hotelId){
        String url="http://localhost:8084/rating/getrating/"+hotelId;
        ResponseEntity<Float> hotelRating=restTemplate.getForEntity(url,Float.class);
        return hotelRating.getBody();
    }
}
