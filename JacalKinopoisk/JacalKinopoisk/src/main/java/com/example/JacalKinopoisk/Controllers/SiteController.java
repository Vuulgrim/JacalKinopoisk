package com.example.JacalKinopoisk.Controllers;

import com.example.JacalKinopoisk.models.film;
import com.example.JacalKinopoisk.services.filmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class SiteController {
    private final filmService FilmService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public film getById(@PathVariable("id") Long id) {
        return FilmService.getById(id);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<film> getByPageName(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "name") String name
    ) {
        return FilmService.getByPageByName(page, limit, name);
    }
}
