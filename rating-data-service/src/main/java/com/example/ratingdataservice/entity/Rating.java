package com.example.ratingdataservice.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Rating {
    private String movieId;
    private int rating;
}
