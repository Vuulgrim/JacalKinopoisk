package com.example.JacalKinopoiskUser.web;

import com.example.JacalKinopoiskUser.model.film;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/films")
public class filmController {
    private KinopoiskApiUser kinopoiskApiUser;

    @Operation(summary = "find film")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Найденный фильм",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = film.class))})})

    @GetMapping("/{id}")
    public film getById(@Parameter(description = "ID") @PathVariable("id") Long id) {
        return kinopoiskApiUser.findById(id);
    }

    @Operation(summary = "show films")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список фильмов",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = film.class))})
    })

    @GetMapping("/search")
    public List<film> getByPageName(
            @Parameter(description = "Страница выборки") @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @Parameter(description = "Кол-во элементов на странице") @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @Parameter(description = "Название") @RequestParam(value = "name") String name
    ) {
        return kinopoiskApiUser.findByPageByName(page, limit, name);
    }
}
