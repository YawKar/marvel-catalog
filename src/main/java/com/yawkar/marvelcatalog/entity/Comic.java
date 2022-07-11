package com.yawkar.marvelcatalog.entity;

import javax.persistence.*;
import java.util.List;

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
    private List<Hero> heroesPresent;

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

    public List<Hero> getHeroesPresent() {
        return heroesPresent;
    }

    public void setHeroesPresent(List<Hero> heroesPresent) {
        this.heroesPresent = heroesPresent;
    }
}
