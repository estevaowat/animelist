package com.ewcode.animelist.anime.dtos;

public class AnimeCsvDto {

    private int animeId;
    private String name;
    private String genre;
    private String type;
    private int episodes;
    private String rating;
    private int members;

    public AnimeCsvDto() {
    }

    public AnimeCsvDto(int animeId, String name, String genre, String type, int episodes, String rating, int members) {
        this.animeId = animeId;
        this.name = name;
        this.genre = genre;
        this.type = type;
        this.episodes = episodes;
        this.rating = rating;
        this.members = members;
    }

    public int getAnimeId() {
        return animeId;
    }

    public AnimeCsvDto setAnimeId(int animeId) {
        this.animeId = animeId;
        return this;
    }

    public String getName() {
        return name;
    }

    public AnimeCsvDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public AnimeCsvDto setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public String getType() {
        return type;
    }

    public AnimeCsvDto setType(String type) {
        this.type = type;
        return this;
    }

    public int getEpisodes() {
        return episodes;
    }

    public AnimeCsvDto setEpisodes(int episodes) {
        this.episodes = episodes;
        return this;
    }

    public String getRating() {
        return rating;
    }

    public AnimeCsvDto setRating(String rating) {
        this.rating = rating;
        return this;
    }

    public int getMembers() {
        return members;
    }

    public AnimeCsvDto setMembers(int members) {
        this.members = members;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        AnimeCsvDto that = (AnimeCsvDto) o;

        if(getAnimeId() != that.getAnimeId()) return false;
        if(getEpisodes() != that.getEpisodes()) return false;
        if(getMembers() != that.getMembers()) return false;
        if(getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if(getGenre() != null ? !getGenre().equals(that.getGenre()) : that.getGenre() != null) return false;
        if(getType() != null ? !getType().equals(that.getType()) : that.getType() != null) return false;
        return getRating() != null ? getRating().equals(that.getRating()) : that.getRating() == null;
    }

    @Override
    public int hashCode() {
        int result = getAnimeId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getGenre() != null ? getGenre().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + getEpisodes();
        result = 31 * result + (getRating() != null ? getRating().hashCode() : 0);
        result = 31 * result + getMembers();
        return result;
    }

    @Override
    public String toString() {
        return "AnimeCsvDto{" +
                "animeId=" + animeId +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", type='" + type + '\'' +
                ", episodes=" + episodes +
                ", rating=" + rating +
                ", members=" + members +
                '}';
    }
}
