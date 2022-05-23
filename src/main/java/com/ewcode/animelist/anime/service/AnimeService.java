package com.ewcode.animelist.anime.service;

import com.ewcode.animelist.anime.dtos.AnimeDto;
import com.ewcode.animelist.anime.entities.Anime;
import com.ewcode.animelist.anime.repositories.IAnimeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AnimeService {

    private IAnimeRepository animeRepository;

    @Autowired
    public AnimeService(IAnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    @Transactional
    public AnimeDto save(AnimeDto animeDto) {
        Optional<Anime> animeOptional = animeRepository.findByName(animeDto.name());

        Anime anime = new Anime();

        if(animeOptional.isPresent()) {
            anime = animeOptional.get();
        }

        BeanUtils.copyProperties(animeDto, anime);
        animeRepository.save(anime);
        return animeDto;
    }

    public int sum(int value) {
        return value + 1;
    }

}
