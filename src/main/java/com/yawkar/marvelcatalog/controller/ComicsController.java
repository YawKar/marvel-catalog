package com.yawkar.marvelcatalog.controller;

import com.yawkar.marvelcatalog.dto.ComicDTO;
import com.yawkar.marvelcatalog.service.ComicsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/v1/public/comics")
public class ComicsController {

    private final ComicsService comicsService;

    public ComicsController(ComicsService comicsService) {
        this.comicsService = comicsService;
    }

    @GetMapping
    public String getAllComics() {
        return "Woo-Hoo-Hoo";
    }

    @GetMapping("/{comicId}")
    public String getComicById(@PathVariable String comicId) {
        return "Woo-Hoo-Hoo, where is the comic with id: %s?".formatted(comicId);
    }

    @GetMapping("/{comicId}/characters")
    public String getAllHeroesByComicId(@PathVariable String comicId) {
        return "Woo-Hoo-Hoo, where are all heroes from the comic with id: %s?".formatted(comicId);
    }

    @PostMapping
    public ResponseEntity<Map<String, Long>> postNewComic(@Valid @RequestBody ComicDTO comicDTO) {
        return new ResponseEntity<>(Map.of("id", comicsService.insertNewComic(comicDTO)), HttpStatus.OK);
    }
}
