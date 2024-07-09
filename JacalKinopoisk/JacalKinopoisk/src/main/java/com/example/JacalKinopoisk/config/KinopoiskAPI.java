package com.example.JacalKinopoisk.config;

import com.example.JacalKinopoisk.models.film;
import com.example.JacalKinopoisk.models.filmAPI;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name = "KinopoiskAPI", url = "https://api.kinopoisk.dev", configuration = FeignConfig.class)
public interface KinopoiskAPI {

    @GetMapping("/v1.4/movie/{id}")
    Optional<film> findById(@PathVariable("id") Long id);

    @GetMapping("/v1.4/movie/search")
    filmAPI findByPageByName(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "query") String name
    );

    @GetMapping("/v1.4/movie")
    filmAPI findByPageByRatingKp(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "rating.kp") String rating
    );

    @GetMapping("/v1.4/movie")
    filmAPI findByPageByGenres(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "genres.name") String genre
    );
}
