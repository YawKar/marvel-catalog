package com.yawkar.marvelcatalog.service;

import com.yawkar.marvelcatalog.entity.Comic;
import com.yawkar.marvelcatalog.entity.Hero;

import java.util.List;

public interface HeroesService<T> {

    Hero addHero(Hero hero);
    Hero updateHero(Hero hero);
    List<Hero> getAllHeroes();
    Hero getHeroById(T id);
    List<Comic> getComicsWithHeroById(T id);
}
