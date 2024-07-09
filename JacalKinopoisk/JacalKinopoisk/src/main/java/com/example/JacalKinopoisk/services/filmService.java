package com.example.JacalKinopoisk.services;

import com.example.JacalKinopoisk.config.KinopoiskAPI;
import com.example.JacalKinopoisk.models.film;
import com.example.JacalKinopoisk.repositories.FilmReposetory;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class filmService {
    private final FilmReposetory filmReposetory;
    private final KinopoiskAPI kinopoiskAPI;

    public film getById(Long id) {
        film Film = filmReposetory.findById(id).or(() -> findWithApiById(id)).orElseThrow(() -> new RuntimeException("Film doesnt exist with id: " + id));
        filmReposetory.save(Film);
        return Film;
    }

    public List<film> getByPageByName(int page, int limit, String name) {
        List<film> filmList = findWithApiByPageByName(page, limit, name);
        filmReposetory.saveAll(filmList);
        return filmList;
    }

    private Optional<film>findWithApiById(Long id) {
        Optional<film> Film = Optional.empty();
        try {
            Film = kinopoiskAPI.findById(id);
        } catch (FeignException e) {
            //
        }
        return Film;
    }


    private List<film> findWithApiByPageByName(int page, int limit, String name) {
        return kinopoiskAPI.findByPageByName(page,limit,name).getFilms();
    }
}
