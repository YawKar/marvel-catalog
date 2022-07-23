package com.yawkar.marvelcatalog.component.mapper;

import com.yawkar.marvelcatalog.controller.dto.HeroDTO;
import com.yawkar.marvelcatalog.controller.view.HeroView;
import com.yawkar.marvelcatalog.repository.entity.Hero;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HeroMapper extends GeneralMapper {

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
