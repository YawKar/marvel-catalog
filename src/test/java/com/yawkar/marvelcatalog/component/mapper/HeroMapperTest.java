package com.yawkar.marvelcatalog.component.mapper;

import com.yawkar.marvelcatalog.controller.dto.HeroDTO;
import com.yawkar.marvelcatalog.controller.view.HeroView;
import com.yawkar.marvelcatalog.repository.entity.Hero;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroMapperTest {

    private final HeroMapper heroMapper = new HeroMapper();

    @Test
    void toEntity() {
        HeroDTO heroDTO = new HeroDTO()
                .setRealName("Name")
                .setAlias("Alias")
                .setSuperpowers(List.of("Power 1", "Power 2"));
        Hero hero = heroMapper.toEntity(heroDTO);
        assertEquals(0, hero.getId());
        assertEquals("Name", hero.getRealName());
        assertEquals("Alias", hero.getAlias());
        assertEquals("Power 1|Power 2", hero.getSuperpowers());
        assertEquals(Collections.emptySet(), hero.getComicsInWhichPresent());
    }

    @Test
    void toView() {
        Hero hero = new Hero()
                .setId(1)
                .setRealName("Name")
                .setAlias("Alias")
                .setSuperpowers("Power 1|Power 2");
        HeroView heroView = heroMapper.toView(hero);
        assertEquals(1, heroView.getId());
        assertEquals("Name", heroView.getRealName());
        assertEquals("Alias", heroView.getAlias());
        assertEquals(List.of("Power 1", "Power 2"), heroView.getSuperpowers());
    }

    @Test
    void heroesToViews() {
        List<Hero> heroes = List.of(
                new Hero()
                        .setId(1)
                        .setRealName("Name 1")
                        .setAlias("Alias 1")
                        .setSuperpowers("Power 1|Power 2"),
                new Hero()
                        .setId(2)
                        .setRealName("Name 2")
                        .setAlias("Alias 2")
                        .setSuperpowers("Power 3|Power 4"));
        List<HeroView> views = heroMapper.heroesToViews(heroes);
        List<HeroView> expectedViews = List.of(
                new HeroView()
                        .setId(1)
                        .setRealName("Name 1")
                        .setAlias("Alias 1")
                        .setSuperpowers(List.of("Power 1", "Power 2")),
                new HeroView()
                        .setId(2)
                        .setRealName("Name 2")
                        .setAlias("Alias 2")
                        .setSuperpowers(List.of("Power 3", "Power 4")));
        assertIterableEquals(expectedViews, views);
    }
}