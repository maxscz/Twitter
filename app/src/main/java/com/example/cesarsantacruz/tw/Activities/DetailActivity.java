package com.example.cesarsantacruz.tw.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cesarsantacruz.tw.Adapters.RecyclerViewAdapter;
import com.example.cesarsantacruz.tw.Adapters.RecyclerViewAdapterDetailActivity;
import com.example.cesarsantacruz.tw.Models.TwitterFeed;
import com.example.cesarsantacruz.tw.R;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    RecyclerView rvDetailActivity;
    RecyclerViewAdapterDetailActivity rvDetailActivityAdapter;
    ArrayList<TwitterFeed> arrstrTweets = new ArrayList<>();
    int intLikesCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    rvDetailActivity = findViewById(R.id.activity_detail_recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        rvDetailActivity.setLayoutManager(manager);
     getData();
        rvDetailActivityAdapter = new RecyclerViewAdapterDetailActivity(this, arrstrTweets);
        rvDetailActivity.setAdapter(rvDetailActivityAdapter);
    }
    public void getData () {

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
                "@perro"+intI, R.drawable.perro, R.drawable.perro, intLikesCount, modelTweet.getComments(),arrUrl);
        arrstrTweets.add(twitterFeed);
    }

}
    public void createNewTweet()
    {

        rvDetailActivityAdapter.notifyDataSetChanged();
    }
}
