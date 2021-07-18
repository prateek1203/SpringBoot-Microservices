package com.example.movieinfoservice.controllers;

import com.example.movieinfoservice.entity.Movie;
import com.example.movieinfoservice.entity.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {
    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("{movieId}")
    public Movie getMovieInfo (@PathVariable String movieId){
        String url = "https://api.themoviedb.org/3/movie/" + movieId +"?api_key="+apiKey;
        MovieSummary summary = restTemplate.getForObject(url, MovieSummary.class);
        return new Movie("1", summary.getTitle(), summary.getOverview());
    }
}

