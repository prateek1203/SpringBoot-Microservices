package com.example.moviecatalogservice.controllers;

import com.example.moviecatalogservice.entity.CatalogItem;
import com.example.moviecatalogservice.entity.Rating;
import com.example.moviecatalogservice.entity.UserRating;
import com.example.moviecatalogservice.services.MovieInfo;
import com.example.moviecatalogservice.services.UserRatingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogs")
public class MovieCatalogController {

    @Autowired
    private WebClient.Builder builder;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MovieInfo movieInfo;

    @Autowired
    private UserRatingInfo userRatingInfo;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalaogForUserId(@PathVariable String userId) {
//        UserRating userRating = builder.build()
//                .get()
//                .uri("http://rating-data-service/ratings/users/" + userId)
//                .retrieve()
//                .bodyToMono(UserRating.class)
//                .block();
        UserRating userRating = userRatingInfo.getUserRatings(userId);
        return userRating.getRatings().stream().map(rating -> movieInfo.getCatalogItem(rating)).collect(Collectors.toList());
    }
}
