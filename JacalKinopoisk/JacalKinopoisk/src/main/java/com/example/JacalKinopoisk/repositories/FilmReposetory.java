package com.example.JacalKinopoisk.repositories;

import com.example.JacalKinopoisk.models.film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmReposetory extends JpaRepository<film, Long> {
}
