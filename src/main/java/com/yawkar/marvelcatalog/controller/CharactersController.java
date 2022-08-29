package com.yawkar.marvelcatalog.controller;

import com.yawkar.marvelcatalog.component.mapper.ComicMapper;
import com.yawkar.marvelcatalog.component.mapper.HeroMapper;
import com.yawkar.marvelcatalog.controller.dto.HeroDTO;
import com.yawkar.marvelcatalog.controller.view.ComicView;
import com.yawkar.marvelcatalog.controller.view.HeroView;
import com.yawkar.marvelcatalog.service.HeroesService;
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

@Tag(name = "Heroes controller", description = "Contains endpoints for managing heroes")
@RestController
@RequestMapping("/v1/public/characters")
@AllArgsConstructor
public class CharactersController {

    private final HeroesService heroesService;
    private final HeroMapper heroMapper;
    private final ComicMapper comicMapper;

    @Operation(summary = "Get all heroes")
    @ApiResponse(responseCode = "200", description = "Successfully found all heroes",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = HeroView.class))))
    @GetMapping
    public List<HeroView> getAllHeroes() {
        return heroMapper.heroesToViews(heroesService.getAllHeroes());
    }

    @Operation(summary = "Get hero")
    @ApiResponse(responseCode = "200", description = "Successfully found the hero",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = HeroView.class)))
    @ApiResponse(responseCode = "404", description = "Hero was not found", content = @Content(schema = @Schema(hidden = true)))
    @GetMapping("/{heroId}")
    public HeroView getHeroById(@PathVariable long heroId) {
        return heroMapper.toView(heroesService.getHeroById(heroId));
    }

    @Operation(summary = "Get all comics with hero")
    @ApiResponse(responseCode = "200", description = "Successfully found all comics",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = ComicView.class))))
    @ApiResponse(responseCode = "404", description = "Hero was not found", content = @Content(schema = @Schema(hidden = true)))
    @GetMapping("/{heroId}/comics")
    public List<ComicView> getAllComicsByHeroId(@PathVariable long heroId) {
        return comicMapper.comicsToViews(heroesService.getComicsWithHeroById(heroId));
    }

    @Operation(summary = "Post hero")
    @ApiResponse(responseCode = "200", description = "Successfully posted the hero",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = HeroView.class)))
    @PostMapping
    public HeroView postNewHero(@Valid @RequestBody HeroDTO heroDTO) {
        return heroMapper.toView(heroesService.addHero(heroMapper.toEntity(heroDTO)));
    }

    @Operation(summary = "Update hero")
    @ApiResponse(responseCode = "200", description = "Successfully updated the hero",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = HeroView.class)))
    @ApiResponse(responseCode = "404", description = "Hero was not found", content = @Content(schema = @Schema(hidden = true)))
    @PutMapping("/{heroId}")
    public HeroView putHero(@Valid @RequestBody HeroDTO heroDTO, @PathVariable long heroId) {
        return heroMapper.toView(heroesService.updateHero(heroMapper.toEntity(heroDTO), heroId));
    }

    @Operation(summary = "Update hero's comics")
    @ApiResponse(responseCode = "200", description = "Successfully updated hero's comics")
    @ApiResponse(responseCode = "404", description = "Hero or one of comics was not found")
    @PutMapping("/{heroId}/comics")
    public void putComics(@PathVariable long heroId, @RequestBody List<Long> comicIds) {
        heroesService.updateComicsWithHero(comicIds, heroId);
    }

    @Operation(summary = "Delete hero by `heroId`")
    @ApiResponse(responseCode = "200", description = "Successfully deleted the hero")
    @ApiResponse(responseCode = "404", description = "Hero with specified `heroId` was not found")
    @DeleteMapping("/{heroId}")
    public void deleteHeroById(@PathVariable long heroId) {
        heroesService.deleteHeroById(heroId);
    }
}
