package com.ewcode.animelist.anime.processors;

import com.ewcode.animelist.anime.dtos.AnimeCsvDto;
import com.ewcode.animelist.anime.entities.Anime;
import org.springframework.batch.item.ItemProcessor;

public class AnimeSaveCsvProcessor implements ItemProcessor<AnimeCsvDto, Anime> {

    @Override
    public Anime process(AnimeCsvDto animeCsvDto) throws Exception {
        // THIS IS TOO MUCH??
        Anime anime = new Anime();

        anime.setName(animeCsvDto.getName())
                .setEpisodes(animeCsvDto.getEpisodes())
                .setType(animeCsvDto.getType())
                .setGenre(animeCsvDto.getGenre())
                .setRating(animeCsvDto.getRating());

        return anime;
    }
}
