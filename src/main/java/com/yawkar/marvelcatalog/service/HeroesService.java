package com.yawkar.marvelcatalog.service;

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
}
