package com.yawkar.marvelcatalog.service;

import com.yawkar.marvelcatalog.entity.Comic;
import com.yawkar.marvelcatalog.entity.Hero;
import com.yawkar.marvelcatalog.repository.ComicsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicsServiceImpl implements ComicsService<Long> {

    private final ComicsRepository comicsRepository;

    public ComicsServiceImpl(ComicsRepository comicsRepository) {
        this.comicsRepository = comicsRepository;
    }

    @Override
    public Comic addComic(Comic comic) {
        return null;
    }

    @Override
    public Comic updateComic(Comic comic, Long id) {
        return null;
    }

    @Override
    public List<Comic> getAllComics() {
        return null;
    }

    @Override
    public Comic getComicById(Long id) {
        return null;
    }

    @Override
    public List<Hero> getHeroesFromComicById(Long id) {
        return null;
    }
}
