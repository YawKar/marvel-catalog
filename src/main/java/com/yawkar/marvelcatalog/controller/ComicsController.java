package com.yawkar.marvelcatalog.controller;

import com.yawkar.marvelcatalog.dto.ComicDTO;
import com.yawkar.marvelcatalog.dto.HeroDTO;
import com.yawkar.marvelcatalog.service.ComicsService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/public/comics")
public class ComicsController {

    private final ComicsService comicsService;

    public ComicsController(ComicsService comicsService) {
        this.comicsService = comicsService;
    }

    @GetMapping
    public List<ComicDTO> getAllComics() {
        return comicsService.findAllComics();
    }

    @GetMapping("/{comicId}")
    public ComicDTO getComicById(@PathVariable long comicId) {
        return comicsService.findComicById(comicId);
    }

    @GetMapping("/{comicId}/characters")
    public List<HeroDTO> getAllHeroesByComicId(@PathVariable long comicId) {
        return comicsService.findAllHeroesByComicId(comicId);
    }

    @PostMapping
    public ComicDTO postNewComic(@Valid @RequestBody ComicDTO comicDTO) {
        return comicsService.insertNewComic(comicDTO);
    }

    @PutMapping
    public ComicDTO putComic(@Valid @RequestBody ComicDTO comicDTO) {
        return comicsService.updateComic(comicDTO);
    }
}
