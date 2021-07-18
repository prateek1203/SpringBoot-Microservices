package com.example.ratingdataservice.controllers;

import com.example.ratingdataservice.entity.Rating;
import com.example.ratingdataservice.entity.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable String movieId) {
        return new Rating("1", 4);
    }

    @GetMapping("/users/{userId}")
    public UserRating getRatings(@PathVariable String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("120", 4),
                new Rating("550", 3)
        );
        UserRating userRating = new UserRating();
        userRating.setRatings(ratings);
        return userRating;
    }
}
