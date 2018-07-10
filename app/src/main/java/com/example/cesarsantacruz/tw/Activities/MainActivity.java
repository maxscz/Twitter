package com.example.cesarsantacruz.tw.Activities;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.cesarsantacruz.tw.R;
import com.example.cesarsantacruz.tw.Adapters.RecyclerViewAdapter;
import com.example.cesarsantacruz.tw.Models.TwitterFeed;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int comments;
    FloatingActionButton fabNewTweet;
    RecyclerView mRecyclerView;
    ArrayList<TwitterFeed> arrstrTweets = new ArrayList<>();
    RecyclerViewAdapter recyclerViewAdapter;
    Context context;
    TextView likesView;
    ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fabNewTweet = findViewById(R.id.activity_main_fabNewTweet);

        fabNewTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if(prev != null) {
                    ft.remove(prev);

                }
                ft.addToBackStack(null);

                DialogFragment dialogFragment = new NewTweetFragmentDialog();
                dialogFragment.setStyle(DialogFragment.STYLE_NORMAL,R.style.DialogFragmentTheme);
                dialogFragment.show(ft, "dialog");
            }
        });

        //                                                  //Ubicamos el recycler view en nuestro archivo XML
        mRecyclerView = findViewById(R.id.activity_main_rvmain);
        /*mDrawerList = findViewById(R.id.activity_main_smmain);
        addMenu();*/

        //                                                  //Llenamos de informacion nuestro RecyclerView
      //  GetData();
        //                                                  //Configuración del adaptador para el RecyclerView
        recyclerViewAdapter = new RecyclerViewAdapter(this, arrstrTweets);
        mRecyclerView.setAdapter(recyclerViewAdapter);

        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);

    }



    public void GetData () {
        arrstrTweets = new ArrayList<>();
        ArrayList<String> arrUrl = new ArrayList<>();
        arrUrl.add("https://www.viajaraitalia.com/wp-content/uploads/2009/09/venecia-de-noche.jpg");
        arrUrl.add("https://www.mycoyote.es/blog/wp-content/uploads/2018/05/viajar-italia.jpg");
        arrUrl.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTMR4VJUaWuEbtiKnL53FIkW17VW5uVUc1ZKP7F9reVbsK0lOj7");
       arrUrl.add("https://img.elcomercio.pe/files/ec_article_multimedia_gallery/uploads/2017/12/01/5a21bb359ff38.jpeg");
       arrUrl.add("https://1.bp.blogspot.com/-z3iEVshe8Lc/T3oLv1ZqfLI/AAAAAAAADZw/Yr1oj08kZ3M/s1600/hacer.jpg");
       arrUrl.add("http://www.multimedios.com/files/article_main/uploads/2017/03/14/58c82f951b5c4.jpeg");

       TwitterFeed modelTweet = new TwitterFeed();


       for (int intI = 0; intI<20; intI = intI + 1){
           TwitterFeed twitterFeed = new TwitterFeed("probando probando probando", "perro chido",
                   "@perro"+intI, R.drawable.perro, R.drawable.perro, intI+10, modelTweet.getComments(),arrUrl);
           arrstrTweets.add(twitterFeed);
       }

        /*TwitterFeed twitterFeed = new TwitterFeed("probando probando probando", "perro chido",
                "@perro123", R.drawable.perro, R.drawable.perro, 4, 6,arrUrl);
        arrstrTweets.add(twitterFeed);

        twitterFeed = new TwitterFeed("probando probando probando", "perro chido",
                "@perro123", 0, R.drawable.perro, 23, 8,arrUrl);
        arrstrTweets.add(twitterFeed);

        twitterFeed = new TwitterFeed("probando probando probando", "perro chido",
                "@perro123", R.drawable.perro, R.drawable.perro, 22, 13,arrUrl);
        arrstrTweets.add(twitterFeed);

        twitterFeed = new TwitterFeed("probando probando probando", "perro chido",
                "@perro123", R.drawable.perro, R.drawable.perro, 15, 6,arrUrl);
        arrstrTweets.add(twitterFeed);

        twitterFeed = new TwitterFeed("probando probando probando", "perro chido",
                "@perro123", 0, R.drawable.perro, 4, 1,arrUrl);
        arrstrTweets.add(twitterFeed);
        */
    }
    public void createNewTweet(TwitterFeed newTweet)
    {
        arrstrTweets.add(newTweet);
        recyclerViewAdapter.notifyDataSetChanged();
    }
}
