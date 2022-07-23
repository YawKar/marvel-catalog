package com.yawkar.marvelcatalog.component.mapper;

import com.yawkar.marvelcatalog.controller.dto.ComicDTO;
import com.yawkar.marvelcatalog.controller.view.ComicView;
import com.yawkar.marvelcatalog.repository.entity.Comic;
import com.yawkar.marvelcatalog.repository.entity.Hero;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ComicMapperTest {

    private final ComicMapper comicMapper = new ComicMapper();

    @Test
    void toEntity() {
        ComicDTO comicDTO = new ComicDTO()
                .setTitle("Title")
                .setExecutiveEditor("Editor")
                .setCoverArtists(List.of("Artist 1", "Artist 2"));
        Comic comic = comicMapper.toEntity(comicDTO);
        assertEquals("Title", comic.getTitle());
        assertEquals("Editor", comic.getExecutiveEditor());
        assertEquals("Artist 1|Artist 2", comic.getCoverArtists());
        assertEquals(0, comic.getId());
        assertEquals(Collections.emptySet(), comic.getHeroesPresent());
    }

    @Test
    void toView() {
        Comic comic = new Comic()
                .setId(1)
                .setTitle("Title")
                .setExecutiveEditor("Editor")
                .setCoverArtists("Artist 1|Artist 2")
                .setHeroesPresent(Set.of(
                        new Hero().setRealName("Name").setAlias("Alias"),
                        new Hero().setRealName("Name 2").setAlias("Alias 2")
                ));
        ComicView comicView = comicMapper.toView(comic);
        assertEquals(1, comicView.getId());
        assertEquals("Title", comicView.getTitle());
        assertEquals("Editor", comicView.getExecutiveEditor());
        assertEquals(List.of("Artist 1", "Artist 2"), comicView.getCoverArtists());
    }

    @Test
    void comicsToViews() {
        List<Comic> comics = List.of(
                new Comic()
                        .setId(1)
                        .setTitle("Title 1")
                        .setExecutiveEditor("Editor 1")
                        .setCoverArtists("Artist 1|Artist 2")
                        .setHeroesPresent(Set.of(
                                new Hero().setRealName("Name").setAlias("Alias"),
                                new Hero().setRealName("Name 2").setAlias("Alias 2"))
                        ),
                new Comic()
                        .setId(2)
                        .setTitle("Title 2")
                        .setExecutiveEditor("Editor 2")
                        .setCoverArtists("Artist 3|Artist 4")
                        .setHeroesPresent(Set.of(
                                new Hero().setRealName("Name 3").setAlias("Alias 3"),
                                new Hero().setRealName("Name 4").setAlias("Alias 4")
                        )));
        List<ComicView> comicViews = comicMapper.comicsToViews(comics);
        List<ComicView> expectedViews = List.of(
                new ComicView()
                        .setId(1)
                        .setTitle("Title 1")
                        .setExecutiveEditor("Editor 1")
                        .setCoverArtists(List.of("Artist 1", "Artist 2")),
                new ComicView()
                        .setId(2)
                        .setTitle("Title 2")
                        .setExecutiveEditor("Editor 2")
                        .setCoverArtists(List.of("Artist 3", "Artist 4")));
        assertIterableEquals(expectedViews, comicViews);
    }
}