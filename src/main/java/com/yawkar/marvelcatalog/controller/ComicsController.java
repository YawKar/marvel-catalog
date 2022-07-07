package com.yawkar.marvelcatalog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/public/comics")
public class ComicsController {

    @GetMapping
    public String getAllComics() {
        return "Woo-Hoo-Hoo";
    }

    @GetMapping("/{comicId}")
    public String getComicById(@PathVariable String comicId) {
        return "Woo-Hoo-Hoo, where is the comic with id: %s?".formatted(comicId);
    }

    @GetMapping("/{comicId}/characters")
    public String getAllCharactersByComicId(@PathVariable String comicId) {
        return "Woo-Hoo-Hoo, where are all characters from the comic with id: %s?".formatted(comicId);
    }
}
