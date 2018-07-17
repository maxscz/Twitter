package com.example.cesarsantacruz.tw.Models;

import org.json.JSONObject;

import java.lang.reflect.Array;

public class Person {
    private String inResponseTo;
    private JSONObject person;
    private String applicationUser;
    private String group;
    private Object tweets;
    private int id;
    private String name;
    private String at;
    private String photo;
    private String email;
    private int groupId;

    public Person() {
    }

    public Person(String inResponseTo, JSONObject person, String applicationUser, String group, Object tweets, int id, String name, String at, String photo, String email, int groupId) {
        this.inResponseTo = inResponseTo;
        this.person = person;
        this.applicationUser = applicationUser;
        this.group = group;
        this.tweets = tweets;
        this.id = id;
        this.name = name;
        this.at = at;
        this.photo = photo;
        this.email = email;
        this.groupId = groupId;
    }

    public String getInResponseTo() {
        return inResponseTo;
    }

    public void setInResponseTo(String inResponseTo) {
        this.inResponseTo = inResponseTo;
    }

    public JSONObject getPerson() {
        return person;
    }

    public void setPerson(JSONObject person) {
        this.person = person;
    }

    public String getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(String applicationUser) {
        this.applicationUser = applicationUser;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Object getTweets() {
        return tweets;
    }

    public void setTweets(Object tweets) {
        this.tweets = tweets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
