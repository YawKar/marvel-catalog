package com.yawkar.marvelcatalog.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Schema(description = "A comic entity")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ComicDTO {

    @Schema(description = "The title of a comic", example = "Clark Kent Gets a Job")
    @NotBlank(message = "Title can't be blank or null")
    private String title;
    @Schema(description = "The name of an executive editor", example = "Vincent Sullivan")
    @JsonProperty("executive_editor")
    @NotBlank(message = "Executive editor can't be blank or null")
    private String executiveEditor;
    @Schema(description = "Artists that made the cover", example = "['Joe Shuster', 'Leo O\\'Mealia']")
    @JsonProperty("cover_artists")
    @Size(min = 1, message = "Cover artists list should contain at least 1 artist")
    @NotNull(message = "Cover artists can't be null")
    private List<String> coverArtists;
}
