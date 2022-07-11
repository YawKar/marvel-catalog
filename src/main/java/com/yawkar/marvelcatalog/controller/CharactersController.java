package com.yawkar.marvelcatalog.controller;

import com.yawkar.marvelcatalog.dto.ComicDTO;
import com.yawkar.marvelcatalog.dto.HeroDTO;
import com.yawkar.marvelcatalog.service.HeroesService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/public/characters")
public class CharactersController {

    private final HeroesService heroesService;

    public CharactersController(HeroesService heroesService) {
        this.heroesService = heroesService;
    }

    @GetMapping
    public List<HeroDTO> getAllHeroes() {
        return heroesService.findAllHeroes();
    }

    @GetMapping("/{heroId}")
    public HeroDTO getHeroById(@PathVariable long heroId) {
        return heroesService.findHeroById(heroId);
    }

    @GetMapping("/{heroId}/comics")
    public List<ComicDTO> getAllComicsByHeroId(@PathVariable long heroId) {
        return heroesService.findAllComicsByHeroId(heroId);
    }

    @PostMapping
    public HeroDTO postNewHero(@Valid @RequestBody HeroDTO heroDTO) {
        return heroesService.insertNewHero(heroDTO);
    }
}
