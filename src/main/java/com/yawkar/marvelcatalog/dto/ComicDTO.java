package com.yawkar.marvelcatalog.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class ComicDTO {

    @NotBlank
    private String title;
    @NotBlank
    private String executiveEditor;
    @Size(min = 1)
    @NotNull
    private List<String> coverArtists;

    public ComicDTO() {}

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
}
