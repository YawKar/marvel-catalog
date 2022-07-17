package com.yawkar.marvelcatalog.service;

import com.yawkar.marvelcatalog.entity.Comic;
import com.yawkar.marvelcatalog.entity.Hero;
import com.yawkar.marvelcatalog.repository.HeroesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroesServiceImpl implements HeroesService {

    private final HeroesRepository heroesRepository;

    public HeroesServiceImpl(HeroesRepository heroesRepository) {
        this.heroesRepository = heroesRepository;
    }

    @Override
    public Hero addHero(Hero hero) {
        return null;
    }

    @Override
    public Hero updateHero(Hero hero, long heroId) {
        return null;
    }

    @Override
    public List<Hero> getAllHeroes() {
        return null;
    }

    @Override
    public Hero getHeroById(long heroId) {
        return null;
    }

    @Override
    public List<Comic> getComicsWithHeroById(long heroId) {
        return null;
    }

    @Override
    public void updateComicsWithHero(List<Long> comicIds, long heroId) {

    }
}
