package com.example.cesarsantacruz.tw;

public class TwitterFeed {
    String tweet;
    String name;
    String user;
    int picture;
    int profilePicture;
    int likes;
    int comments;
    String fecha;
    String hora;

    public TwitterFeed(String tweet, String name, String user, int picture, int profilePicture, int likes, int comments) {
        this.tweet = tweet;
        this.name = name;
        this.user = user;
        this.picture = picture;
        this.profilePicture = profilePicture;
        this.likes = likes;
        this.comments = comments;
    }

    public TwitterFeed(int profilePicture, String name, String user, String fecha) {
        this.profilePicture = profilePicture;
        this.name = name;
        this.user = user;
        this.fecha = fecha;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public int getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(int profilePicture) {
        this.profilePicture = profilePicture;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
