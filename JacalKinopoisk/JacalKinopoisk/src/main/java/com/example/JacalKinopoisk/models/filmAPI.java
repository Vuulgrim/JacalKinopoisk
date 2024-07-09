package com.example.JacalKinopoisk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class filmAPI {
    @JsonProperty("docs")
    private List<film> films;
    private int total;
    private int limit;
    private int page;
    private int pages;
}
