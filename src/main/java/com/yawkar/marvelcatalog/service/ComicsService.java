package com.yawkar.marvelcatalog.service;

import com.yawkar.marvelcatalog.repository.ComicsRepository;
import org.springframework.stereotype.Service;

@Service
public class ComicsService {

    private final ComicsRepository comicsRepository;

    public ComicsService(ComicsRepository comicsRepository) {
        this.comicsRepository = comicsRepository;
    }
}
