package com.example.NetflixShow.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(
        name = "netflix_titles"
)
@Data
public class ShowDetails {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;

    @Column(
            name = "show_id"
    )
    private String showId;

    @Column(
            name = "type"
    )
    private String type;

    @Column(
            name = "title"
    )
    private String title;

    @Column(
            name = "director"
    )
    private String director;

    @Column(
            name = "cast"
    )
    private String cast;

    @Column(
            name = "country"
    )
    private String country;

    @Column(
            name = "date_added"
    )
    private String dateAdded;

    @Column(
            name = "release_year"
    )
    private String releaseYear;

    @Column(
            name = "rating"
    )
    private String rating;

    @Column(
            name = "duration"
    )
    private String duration;

    @Column(
            name = "listed_in"
    )
    private String listedIn;

    @Column(
            name = "description"
    )
    private String description;

    @Column(
            name = "source"
    )
    private String source;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getListedIn() {
        return listedIn;
    }

    public void setListedIn(String listedIn) {
        this.listedIn = listedIn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
