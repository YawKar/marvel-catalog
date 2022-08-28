package com.yawkar.marvelcatalog.controller;

import com.yawkar.marvelcatalog.component.mapper.ComicMapper;
import com.yawkar.marvelcatalog.component.mapper.HeroMapper;
import com.yawkar.marvelcatalog.controller.dto.ComicDTO;
import com.yawkar.marvelcatalog.service.ComicsService;
import com.yawkar.marvelcatalog.controller.view.ComicView;
import com.yawkar.marvelcatalog.controller.view.HeroView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Comics controller", description = "Contains endpoints for managing comics")
@RestController
@RequestMapping("/v1/public/comics")
@AllArgsConstructor
public class ComicsController {

    private final ComicsService comicsService;
    private final HeroMapper heroMapper;
    private final ComicMapper comicMapper;

    @Operation(summary = "Gets all comics",
            description = "Gets the list of all comics from the catalog")
    @ApiResponses(
            @ApiResponse(responseCode = "200",
                    description = "Found all comics",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = ComicView.class)))))
    @GetMapping
    public List<ComicView> getAllComics() {
        return comicMapper.comicsToViews(comicsService.getAllComics());
    }

    @Operation(summary = "Gets a comic",
            description = "Gets a comic by the specified `comicId`")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Found the comic",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ComicView.class))),
            @ApiResponse(responseCode = "404",
                    description = "The comic is not found",
                    content = @Content(schema = @Schema(hidden = true)))})
    @GetMapping("/{comicId}")
    public ComicView getComicById(
            @Parameter(description = "The internal id of the comic") @PathVariable long comicId
    ) {
        return comicMapper.toView(comicsService.getComicById(comicId));
    }

    @Operation(summary = "Gets all heroes within the comic",
            description = "Gets all heroes which present in the comic with the specified `comicId`")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Found all heroes",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = HeroView.class)))),
            @ApiResponse(responseCode = "404",
                    description = "The comic is not found",
                    content = @Content(schema = @Schema(hidden = true)))})
    @GetMapping("/{comicId}/characters")
    public List<HeroView> getAllHeroesByComicId(
            @Parameter(description = "The internal id of the comic") @PathVariable long comicId
    ) {
        return heroMapper.heroesToViews(comicsService.getHeroesFromComicById(comicId));
    }

    @Operation(summary = "Posts new comic",
            description = "Posts new comic and returns the same object with `id` property that represents the internal id of the comic")
    @ApiResponses(
            @ApiResponse(responseCode = "200",
                    description = "Successfully posted new comic",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ComicView.class))))
    @PostMapping
    public ComicView postNewComic(@Valid @RequestBody ComicDTO comicDTO) {
        return comicMapper.toView(comicsService.addComic(comicMapper.toEntity(comicDTO)));
    }

    @Operation(summary = "Updates the comic",
            description = "Updates the existing comic (throws 404 if doesn't exist)")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Successfully updated the comic",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ComicView.class))),
            @ApiResponse(responseCode = "404",
                    description = "The comic is not found",
                    content = @Content(schema = @Schema(hidden = true)))})
    @PutMapping("/{comicId}")
    public ComicView putComic(@Valid @RequestBody ComicDTO comicDTO, @PathVariable long comicId) {
        return comicMapper.toView(comicsService.updateComic(comicMapper.toEntity(comicDTO), comicId));
    }

    @DeleteMapping("/{comicId}")
    public void deleteComic(@PathVariable long comicId) {
        comicsService.deleteComicById(comicId);
    }
}
