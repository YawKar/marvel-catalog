package com.yawkar.marvelcatalog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class ComicDTO {

    @NotBlank(message = "Title can't be blank or null")
    private String title;
    @JsonProperty("executive_editor")
    @NotBlank(message = "Executive editor can't be blank or null")
    private String executiveEditor;
    @JsonProperty("cover_artists")
    @Size(min = 1, message = "Cover artists list should contain at least 1 artist")
    @NotNull(message = "Cover artists can't be null")
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
