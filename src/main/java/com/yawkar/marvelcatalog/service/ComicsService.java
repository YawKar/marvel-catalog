package com.yawkar.marvelcatalog.service;

import com.yawkar.marvelcatalog.entity.Comic;
import com.yawkar.marvelcatalog.entity.Hero;

import java.util.List;

public interface ComicsService<T> {

    Comic addComic(Comic comic);
    Comic updateComic(Comic comic);
    List<Comic> getAllComics();
    Comic getComicById(T id);
    List<Hero> getHeroesFromComicById(T id);
}
