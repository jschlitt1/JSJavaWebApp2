package edu.wctc;

public class Game {
    private int id;
    private String title;
    private int publisher;
    private int developer;
    private int rating;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisher() {
        return publisher;
    }

    public void setPublisher(int publisher) {
        this.publisher = publisher;
    }

    public int getDeveloper() {
        return developer;
    }

    public void setDeveloper(int developer) {
        this.developer = developer;
    }
}
