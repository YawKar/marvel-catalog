package com.yawkar.marvelcatalog.controller.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ComicView {

    private long id;
    private String title;
    @JsonProperty("executive_editor")
    private String executiveEditor;
    @JsonProperty("cover_artists")
    private List<String> coverArtists;
}
