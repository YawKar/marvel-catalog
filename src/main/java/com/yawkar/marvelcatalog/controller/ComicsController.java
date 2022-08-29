package com.yawkar.marvelcatalog.controller;

import com.yawkar.marvelcatalog.component.mapper.ComicMapper;
import com.yawkar.marvelcatalog.component.mapper.HeroMapper;
import com.yawkar.marvelcatalog.controller.dto.ComicDTO;
import com.yawkar.marvelcatalog.controller.view.ComicView;
import com.yawkar.marvelcatalog.controller.view.HeroView;
import com.yawkar.marvelcatalog.service.ComicsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "Get all comics")
    @ApiResponse(responseCode = "200", description = "Successfully found all comics",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = ComicView.class))))
    @GetMapping
    public List<ComicView> getAllComics() {
        return comicMapper.comicsToViews(comicsService.getAllComics());
    }

    @Operation(summary = "Get comic")
    @ApiResponse(responseCode = "200", description = "Successfully found the comic",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ComicView.class)))
    @ApiResponse(responseCode = "404", description = "Comic was not found", content = @Content(schema = @Schema(hidden = true)))
    @GetMapping("/{comicId}")
    public ComicView getComicById(@PathVariable long comicId) {
        return comicMapper.toView(comicsService.getComicById(comicId));
    }

    @Operation(summary = "Get all heroes from comic")
    @ApiResponse(responseCode = "200", description = "Successfully found comic's heroes",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = HeroView.class))))
    @ApiResponse(responseCode = "404", description = "Comic was not found", content = @Content(schema = @Schema(hidden = true)))
    @GetMapping("/{comicId}/characters")
    public List<HeroView> getAllHeroesByComicId(@PathVariable long comicId) {
        return heroMapper.heroesToViews(comicsService.getHeroesFromComicById(comicId));
    }

    @Operation(summary = "Post comic")
    @ApiResponse(responseCode = "200", description = "Successfully posted the comic",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ComicView.class)))
    @PostMapping
    public ComicView postNewComic(@Valid @RequestBody ComicDTO comicDTO) {
        return comicMapper.toView(comicsService.addComic(comicMapper.toEntity(comicDTO)));
    }

    @Operation(summary = "Update comic")
    @ApiResponse(responseCode = "200", description = "Successfully updated the comic",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ComicView.class)))
    @ApiResponse(responseCode = "404", description = "Comic was not found", content = @Content(schema = @Schema(hidden = true)))
    @PutMapping("/{comicId}")
    public ComicView putComic(@Valid @RequestBody ComicDTO comicDTO, @PathVariable long comicId) {
        return comicMapper.toView(comicsService.updateComic(comicMapper.toEntity(comicDTO), comicId));
    }

    @Operation(summary = "Delete comic")
    @ApiResponse(responseCode = "200", description = "Successfully deleted the comic")
    @ApiResponse(responseCode = "404", description = "Comic was not found")
    @DeleteMapping("/{comicId}")
    public void deleteComic(@PathVariable long comicId) {
        comicsService.deleteComicById(comicId);
    }
}
