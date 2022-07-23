package com.yawkar.marvelcatalog.service.impl;

import com.yawkar.marvelcatalog.repository.ComicsRepository;
import com.yawkar.marvelcatalog.repository.entity.Comic;
import com.yawkar.marvelcatalog.repository.entity.Hero;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class ComicsServiceImplTest {

    @Mock
    private ComicsRepository comicsRepository;
    @InjectMocks
    private ComicsServiceImpl comicsService;

    @Test
    void givenComic_whenAddComic_thenReturnComic() {
        // returns what gets
        when(comicsRepository.save(any(Comic.class))).thenAnswer(i -> ((Comic)i.getArgument(0)).setId(1));
        Comic comic = new Comic()
                .setId(0)
                .setTitle("Test 1")
                .setCoverArtists("Artist 1|Artist 2")
                .setExecutiveEditor("Editor 1")
                .setHeroesPresent(Set.of(
                        new Hero().setRealName("Name 1").setAlias("Alias 1"),
                        new Hero().setRealName("Name 2").setAlias("Alias 2")
                ));
        Comic actual = comicsService.addComic(comic);
        assertEquals(actual, comic);
        assertIterableEquals(actual.getHeroesPresent(), comic.getHeroesPresent());
    }
}