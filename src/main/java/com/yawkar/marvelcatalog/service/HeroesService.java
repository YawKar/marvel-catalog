package com.yawkar.marvelcatalog.service;

import com.yawkar.marvelcatalog.dto.HeroDTO;
import com.yawkar.marvelcatalog.entity.Hero;
import com.yawkar.marvelcatalog.repository.HeroesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
