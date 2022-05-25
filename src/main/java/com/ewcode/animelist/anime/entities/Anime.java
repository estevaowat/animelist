package com.ewcode.animelist.anime.entities;

import javax.persistence.*;

@Entity
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    private String status;

    private int episodes;

    private String type;

    private String genre;

    private String rating;

    public Anime() {
        //constructor used in unit tests
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

    public String getType() {
        return type;
    }

    public Anime setType(String type) {
        this.type = type;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public Anime setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public String getRating() {
        return rating;
    }

    public Anime setRating(String rating) {
        this.rating = rating;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Anime anime = (Anime) o;

        if(getId() != anime.getId()) return false;
        if(getEpisodes() != anime.getEpisodes()) return false;
        if(getName() != null ? !getName().equals(anime.getName()) : anime.getName() != null) return false;
        if(getStatus() != null ? !getStatus().equals(anime.getStatus()) : anime.getStatus() != null) return false;
        if(getType() != null ? !getType().equals(anime.getType()) : anime.getType() != null) return false;
        if(getGenre() != null ? !getGenre().equals(anime.getGenre()) : anime.getGenre() != null) return false;
        return getRating() != null ? getRating().equals(anime.getRating()) : anime.getRating() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + getEpisodes();
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getGenre() != null ? getGenre().hashCode() : 0);
        result = 31 * result + (getRating() != null ? getRating().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", episodes=" + episodes +
                ", type='" + type + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';
    }
}
