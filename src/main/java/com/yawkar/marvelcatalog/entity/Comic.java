package com.yawkar.marvelcatalog.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "comics")
public class Comic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Column(name = "executive_editor")
    private String executiveEditor;
    @ElementCollection
    @Column(name = "cover_artists")
    private List<String> coverArtists;
    @ManyToMany(mappedBy = "comicsInWhichPresent")
    private Set<Hero> heroesPresent = new HashSet<>();

    public Comic() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExecutiveEditor() {
        return executiveEditor;
    }

    public void setExecutiveEditor(String executiveEditor) {
        this.executiveEditor = executiveEditor;
    }

    public List<String> getCoverArtists() {
        return coverArtists;
    }

    public void setCoverArtists(List<String> coverArtists) {
        this.coverArtists = coverArtists;
    }

    public Set<Hero> getHeroesPresent() {
        return heroesPresent;
    }

    public void setHeroesPresent(Set<Hero> heroesPresent) {
        this.heroesPresent = heroesPresent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comic)) return false;
        Comic comic = (Comic) o;
        return id == comic.id && title.equals(comic.title) && executiveEditor.equals(comic.executiveEditor) && coverArtists.equals(comic.coverArtists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, executiveEditor, coverArtists);
    }
}
