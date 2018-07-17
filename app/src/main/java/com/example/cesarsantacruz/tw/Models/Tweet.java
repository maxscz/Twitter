package com.example.cesarsantacruz.tw.Models;

public class Tweet {
    private String responses;
    private int id;
    private String likes;
    private String datePublished;
    private String text;
    private String images;
    private int personId;
    private int responseId;
    private int likes_Z;
    private String images_Z;
    //private Person person;

    public Tweet() {
    }

    public Tweet(String responses, int id, String likes, String datePublished, String text, String images, int personId,
                 int responseId, int likes_Z, String images_Z, Person person) {
        this.responses = responses;
        this.id = id;
        this.likes = likes;
        this.datePublished = datePublished;
        this.text = text;
        this.images = images;
        this.personId = personId;
        this.responseId = responseId;
        this.likes_Z = likes_Z;
        this.images_Z = images_Z;
       // this.person = person;
    }

    public String getResponses() {
        return responses;
    }

    public void setResponses(String responses) {
        this.responses = responses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getResponseId() {
        return responseId;
    }

    public void setResponseId(int responseId) {
        this.responseId = responseId;
    }

    public int getLikes_Z() {
        return likes_Z;
    }

    public void setLikes_Z(int likes_Z) {
        this.likes_Z = likes_Z;
    }

    public String getImages_Z() {
        return images_Z;
    }

    public void setImages_Z(String images_Z) {
        this.images_Z = images_Z;
    }

   /* public Person getPerson() {
        return person;
    } */

  /*  public void setPerson(Person person) {
        this.person = person;
    }*/
}
