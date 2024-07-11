package com.example.JacalKinopoiskUser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class film {
    private Long id;
    private String name;
    private String type;
    private Integer year;
    private String descriprion;
    private String shortDescription;
    private String slogan;
    private Integer movieLength;
    private Integer ageRating;
    private Float rattingKp;
    private Float rattingImdb;
    private Float ratingFilmCritics;
    private String posterUrl;
    private List<String> countries;
    private List<String> genre;
}
