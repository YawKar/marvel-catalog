package com.yawkar.marvelcatalog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class AttachmentDTO {

    @JsonProperty("hero_ids")
    @NotNull(message = "The hero_ids list can't be null")
    @Size(min = 1, message = "The hero_ids list should contain at least one id")
    private List<Long> heroIds;
    @JsonProperty("comic_ids")
    @NotNull(message = "The comic_ids list can't be null")
    @Size(min = 1, message = "The comic_ids list should contain at least one id")
    private List<Long> comicIds;

    public AttachmentDTO() {}

    public List<Long> getHeroIds() {
        return heroIds;
    }

    public void setHeroIds(List<Long> heroIds) {
        this.heroIds = heroIds;
    }

    public List<Long> getComicIds() {
        return comicIds;
    }

    public void setComicIds(List<Long> comicIds) {
        this.comicIds = comicIds;
    }
}
