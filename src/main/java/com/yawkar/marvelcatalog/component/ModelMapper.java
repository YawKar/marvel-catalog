package com.yawkar.marvelcatalog.component;

import com.yawkar.marvelcatalog.dto.ComicDTO;
import com.yawkar.marvelcatalog.dto.HeroDTO;
import com.yawkar.marvelcatalog.entity.Comic;
import com.yawkar.marvelcatalog.entity.Hero;
import com.yawkar.marvelcatalog.view.ComicView;
import com.yawkar.marvelcatalog.view.HeroView;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {

    Comic toEntity(ComicDTO comicDTO) {
        Comic comic = new Comic();
        comic.setId(comicDTO.getId());
        comic.setTitle(comicDTO.getTitle());
        comic.setExecutiveEditor(comicDTO.getExecutiveEditor());
        comic.setCoverArtists(comicDTO.getCoverArtists());
        return comic;
    }

    ComicView toView(Comic comic) {
        ComicView comicView = new ComicView();
        return comicView;
    }

    Hero toEntity(HeroDTO heroDTO) {
        Hero hero = new Hero();
        hero.setId(heroDTO.getId());
        hero.setRealName(heroDTO.getRealName());
        hero.setAlias(hero.getAlias());
        hero.setSuperpowers(heroDTO.getSuperpowers());
        return hero;
    }

    HeroView toView(Hero hero) {
        HeroView heroView = new HeroView();
        return heroView;
    }
}
