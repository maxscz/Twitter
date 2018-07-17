package com.example.cesarsantacruz.tw.Connection;

public class Ws {

    private static String strAPIURL = "http://192.168.10.64/Fake%20Twitter/";
    private static String strENDPOINT_LOGIN = "oauth2/token";
    private static String strTWEETS = "api/tweets";

    public static String LOGIN()
    {
        return strAPIURL + strENDPOINT_LOGIN;
    }

    public static String FEED ()
    {
        return strAPIURL + strTWEETS;
    }

}
