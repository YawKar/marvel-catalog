package com.yawkar.marvelcatalog.component;

import com.yawkar.marvelcatalog.controller.dto.ComicDTO;
import com.yawkar.marvelcatalog.controller.dto.HeroDTO;
import com.yawkar.marvelcatalog.repository.entity.Comic;
import com.yawkar.marvelcatalog.repository.entity.Hero;
import com.yawkar.marvelcatalog.controller.view.ComicView;
import com.yawkar.marvelcatalog.controller.view.HeroView;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModelMapper {

    private String listToTags(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String part : list) {
            sb.append(part).append('|');
        }
        if (sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private List<String> tagsToList(String tags) {
        return Arrays.stream(tags.split("\\|")).collect(Collectors.toList());
    }

    public Comic toEntity(ComicDTO comicDTO) {
        Comic comic = new Comic();
        comic.setTitle(comicDTO.getTitle());
        comic.setExecutiveEditor(comicDTO.getExecutiveEditor());
        comic.setCoverArtists(listToTags(comicDTO.getCoverArtists()));
        return comic;
    }

    public ComicView toView(Comic comic) {
        ComicView comicView = new ComicView();
        comicView.setId(comic.getId());
        comicView.setTitle(comic.getTitle());
        comicView.setCoverArtists(tagsToList(comic.getCoverArtists()));
        comicView.setExecutiveEditor(comic.getExecutiveEditor());
        return comicView;
    }

    public List<ComicView> comicsToViews(List<Comic> comicList) {
        return comicList.stream().map(this::toView).collect(Collectors.toList());
    }

    public Hero toEntity(HeroDTO heroDTO) {
        Hero hero = new Hero();
        hero.setRealName(heroDTO.getRealName());
        hero.setAlias(heroDTO.getAlias());
        hero.setSuperpowers(listToTags(heroDTO.getSuperpowers()));
        return hero;
    }

    public HeroView toView(Hero hero) {
        HeroView heroView = new HeroView();
        heroView.setRealName(hero.getRealName());
        heroView.setAlias(hero.getAlias());
        heroView.setId(hero.getId());
        heroView.setSuperpowers(tagsToList(hero.getSuperpowers()));
        return heroView;
    }

    public List<HeroView> heroesToViews(List<Hero> heroList) {
        return heroList.stream().map(this::toView).collect(Collectors.toList());
    }
}
