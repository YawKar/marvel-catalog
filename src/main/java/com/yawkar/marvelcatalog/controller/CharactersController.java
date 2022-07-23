package com.yawkar.marvelcatalog.controller;

import com.yawkar.marvelcatalog.component.mapper.ComicMapper;
import com.yawkar.marvelcatalog.component.mapper.HeroMapper;
import com.yawkar.marvelcatalog.controller.dto.HeroDTO;
import com.yawkar.marvelcatalog.service.HeroesService;
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

@Tag(name = "Heroes controller", description = "Contains endpoints for managing heroes")
@RestController
@RequestMapping("/v1/public/characters")
@AllArgsConstructor
public class CharactersController {

    private final HeroesService heroesService;
    private final HeroMapper heroMapper;
    private final ComicMapper comicMapper;

    @Operation(summary = "Gets all heroes",
            description = "Gets the list of all heroes from the catalog")
    @ApiResponses(
            @ApiResponse(responseCode = "200",
                    description = "Found all heroes",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = HeroView.class)))))
    @GetMapping
    public List<HeroView> getAllHeroes() {
        return heroMapper.heroesToViews(heroesService.getAllHeroes());
    }

    @Operation(summary = "Gets a hero",
            description = "Gets a hero by the specified `heroId`")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Found the hero",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = HeroView.class))),
            @ApiResponse(responseCode = "404",
                    description = "The hero is not found",
                    content = @Content(schema = @Schema(hidden = true)))})
    @GetMapping("/{heroId}")
    public HeroView getHeroById(
            @Parameter(description = "The internal id of the hero") @PathVariable long heroId
    ) {
        return heroMapper.toView(heroesService.getHeroById(heroId));
    }

    @Operation(summary = "Gets all comics with the hero",
            description = "Gets all comics in which a hero with the specified `heroId` present")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Found all comics",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = ComicView.class)))),
            @ApiResponse(responseCode = "404",
                    description = "The hero is not found",
                    content = @Content(schema = @Schema(hidden = true)))})
    @GetMapping("/{heroId}/comics")
    public List<ComicView> getAllComicsByHeroId(
            @Parameter(description = "The internal id of the hero") @PathVariable long heroId
    ) {
        return comicMapper.comicsToViews(heroesService.getComicsWithHeroById(heroId));
    }

    @Operation(summary = "Posts new hero",
            description = "Posts new hero and returns the same object with `id` property that represents the internal id of the hero")
    @ApiResponses(
            @ApiResponse(responseCode = "200",
                    description = "Successfully posted new hero",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = HeroView.class))))
    @PostMapping
    public HeroView postNewHero(@Valid @RequestBody HeroDTO heroDTO) {
        return heroMapper.toView(heroesService.addHero(heroMapper.toEntity(heroDTO)));
    }

    @Operation(summary = "Updates the hero",
            description = "Updates the existing hero (throws 404 if doesn't exist)")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Successfully updated the hero",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = HeroView.class))),
            @ApiResponse(responseCode = "404",
                    description = "The hero is not found",
                    content = @Content(schema = @Schema(hidden = true)))})
    @PutMapping("/{heroId}")
    public HeroView putHero(@Valid @RequestBody HeroDTO heroDTO, @PathVariable long heroId) {
        return heroMapper.toView(heroesService.updateHero(heroMapper.toEntity(heroDTO), heroId));
    }

    @Operation(summary = "Updates comics in which the hero presents")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Successfully updated the list of comics in which the hero presents"),
            @ApiResponse(responseCode = "404",
                    description = "The hero or one of comics is not found")})
    @PutMapping("/{heroId}/comics")
    public void putComics(@PathVariable long heroId, @RequestBody List<Long> comicIds) {
        heroesService.updateComicsWithHero(comicIds, heroId);
    }
}
