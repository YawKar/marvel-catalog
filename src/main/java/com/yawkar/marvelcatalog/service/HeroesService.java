package com.yawkar.marvelcatalog.service;

import com.yawkar.marvelcatalog.dto.ComicDTO;
import com.yawkar.marvelcatalog.dto.HeroDTO;
import com.yawkar.marvelcatalog.entity.Hero;
import com.yawkar.marvelcatalog.repository.HeroesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeroesService {

    private final HeroesRepository heroesRepository;
    private final ModelMapper modelMapper;

    public HeroesService(HeroesRepository heroesRepository, ModelMapper modelMapper) {
        this.heroesRepository = heroesRepository;
        this.modelMapper = modelMapper;
    }

    public HeroDTO insertNewHero(HeroDTO heroDTO) {
        Hero hero = modelMapper.map(heroDTO, Hero.class);
        return modelMapper.map(heroesRepository.save(hero), HeroDTO.class);
    }

    public List<HeroDTO> findAllHeroes() {
        List<HeroDTO> heroDTOS = new ArrayList<>();
        heroesRepository.findAll().forEach(hero -> heroDTOS.add(modelMapper.map(hero, HeroDTO.class)));
        return heroDTOS;
    }

    public HeroDTO findHeroById(long heroId) {
        return modelMapper.map(
                heroesRepository.findById(heroId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)),
            HeroDTO.class);
    }

    public List<ComicDTO> findAllComicsByHeroId(long heroId) {
        List<ComicDTO> comicDTOS = new ArrayList<>();
        heroesRepository.findById(heroId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                .getComicsInWhichPresent()
                .forEach(comic -> comicDTOS.add(modelMapper.map(comic, ComicDTO.class)));
        return comicDTOS;
    }
}
