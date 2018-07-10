package com.example.cesarsantacruz.tw.Models;
import android.widget.TextView;

import java.util.ArrayList;

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
    private ArrayList<String> urlPictures;
    String comentario;

    //                                                      //Constructor para la estructura de los tweets
    public TwitterFeed(String tweet, String name, String user, int picture, int profilePicture, int likes, int comments,
                       ArrayList<String> urlPictures) {
        this.tweet = tweet;
        this.name = name;
        this.user = user;
        this.picture = picture;
        this.profilePicture = profilePicture;
        this.likes = likes;
        this.comments = comments;
        this.urlPictures = urlPictures;
    }

    public TwitterFeed(int profilePicture, String name, String user, String fecha,String comentario, ArrayList urlPictures) {
    //                                                      //Constructor sobrecargado para los likes
        this.profilePicture = profilePicture;
        this.name = name;
        this.user = user;
        this.fecha = fecha;
        this.urlPictures = urlPictures;
        this.comentario=comentario;
    }


    public TwitterFeed(){

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
}
