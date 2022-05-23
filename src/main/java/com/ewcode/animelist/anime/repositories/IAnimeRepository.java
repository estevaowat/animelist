package com.ewcode.animelist.anime.repositories;

import com.ewcode.animelist.anime.entities.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAnimeRepository extends JpaRepository<Anime, Integer> {

    Optional<Anime> findByName(String name);
}
