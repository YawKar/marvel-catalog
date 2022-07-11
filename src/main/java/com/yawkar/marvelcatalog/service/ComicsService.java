package com.yawkar.marvelcatalog.service;

import com.yawkar.marvelcatalog.dto.ComicDTO;
import com.yawkar.marvelcatalog.dto.HeroDTO;
import com.yawkar.marvelcatalog.entity.Comic;
import com.yawkar.marvelcatalog.repository.ComicsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComicsService {

    private final ComicsRepository comicsRepository;
    private final ModelMapper modelMapper;

    public ComicsService(ComicsRepository comicsRepository, ModelMapper modelMapper) {
        this.comicsRepository = comicsRepository;
        this.modelMapper = modelMapper;
    }

    public ComicDTO insertNewComic(ComicDTO comicDTO) {
        Comic comic = modelMapper.map(comicDTO, Comic.class);
        return modelMapper.map(comicsRepository.save(comic), ComicDTO.class);
    }

    public List<ComicDTO> findAllComics() {
        List<ComicDTO> comicDTOS = new ArrayList<>();
        comicsRepository.findAll().forEach(comic -> comicDTOS.add(modelMapper.map(comic, ComicDTO.class)));
        return comicDTOS;
    }

    public ComicDTO findComicById(long comicId) {
        return modelMapper.map(
                comicsRepository.findById(comicId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)),
                ComicDTO.class);
    }

    public List<HeroDTO> findAllHeroesByComicId(long comicId) {
        List<HeroDTO> heroDTOS = new ArrayList<>();
        comicsRepository.findById(comicId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                .getHeroesPresent()
                .forEach(hero -> heroDTOS.add(modelMapper.map(hero, HeroDTO.class)));
        return heroDTOS;
    }
}
