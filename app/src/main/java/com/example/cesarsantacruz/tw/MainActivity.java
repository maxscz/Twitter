package com.example.cesarsantacruz.tw;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ArrayList<TwitterFeed> arrstrTweets;
    RecyclerViewAdapter recyclerViewAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);

        recyclerViewAdapter = new RecyclerViewAdapter(this);
        mRecyclerView.setAdapter(recyclerViewAdapter);

        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);

        GetData();
    }

    public void GetData () {
        arrstrTweets = new ArrayList<>();
        TwitterFeed twitterFeed = new TwitterFeed("probando probando probando probando", R.drawable.perro);
        arrstrTweets.add(twitterFeed);
        ((RecyclerViewAdapter)this.mRecyclerView.getAdapter()).addData(arrstrTweets);

        twitterFeed = new TwitterFeed("estoy probando un poco mas");
        arrstrTweets.add(twitterFeed);
        ((RecyclerViewAdapter)this.mRecyclerView.getAdapter()).addData(arrstrTweets);

        twitterFeed = new TwitterFeed("NO maaa, estos tweets estan bien chidoooos #12ayados", R.drawable.perro);
        arrstrTweets.add(twitterFeed);
        ((RecyclerViewAdapter)this.mRecyclerView.getAdapter()).addData(arrstrTweets);

        twitterFeed = new TwitterFeed("Lorem Ipsum fpani Dnmfpi Pidnkj JD DmKDJ DK dnknds kjshfjksoiesne k");
        arrstrTweets.add(twitterFeed);
        ((RecyclerViewAdapter)this.mRecyclerView.getAdapter()).addData(arrstrTweets);

        recyclerViewAdapter.notifyDataSetChanged();
    }
}
