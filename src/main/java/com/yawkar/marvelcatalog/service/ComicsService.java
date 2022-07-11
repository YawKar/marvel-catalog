package com.yawkar.marvelcatalog.service;

import com.yawkar.marvelcatalog.dto.ComicDTO;
import com.yawkar.marvelcatalog.entity.Comic;
import com.yawkar.marvelcatalog.repository.ComicsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
