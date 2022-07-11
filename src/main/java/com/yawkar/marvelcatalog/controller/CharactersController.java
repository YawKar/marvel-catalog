package com.yawkar.marvelcatalog.controller;

import com.yawkar.marvelcatalog.dto.HeroDTO;
import com.yawkar.marvelcatalog.service.HeroesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/v1/public/characters")
public class CharactersController {

    private final HeroesService heroesService;

    public CharactersController(HeroesService heroesService) {
        this.heroesService = heroesService;
    }

    @GetMapping
    public String getAllHeroes() {
        return "Woo-Hoo-Hoo";
    }

    @GetMapping("/{heroId}")
    public String getHeroById(@PathVariable long heroId) {
        return "Woo-Hoo-Hoo, where is the hero with id: %s?".formatted(heroId);
    }

    @GetMapping("/{heroId}/comics")
    public String getAllComicsByHeroId(@PathVariable long heroId) {
        return "Woo-Hoo-Hoo, where are all comics with the hero with id: %s?".formatted(heroId);
    }

    @PostMapping
    public HeroDTO postNewHero(@Valid @RequestBody HeroDTO heroDTO) {
        return heroesService.insertNewHero(heroDTO);
    }
}
