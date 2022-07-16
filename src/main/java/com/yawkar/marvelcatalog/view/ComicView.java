package com.yawkar.marvelcatalog.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ComicView {

    private long id;
    private String title;
    @JsonProperty("executive_editor")
    private String executiveEditor;
    @JsonProperty("cover_artists")
    private List<String> coverArtists;
}
