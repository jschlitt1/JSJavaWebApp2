package edu.wctc;

import java.util.Date;

public class GameDetail {
    private int Game_ID;
    private int rating;

    public int getGame_ID() {
        return Game_ID;
    }

    public void setGame_ID(int game_ID) {
        Game_ID = game_ID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        ReleaseDate = releaseDate;
    }

    private Date ReleaseDate;
}
