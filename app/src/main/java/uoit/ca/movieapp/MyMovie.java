package uoit.ca.movieapp;

import java.io.Serializable;

public class MyMovie implements Serializable {

    /* Fields */

    private int id = 1;
    private int voteAverage = 1;
    private int voteCount = 1;
    private String originalTitle = "Default";
    private String title = "Default";
    private double popularity = 0.1;
    private String backdropPath = "Default";
    private String overview = "This is placeholder text";
    private String releaseDate = "2018";
    private String posterPath = "Default";
    private int imdbID = 0;
    private int imdbRating= 0;
    private int imdbVotes = 0;
    private String Title = "Default";
    private String Plot = "The default value was assigned on December 3rd 2018, prior to that date, it did not exist. What will happen?";
    private String Released = "2018";
    private String Poster = "Default";

    /* Getters */

    public int getId() {
        return id;
    }

    public int getVoteAverage() {
        return voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getTitle() {
        return title;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public int getImdbRating() {
        return imdbRating;
    }

    public int getImdbVotes() {
        return imdbVotes;
    }

    public String getReleased() {
        return Released;
    }

    public String getPlot() {
        return Plot;
    }

    public String getPoster() {
        return Poster;
    }

    /* Setters */

    public void setVoteAverage(int voteAverage) {
        this.voteAverage = voteAverage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public void setimdbRating(int imdbRating) {
        this.imdbRating = imdbRating;
    }

    public void setimdbVotes(int imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public void setPlot(String Plot) {
        this.Plot = Plot;
    }

    public void setReleased(String Released) {
        this.Released = Released;
    }

    public void setPoster(String posterPath) {
        this.Poster = posterPath;
    }


}