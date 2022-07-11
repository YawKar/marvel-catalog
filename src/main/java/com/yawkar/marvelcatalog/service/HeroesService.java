package com.yawkar.marvelcatalog.service;

import com.yawkar.marvelcatalog.repository.HeroesRepository;
import org.springframework.stereotype.Service;

@Service
public class HeroesService {

    private final HeroesRepository heroesRepository;

    public HeroesService(HeroesRepository heroesRepository) {
        this.heroesRepository = heroesRepository;
    }
}
