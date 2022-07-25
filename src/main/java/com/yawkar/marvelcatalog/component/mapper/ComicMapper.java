package com.yawkar.marvelcatalog.component.mapper;

import com.yawkar.marvelcatalog.controller.dto.ComicDTO;
import com.yawkar.marvelcatalog.controller.view.ComicView;
import com.yawkar.marvelcatalog.repository.entity.Comic;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ComicMapper extends GeneralMapper {

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
}
