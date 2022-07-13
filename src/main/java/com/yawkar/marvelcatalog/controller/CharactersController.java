package com.yawkar.marvelcatalog.controller;

import com.yawkar.marvelcatalog.dto.ComicDTO;
import com.yawkar.marvelcatalog.dto.HeroDTO;
import com.yawkar.marvelcatalog.service.HeroesService;
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

    private final HeroesService heroesService;

    public CharactersController(HeroesService heroesService) {
        this.heroesService = heroesService;
    }

    @Operation(
            summary = "Gets all heroes",
            description = "Gets the list of all heroes from the catalog"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Found all heroes",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = HeroDTO.class))
                            )
                    )
            }
    )
    @GetMapping
    public List<HeroDTO> getAllHeroes() {
        return heroesService.findAllHeroes();
    }

    @Operation(
            summary = "Gets a hero",
            description = "Gets a hero by the specified `heroId`"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Found the hero",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = HeroDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "The hero is not found",
                            content = @Content(
                                    schema = @Schema(hidden = true)
                            )
                    )
            }
    )
    @GetMapping("/{heroId}")
    public HeroDTO getHeroById(
            @Parameter(description = "The internal id of the hero") @PathVariable long heroId
    ) {
        return heroesService.findHeroById(heroId);
    }

    @Operation(
            summary = "Gets all comics with the hero",
            description = "Gets all comics in which a hero with the specified `heroId` present"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Found all comics",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = ComicDTO.class))
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "The hero is not found",
                            content = @Content(
                                    schema = @Schema(hidden = true)
                            )
                    )
            }
    )
    @GetMapping("/{heroId}/comics")
    public List<ComicDTO> getAllComicsByHeroId(
            @Parameter(description = "The internal id of the hero") @PathVariable long heroId
    ) {
        return heroesService.findAllComicsByHeroId(heroId);
    }

    @Operation(
            summary = "Posts new hero",
            description = "Posts new hero and returns the same object with `id` property that represents the internal id" +
                    " of the hero"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully posted new hero",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = HeroDTO.class)
                            )
                    )
            }
    )
    @PostMapping
    public HeroDTO postNewHero(@Valid @RequestBody HeroDTO heroDTO) {
        return heroesService.insertNewHero(heroDTO);
    }

    @Operation(
            summary = "Updates the hero",
            description = "Updates the existing hero (throws 404 if doesn't exist)"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully updated the hero",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = HeroDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "The hero is not found",
                            content = @Content(
                                    schema = @Schema(hidden = true)
                            )
                    )
            }
    )
    @PutMapping
    public HeroDTO putHero(@Valid @RequestBody HeroDTO heroDTO) {
        return heroesService.updateHero(heroDTO);
    }
}
