package com.example.JacalKinopoiskUser.web;

import com.example.JacalKinopoiskUser.model.film;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "KinopoiskApiUser", url = "https://localhost:8080/films")
public interface KinopoiskApiUser {
    @GetMapping("/{id}")
    film findById(@PathVariable("id") Long id);

    @GetMapping("/search")
    List<film> findByPageByName(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "name") String name
    );
}
