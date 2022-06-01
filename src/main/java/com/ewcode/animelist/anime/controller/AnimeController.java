package com.ewcode.animelist.anime.controller;

import com.ewcode.animelist.anime.dtos.AnimeDto;
import com.ewcode.animelist.anime.service.AnimeService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("anime")
public class AnimeController {


    private AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }


    @GetMapping
    public ResponseEntity<Page<AnimeDto>> getPageable(@RequestParam int page,
                                                      @RequestParam int size) {


        Page<AnimeDto> animes = animeService.getPageable(page, size);

        return ResponseEntity.ok(animes);
    }

    @PostMapping
    public ResponseEntity<AnimeDto> save(@RequestBody AnimeDto animeDto) {
        AnimeDto animeSaved = animeService.save(animeDto);
        return ResponseEntity.ok(animeSaved);
    }
}
