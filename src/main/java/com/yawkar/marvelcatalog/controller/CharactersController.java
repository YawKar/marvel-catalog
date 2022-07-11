package com.yawkar.marvelcatalog.controller;

import com.yawkar.marvelcatalog.dto.HeroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/v1/public/characters")
public class CharactersController {

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
    public ResponseEntity<Map<String, Long>> postNewHero(@Valid @RequestBody HeroDTO heroDTO) {
        return new ResponseEntity<>(Map.of("id", 1L), HttpStatus.OK);
    }
}
