package com.example.JacalKinopoisk.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SiteController {
    @GetMapping("/")
    public String films() {
        return "films";
    }
}
