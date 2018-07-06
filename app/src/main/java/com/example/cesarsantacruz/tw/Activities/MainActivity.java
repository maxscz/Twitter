package com.example.cesarsantacruz.tw.Activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cesarsantacruz.tw.R;
import com.example.cesarsantacruz.tw.Adapters.RecyclerViewAdapter;
import com.example.cesarsantacruz.tw.Models.TwitterFeed;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ArrayList<TwitterFeed> arrstrTweets;
    RecyclerViewAdapter recyclerViewAdapter;
    Context context;
    TextView likesView;
    ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //                                                  //Ubicamos el recycler view en nuestro archivo XML
        mRecyclerView = findViewById(R.id.activity_main_rvmain);
        /*mDrawerList = findViewById(R.id.activity_main_smmain);
        addMenu();*/

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
    }

    /*private void addMenu() {
        String[] arrstrListMenu = {"Tweets", "Settings", "About Us"};
        mAdapter = new ArrayAdapter<String>(this, R.layout.activity_main, arrstrListMenu);
        mDrawerList.setAdapter(mAdapter);
    }*/
}
