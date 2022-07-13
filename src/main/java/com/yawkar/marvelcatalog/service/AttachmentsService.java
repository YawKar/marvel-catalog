package com.yawkar.marvelcatalog.service;

import com.yawkar.marvelcatalog.dto.AttachmentDTO;
import com.yawkar.marvelcatalog.entity.Hero;
import com.yawkar.marvelcatalog.repository.ComicsRepository;
import com.yawkar.marvelcatalog.repository.HeroesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.function.Supplier;

@Service
public class AttachmentsService {

    private final HeroesRepository heroesRepository;
    private final ComicsRepository comicsRepository;

    public AttachmentsService(HeroesRepository heroesRepository, ComicsRepository comicsRepository) {
        this.heroesRepository = heroesRepository;
        this.comicsRepository = comicsRepository;
    }

    private Supplier<ResponseStatusException> makeNotFound(String message, Object...args) {
        return () -> new ResponseStatusException(HttpStatus.NOT_FOUND, message.formatted(args));
    }

    @Transactional
    public void attachComicsToHeroes(AttachmentDTO attachmentDTO) {
        for (long heroId : attachmentDTO.getHeroIds()) {
            if (!heroesRepository.existsById(heroId)) {
                throw makeNotFound("Hero with hero_id = %d not found", heroId).get();
            }
        }
        for (long comicId : attachmentDTO.getComicIds()) {
            if (!comicsRepository.existsById(comicId)) {
                throw makeNotFound("Comic with comic_id = %d not found", comicId).get();
            }
        }
        attachmentDTO.getHeroIds().forEach(heroId -> {
            Hero hero = heroesRepository.findById(heroId).orElseThrow(makeNotFound("Hero with hero_id = %d not found", heroId));
            attachmentDTO.getComicIds().forEach(comicId ->
                hero.getComicsInWhichPresent().add(
                        comicsRepository.findById(comicId).orElseThrow(makeNotFound("Comic with comic_id = %d not found", comicId))
                )
            );
            heroesRepository.save(hero);
        });
    }
}
