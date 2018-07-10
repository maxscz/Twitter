package com.example.cesarsantacruz.tw.Activities;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cesarsantacruz.tw.Interface.RefreshItemTouchHelperListener;
import com.example.cesarsantacruz.tw.R;
import com.example.cesarsantacruz.tw.Adapters.RecyclerViewAdapter;
import com.example.cesarsantacruz.tw.Models.TwitterFeed;
import com.example.cesarsantacruz.tw.Utils.RefreshItemTouchHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, RefreshItemTouchHelperListener {

    RecyclerView mRecyclerView;
    ArrayList<TwitterFeed> arrstrTweets;
    RecyclerViewAdapter recyclerViewAdapter;
    Context context;
    DrawerLayout drawer;
    SwipeRefreshLayout swipeToRefresh;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         drawer = (DrawerLayout) findViewById(R.id.activity_main_dlMain);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.activity_main_nvMain);
        navigationView.setNavigationItemSelectedListener(this);

        //                                                  //Ubicamos el recycler view en nuestro archivo XML
        mRecyclerView = findViewById(R.id.activity_main_rvmain);

        GetData();
        //                                                  //Configuración del adaptador para el RecyclerView
        recyclerViewAdapter = new RecyclerViewAdapter(this, arrstrTweets);
        mRecyclerView.setAdapter(recyclerViewAdapter);

        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);

        //                                                  //Comienza el swipe to refresh gesture


        ItemTouchHelper.SimpleCallback itemTouchHelperCallBack = new RefreshItemTouchHelper(0,
                ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(mRecyclerView);

        ItemTouchHelper.Callback callback = new RefreshItemTouchHelper(0, ItemTouchHelper.LEFT, this);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(mRecyclerView);

        swipeToRefresh = findViewById(R.id.swipe_refresh);
        swipeToRefresh.setColorSchemeResources(R.color.blue, R.color.red, R.color.yellow);

        swipeToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            @Override
            public void onRefresh() {
                Log.d(TAG, "onRefresh: ");
                //                                                  //Llenamos de informacion nuestro RecyclerView
                GetData();

                (new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeToRefresh.setRefreshing(false);

                    }
                }, 2500);
            }
        });
        /*END-REFRESH*/

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

        TwitterFeed twitterFeed = new TwitterFeed("probando probando probando", "perro chido",
                "@perro123", R.drawable.perro, R.drawable.perro, 4, 6, arrUrl);
        arrstrTweets.add(twitterFeed);

        twitterFeed = new TwitterFeed("probando probando probando", "perro chido",
                "@perro123", 0, R.drawable.perro, 23, 8, arrUrl);
        arrstrTweets.add(twitterFeed);

        twitterFeed = new TwitterFeed("probando probando probando", "perro chido",
                "@perro123", R.drawable.perro, R.drawable.perro, 22, 13, arrUrl);
        arrstrTweets.add(twitterFeed);

        twitterFeed = new TwitterFeed("probando probando probando", "perro chido",
                "@perro123", R.drawable.perro, R.drawable.perro, 15, 6, arrUrl);
        arrstrTweets.add(twitterFeed);

        twitterFeed = new TwitterFeed("probando probando probando", "perro chido",
                "@perro123", 0, R.drawable.perro, 4, 1, arrUrl);
        arrstrTweets.add(twitterFeed);
    }

    @Override
    public void onBackPressed() {
      //  DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_main_dlMain);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (
                //                                          //Handle the Home option
                id == R.id.nav_home
                ) {
            Toast.makeText(this, "Oprimiste la opcion de HOME", Toast.LENGTH_SHORT).show();
        } else if (
                //                                          //Handle the Gallery option
                id == R.id.nav_gallery
                ) {
            Toast.makeText(this, "Oprimiste la opción de GALLERY", Toast.LENGTH_SHORT).show();
        } else if (
                //                                          //Handle the Settings option
                id == R.id.nav_setting
                ) {
            Toast.makeText(this, "Oprimiste la opción de SETTINGS", Toast.LENGTH_SHORT).show();
        } else if (
                //                                          //Handle the Sign out option
                id == R.id.nav_sign_out
                ) {
            Toast.makeText(this, "Oprimiste la opción de SIGN OUT", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_main_dlMain);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    //Creacion de menu
    public boolean onCreateOptionsMenu(
            Menu menu) {
        getMenuInflater().inflate(R.menu.directory, menu);
        return true;
    }

    public void signOut(MenuItem item) {
        this.finish();
    }

    @Override
    public void onSwipe(RecyclerView.ViewHolder viewHolder, int intDirection, int intPosition) {

    }

    @Override
    public void onItemMove(int intFromPosition, int intToPosition) {

    }
}
