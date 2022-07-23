package com.yawkar.marvelcatalog.service;

import com.yawkar.marvelcatalog.repository.entity.Comic;
import com.yawkar.marvelcatalog.repository.entity.Hero;

import java.util.List;

public interface HeroesService {

    Hero addHero(Hero hero);
    Hero updateHero(Hero hero, long heroId);
    List<Hero> getAllHeroes();
    Hero getHeroById(long heroId);
    List<Comic> getComicsWithHeroById(long heroId);
    void updateComicsWithHero(List<Long> comicIds, long heroId);
}
