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
    private String synopsis;
    @Column(name = "executive_editor")
    private String executiveEditor;
    @ElementCollection
    @Column(name = "cover_artists")
    private List<String> coverArtists;
    @ManyToMany(mappedBy = "comicsInWhichPresent", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Character> charactersPresent;

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

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
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

    public List<Character> getCharactersPresent() {
        return charactersPresent;
    }

    public void setCharactersPresent(List<Character> charactersPresent) {
        this.charactersPresent = charactersPresent;
    }
}
