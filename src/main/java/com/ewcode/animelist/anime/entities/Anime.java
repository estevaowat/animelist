package com.ewcode.animelist.anime.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(unique = true)
    private String name;

    private String status;

    private int episodes;

    public Anime() {
    }

    public Anime(String name, String status, int episodes) {
        this.name = name;
        this.status = status;
        this.episodes = episodes;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Anime setName(String name) {
        this.name = name;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Anime setStatus(String status) {
        this.status = status;
        return this;
    }

    public int getEpisodes() {
        return episodes;
    }

    public Anime setEpisodes(int episodes) {
        this.episodes = episodes;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Anime anime = (Anime) o;

        if(getId() != anime.getId()) return false;
        if(getEpisodes() != anime.getEpisodes()) return false;
        if(!getName().equals(anime.getName())) return false;
        return getStatus() != null ? getStatus().equals(anime.getStatus()) : anime.getStatus() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + getEpisodes();
        return result;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", episodes=" + episodes +
                '}';
    }
}
