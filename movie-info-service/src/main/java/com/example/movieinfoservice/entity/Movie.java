package com.example.movieinfoservice.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Movie {
    private String movieId;
    private String title;
    private String overview;

}
