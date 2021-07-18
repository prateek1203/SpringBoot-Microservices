package com.example.moviecatalogservice.services;

import com.example.moviecatalogservice.entity.CatalogItem;
import com.example.moviecatalogservice.entity.Rating;
import com.example.moviecatalogservice.entity.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserRatingInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackUserRating",
        commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
        }
    )
    public UserRating getUserRatings(String userId) {
        return restTemplate.getForObject("http://rating-data-service/ratings/users/" + userId, UserRating.class);
    }

    private UserRating getFallbackUserRating(String userId) {
        return new UserRating(Arrays.asList(
                new Rating("101", 0),
                new Rating("203", 0)
        ));
    }
}
