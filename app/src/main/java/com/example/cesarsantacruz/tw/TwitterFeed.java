package com.example.cesarsantacruz.tw;

public class TwitterFeed {
    String tweet;
    int picture, likes;

    public TwitterFeed (String tweet, int picture) {
        this.tweet = tweet;
        this.picture = picture;
    }

    public TwitterFeed(String tweet){
        this.tweet = tweet;
    }

    public TwitterFeed() {
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
