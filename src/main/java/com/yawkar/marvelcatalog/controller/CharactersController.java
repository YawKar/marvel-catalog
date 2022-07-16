package com.yawkar.marvelcatalog.controller;

import com.yawkar.marvelcatalog.component.ModelMapper;
import com.yawkar.marvelcatalog.dto.HeroDTO;
import com.yawkar.marvelcatalog.service.HeroesService;
import com.yawkar.marvelcatalog.view.ComicView;
import com.yawkar.marvelcatalog.view.HeroView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Heroes controller", description = "Contains endpoints for managing heroes")
@RestController
@RequestMapping("/v1/public/characters")
public class CharactersController {

    private final HeroesService<Long> heroesService;
    private final ModelMapper modelMapper;

    public CharactersController(HeroesService<Long> heroesService, ModelMapper modelMapper) {
        this.heroesService = heroesService;
        this.modelMapper = modelMapper;
    }

    @Operation(summary = "Gets all heroes",
            description = "Gets the list of all heroes from the catalog")
    @ApiResponses(
            @ApiResponse(responseCode = "200",
                    description = "Found all heroes",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = HeroView.class)))))
    @GetMapping
    public List<HeroView> getAllHeroes() {

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
    @PutMapping
    public HeroView putHero(@Valid @RequestBody HeroDTO heroDTO) {

    }
}
