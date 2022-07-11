package com.yawkar.marvelcatalog.service;

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
}
