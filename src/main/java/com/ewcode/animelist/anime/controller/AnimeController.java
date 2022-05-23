package com.ewcode.animelist.anime.controller;

import com.ewcode.animelist.anime.dtos.AnimeDto;
import com.ewcode.animelist.anime.service.AnimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("anime")
public class AnimeController {

    private AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @PostMapping
    public ResponseEntity<AnimeDto> save(@RequestBody AnimeDto animeDto) {
        AnimeDto animeSaved = animeService.save(animeDto);
        return ResponseEntity.ok(animeSaved);
    }
}
