package com.example.JacalKinopoisk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.stream.Collectors;
import java.util.List;

@Entity
@Table(name = "films")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class film {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "year")
    private Integer year;

    @Column(name = "description", length = 5000)
    private String description;

    @Column(name = "short_description", length = 5000)
    private String short_description;

    @Column(name = "slogan", length = 5000)
    private String slogan;

    @Column(name = "movie_length")
    private Integer movieLength;

    @Column(name = "age_rating")
    private Integer ageRating;

    @Column(name = "rating_kp")
    private Float ratingKp;

    @Column(name = "rating_imdb")
    private Float ratingImdb;

    @Column(name = "rating_film_critics")
    private Float ratingFilmCritics;

    @Column(name = "poster_url", length = 5000)
    private String posterUrl;

    @ElementCollection
    @CollectionTable(name = "movie_countries", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "country")
    private List<String> countries;

    @ElementCollection
    @CollectionTable(name = "movie_genres", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "genre")
    private List<String> genre;

    @Data
    public static class Country{
        private String name;
    }

    @Data
    public static class Genre{
        private String name;
    }

    @Data
    public static class Poster{
        private String url;
    }

    @Data
    public static class Rating{
        private Float kp;
        private Float imdb;
        private Float filmCritics;
    }

    @JsonProperty("countries")
    private void deserializationCountries(List<Country> countriesAPI){
        this.countries = countriesAPI.stream().map(Country::getName).collect(Collectors.toList());
    }

    @JsonProperty("genres")
    private void deserializationGenres(List<Genre> genresAPI) {
        this.genre = genresAPI.stream().map(Genre::getName).collect(Collectors.toList());
    }
}
