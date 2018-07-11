package com.example.cesarsantacruz.tw.Models;

import java.util.Calendar;

public class UserTweet {
    private String userPicture;
    private String userName;
    private String nameUser;
    private Calendar fecha;

    public UserTweet(String userPicture, String userName , String nameUser, Calendar fecha){
        this.userPicture = userPicture;
        this.userName = userName;
        this.nameUser = nameUser;
        this.fecha = fecha;

    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }
}
