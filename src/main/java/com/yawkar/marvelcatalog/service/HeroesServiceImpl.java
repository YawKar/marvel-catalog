package com.yawkar.marvelcatalog.service;

import com.yawkar.marvelcatalog.entity.Comic;
import com.yawkar.marvelcatalog.entity.Hero;
import com.yawkar.marvelcatalog.exception.HeroNotFoundException;
import com.yawkar.marvelcatalog.repository.ComicsRepository;
import com.yawkar.marvelcatalog.repository.HeroesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroesServiceImpl implements HeroesService {

    private final HeroesRepository heroesRepository;
    private final ComicsRepository comicsRepository;

    public HeroesServiceImpl(HeroesRepository heroesRepository, ComicsRepository comicsRepository) {
        this.heroesRepository = heroesRepository;
        this.comicsRepository = comicsRepository;
    }

    @Override
    public Hero addHero(Hero hero) {
        hero.setId(0L);
        return heroesRepository.save(hero);
    }

    @Override
    public Hero updateHero(Hero hero, long heroId) {
        if (!heroesRepository.existsById(heroId)) {
            throw new HeroNotFoundException("Hero with heroId=%d not found".formatted(heroId));
        }
        hero.setId(heroId);
        return heroesRepository.save(hero);
    }

    @Override
    public List<Hero> getAllHeroes() {
        return heroesRepository.findAll();
    }

    @Override
    public Hero getHeroById(long heroId) {
        return heroesRepository.findById(heroId)
                .orElseThrow(() -> new HeroNotFoundException("Hero with heroId=%d not found".formatted(heroId)));
    }

    @Override
    public List<Comic> getComicsWithHeroById(long heroId) {
        return heroesRepository.findById(heroId)
                .orElseThrow(() -> new HeroNotFoundException("Hero with heroId=%d not found".formatted(heroId)))
                .getComicsInWhichPresent().stream().toList();
    }

    @Override
    public void updateComicsWithHero(List<Long> comicIds, long heroId) {
        Hero hero = heroesRepository.findById(heroId)
                .orElseThrow(() -> new HeroNotFoundException("Hero with heroId=%d not found".formatted(heroId)));
        hero.getComicsInWhichPresent().addAll(comicsRepository.findAllById(comicIds));
        heroesRepository.save(hero);
    }
}
