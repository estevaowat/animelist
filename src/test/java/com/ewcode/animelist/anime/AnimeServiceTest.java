package com.ewcode.animelist.anime;

import com.ewcode.animelist.anime.dtos.AnimeDto;
import com.ewcode.animelist.anime.entities.Anime;
import com.ewcode.animelist.anime.repositories.IAnimeRepository;
import com.ewcode.animelist.anime.service.AnimeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = {IAnimeRepository.class, AnimeService.class})
class AnimeServiceTest {

    @MockBean
    private IAnimeRepository animeRepository;

    @Autowired
    private AnimeService animeService;

    @Test
    @DisplayName("should insert a new anime in database")
    void shouldInsertNewAnimeInDatabase() {
        AnimeDto anime = new AnimeDto("One piece", "watched", 1000, "Adventure", "Shonen", 10.0);

        AnimeDto result = animeService.save(anime);

        Assertions.assertEquals("One piece", result.name());
        Assertions.assertEquals("watched", result.status());
        Assertions.assertEquals(1000, result.episodes());

    }

    @Test
    @DisplayName("should update anime in database")
    void shouldUpdateAnimeNameInDatabase() {
        Anime animeSaved = new Anime();

        animeSaved.setName("one piece")
                .setStatus("master piece")
                .setEpisodes(1000)
                .setType("Adventure")
                .setGenre("Shonen")
                .setRating("10");

        Optional<Anime> animeOpt = Optional.of(animeSaved);
        when(animeRepository.findByName(Mockito.anyString())).thenReturn(animeOpt);

        AnimeDto anime = new AnimeDto("One piece", "watched", 1000, "Adventure", "Shonen", 10.0);
        AnimeDto result = animeService.save(anime);
        Assertions.assertEquals("One piece", result.name());
        Assertions.assertEquals("watched", result.status());
        Assertions.assertEquals(1000, result.episodes());
    }
}