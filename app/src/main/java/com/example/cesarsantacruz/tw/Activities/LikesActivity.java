package com.example.cesarsantacruz.tw.Activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.cesarsantacruz.tw.Adapters.LikesAdapter;
import com.example.cesarsantacruz.tw.R;
import com.example.cesarsantacruz.tw.Models.TwitterFeed;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class LikesActivity extends MainActivity {
    private ArrayList<TwitterFeed> arrstrLikes;
    private RecyclerView mRecyclerView;

    private TextView textDate;
    private TextView textHour;
    private SimpleDateFormat simpleDateFormat;
    private Calendar calendar;
    private String fecha;
    private String hora;
    LikesAdapter likesAdapter;
    private int pos;
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likes);
            pos = getIntent().getExtras().getInt("position");
        mRecyclerView = findViewById(R.id.activity_likes_rvlikes);



        likesAdapter = new LikesAdapter(this, arrstrLikes);
        mRecyclerView.setAdapter(likesAdapter);

        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
        TwitterFeed tweeter= (TwitterFeed) getIntent().getExtras().getSerializable("Tweet");
        arrstrTweets=new ArrayList<>();
        arrstrTweets.add(tweeter);
        tweeter.getLikes();
        //getLikes();

    }

    public void getLikes() {
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        fecha = simpleDateFormat.format(calendar.getTime());


    }
}
