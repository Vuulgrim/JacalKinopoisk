package com.example.JacalKinopoisk.repositories;

import com.example.JacalKinopoisk.models.film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilmReposetory extends JpaRepository<film, Long> {
}
