package com.yawkar.marvelcatalog.service.impl;

import com.yawkar.marvelcatalog.repository.HeroesRepository;
import com.yawkar.marvelcatalog.repository.entity.Hero;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HeroesServiceImplTest {

    @Mock
    private HeroesRepository heroesRepository;

    @InjectMocks
    private HeroesServiceImpl heroesService;

    @Test
    void givenHero_whenAddHero_thenReturnHero() {
        when(heroesRepository.save(any(Hero.class))).thenAnswer(i -> ((Hero)i.getArgument(0)).setId(1));
        Hero hero = new Hero()
                .setRealName("Name")
                .setAlias("Alias")
                .setSuperpowers("Power 1|Power 2");
        Hero actual = heroesService.addHero(hero);
        assertEquals(1, actual.getId());
        assertEquals("Name", actual.getRealName());
        assertEquals("Alias", actual.getAlias());
        assertEquals("Power 1|Power 2", actual.getSuperpowers());
    }
}