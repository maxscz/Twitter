package com.example.cesarsantacruz.tw;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ArrayList<TwitterFeed> arrstrTweets;
    RecyclerViewAdapter recyclerViewAdapter;
    Context context;
    TextView likesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        //km,mkmlklkml
=======

        //                                                  //Ubicamos el recycler view en nuestro archivo XML
        mRecyclerView = findViewById(R.id.recycler_view);

        //                                                  //Llenamos de informacion nuestro RecyclerView
        GetData();
        //                                                  //Configuración del adaptador para el RecyclerView
        recyclerViewAdapter = new RecyclerViewAdapter(this, arrstrTweets);
        mRecyclerView.setAdapter(recyclerViewAdapter);

        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);

    }

    public void GetData () {
        arrstrTweets = new ArrayList<>();

        TwitterFeed twitterFeed = new TwitterFeed("probando probando probando", "perro chido",
                "@perro123", R.drawable.perro, R.drawable.perro, 4, 6);
        arrstrTweets.add(twitterFeed);

        twitterFeed = new TwitterFeed("probando probando probando", "perro chido",
                "@perro123", 0, R.drawable.perro, 23, 8);
        arrstrTweets.add(twitterFeed);

        twitterFeed = new TwitterFeed("probando probando probando", "perro chido",
                "@perro123", R.drawable.perro, R.drawable.perro, 22, 13);
        arrstrTweets.add(twitterFeed);

        twitterFeed = new TwitterFeed("probando probando probando", "perro chido",
                "@perro123", R.drawable.perro, R.drawable.perro, 15, 6);
        arrstrTweets.add(twitterFeed);

        twitterFeed = new TwitterFeed("probando probando probando", "perro chido",
                "@perro123", 0, R.drawable.perro, 4, 1);
        arrstrTweets.add(twitterFeed);
>>>>>>> 955d01dc2a8e32d3444dc1b311d4bbfe26c61e92
    }
}
