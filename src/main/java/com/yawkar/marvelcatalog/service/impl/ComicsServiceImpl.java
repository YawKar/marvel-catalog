package com.yawkar.marvelcatalog.service.impl;

import com.yawkar.marvelcatalog.repository.entity.Comic;
import com.yawkar.marvelcatalog.repository.entity.Hero;
import com.yawkar.marvelcatalog.configuration.exception.ComicNotFoundException;
import com.yawkar.marvelcatalog.repository.ComicsRepository;
import com.yawkar.marvelcatalog.service.ComicsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ComicsServiceImpl implements ComicsService {

    private final ComicsRepository comicsRepository;

    @Override
    public Comic addComic(Comic comic) {
        return comicsRepository.save(comic);
    }

    @Override
    public Comic updateComic(Comic comic, long comicId) {
        if (!comicsRepository.existsById(comicId)) {
            throw new ComicNotFoundException("Comic with comicId=%d not found".formatted(comicId));
        }
        comic.setId(comicId);
        return comicsRepository.save(comic);
    }

    @Override
    public List<Comic> getAllComics() {
        return comicsRepository.findAll();
    }

    @Override
    public Comic getComicById(long comicId) {
        return comicsRepository.findById(comicId)
                .orElseThrow(() -> new ComicNotFoundException("Comic with comicId=%d not found".formatted(comicId)));
    }

    @Override
    public List<Hero> getHeroesFromComicById(long comicId) {
        return comicsRepository.findById(comicId)
                .orElseThrow(() -> new ComicNotFoundException("Comic with comicId=%d not found".formatted(comicId)))
                .getHeroesPresent().stream().toList();
    }

    @Override
    public void deleteComicById(long id) {
        if (!comicsRepository.existsById(id))
            throw new ComicNotFoundException("Comic with comicId=%d not found".formatted(id));
        comicsRepository.deleteById(id);
    }
}
