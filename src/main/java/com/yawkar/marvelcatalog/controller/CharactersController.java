package com.yawkar.marvelcatalog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/public/characters")
public class CharactersController {

    @GetMapping
    public String getAllCharacters() {
        return "Woo-Hoo-Hoo";
    }

    @GetMapping("/{characterId}")
    public String getCharacterById(@PathVariable String characterId) {
        return "Woo-Hoo-Hoo, where is the character with id: %s?".formatted(characterId);
    }

    @GetMapping("/{characterId}/comics")
    public String getAllComicsByCharacterId(@PathVariable String characterId) {
        return "Woo-Hoo-Hoo, where are all comics with the character with id: %s?".formatted(characterId);
    }
}
