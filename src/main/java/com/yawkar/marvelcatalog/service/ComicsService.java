package com.yawkar.marvelcatalog.service;

import com.yawkar.marvelcatalog.repository.entity.Comic;
import com.yawkar.marvelcatalog.repository.entity.Hero;

import java.util.List;

public interface ComicsService {

    Comic addComic(Comic comic);
    Comic updateComic(Comic comic, long id);
    List<Comic> getAllComics();
    Comic getComicById(long id);
    List<Hero> getHeroesFromComicById(long id);
}
