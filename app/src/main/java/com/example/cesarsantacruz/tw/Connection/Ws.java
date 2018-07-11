package com.example.cesarsantacruz.tw.Connection;

public class Ws {

    private static String strAPIURL = "http://192.168.10.64/Fake%20Twitter/oauth2/";
    private static String strENDPOINT_LOGIN = "token";
    private static String strPEOPLE = "";

    public static String LOGIN()
    {
        return strAPIURL + strENDPOINT_LOGIN;
    }

    public static String FEED ()
    {
        return strAPIURL + strPEOPLE;
    }

}
