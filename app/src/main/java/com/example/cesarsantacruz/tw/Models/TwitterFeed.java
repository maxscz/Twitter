package com.example.cesarsantacruz.tw.Models;

import java.io.Serializable;
import java.util.ArrayList;
/*POJO*/
public class TwitterFeed implements Serializable {
    String tweet;
    String name;
    String user;
    int picture;
    int profilePicture;
    int likes;
    int comments;
    String fecha;
    String hora;
    private ArrayList<String> urlPictures;
    private ArrayList<TwitterFeed> tweetsComments;
    String comentario;
    Boolean isLike;
    public ArrayList<UserTweet> users;

    //                                                      //Constructor para la estructura de los tweets

    public TwitterFeed(String tweet, String name, String user,String fecha, int picture, int profilePicture, int likes, int comments,
                       ArrayList<String> urlPictures) {
        this.tweet = tweet;
        this.name = name;
        this.user = user;
        this.picture = picture;
        this.profilePicture = profilePicture;
        this.likes = likes;
        this.comments = comments;
        this.urlPictures = urlPictures;
        this.setIsLike(false);
        this.setFecha(fecha);
        this.setTweetsComments(new ArrayList<TwitterFeed>());
        this.users=new ArrayList<>();

    }

    public TwitterFeed() {
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

    public ArrayList<String> getUrlPictures() {
        return urlPictures;
    }

    public void setUrlPictures(ArrayList<String> urlPictures) {
        this.urlPictures = urlPictures;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Boolean getIsLike(){
        return isLike;
    }
    public void setIsLike(Boolean isLike){
        this.isLike = isLike;
    }

    public ArrayList<TwitterFeed> getTweetsComments() {
            return tweetsComments;

    }


    public void setTweetsComments(ArrayList<TwitterFeed> tweetsComments) {
        this.tweetsComments = tweetsComments;
    }


    public void adduser (UserTweet users){
        this.users.add(users);
    }
}


