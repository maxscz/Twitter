package com.example.cesarsantacruz.tw.Connection;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.example.cesarsantacruz.tw.Models.Tweet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TwitterRequest<T> extends Request<T> {

    /*Type collectionType = new TypeToken<List<Tweet>>(){}.getType();
    GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(collectionType, new TwitterDeserializer());
    */
    private final Gson gson = new GsonBuilder().create();
    private final Class<T> clazz;
    private final Map<String, String> headers;
    private final Response.Listener<T> listener;


    public TwitterRequest(int method, String url, Response.ErrorListener listener, Class<T> clazz, Map<String, String>
            headers, Response.Listener<T> listener1) {
        super(method, url, listener);
        this.clazz = clazz;
        this.headers = headers;
        this.listener = listener1;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers != null ? headers : super.getHeaders();
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        Response returnResponse;
        try {
            String json = new String(
                    response.data, HttpHeaderParser.parseCharset(response.headers)).trim();

            Tweet[] arrTweet = gson.fromJson(json, Tweet[].class);
            returnResponse = Response.success(
                    arrTweet,
                    HttpHeaderParser.parseCacheHeaders(response));

        } catch (UnsupportedEncodingException e) {
            returnResponse =  Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            returnResponse = Response.error(new ParseError(e));

        }
        return returnResponse;
    }

}
