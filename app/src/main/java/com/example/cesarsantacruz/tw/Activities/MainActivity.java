package com.example.cesarsantacruz.tw.Activities;

import android.content.ClipData;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cesarsantacruz.tw.Connection.Ws;
import com.example.cesarsantacruz.tw.Interface.RefreshItemTouchHelperListener;
import com.example.cesarsantacruz.tw.R;
import com.example.cesarsantacruz.tw.Adapters.RecyclerViewAdapter;
import com.example.cesarsantacruz.tw.Models.TwitterFeed;
import com.example.cesarsantacruz.tw.Utils.RefreshItemTouchHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, RefreshItemTouchHelperListener {

    int comments;
    FloatingActionButton fabNewTweet;
    RecyclerView mRecyclerView;
    ArrayList<TwitterFeed> arrstrTweets = new ArrayList<>();
    RecyclerViewAdapter recyclerViewAdapter;
    Context context;
    DrawerLayout drawer;
    SwipeRefreshLayout swipeToRefresh;
    int intLikes = 0;

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fabNewTweet = findViewById(R.id.activity_main_fabNewTweet);

        fabNewTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                b.putString("Type", "Tweet");
                b.putInt("Position",0);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("dialog");

                if(prev != null) {
                    ft.remove(prev);

                }
                ft.addToBackStack(null);

                DialogFragment dialogFragment = new NewTweetFragmentDialog();
                dialogFragment.setArguments(b);
                dialogFragment.setStyle(DialogFragment.STYLE_NORMAL,R.style.DialogFragmentTheme);
                dialogFragment.show(ft, "dialog");
            }
        });
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

    final RequestQueue mRequestQueue = Volley.newRequestQueue(this);
    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
            (Request.Method.GET, Ws.FEED(), null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    Log.d(TAG, "onResponse: " + response);

                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d(TAG, "onErrorResponse: " + error);
                }
            });


    public void createNewTweet(TwitterFeed newTweet)
    {
        arrstrTweets.add(newTweet);
        recyclerViewAdapter.notifyDataSetChanged();
    }
    public void addCommentToTwitter(TwitterFeed newTweet, int position)
    {
        arrstrTweets.get(position).getTweetsComments().add(newTweet);
        recyclerViewAdapter.notifyDataSetChanged();
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
            //Toast.makeText(this, "Oprimiste la opción de SIGN OUT", Toast.LENGTH_SHORT).show();
            logOut();
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
        logOut();
    }

    @Override
    public void onSwipe(RecyclerView.ViewHolder viewHolder, int intDirection, int intPosition) {

    }

    @Override
    public void onItemMove(int intFromPosition, int intToPosition) {

    }

    private void logOut(){
        Intent intent = new Intent ( this, LoginActivity.class);
                startActivity(intent);
                finish();
    }
    public void callToFragmentInbox(int position){
        Bundle b = new Bundle();
        b.putString("Type", "Coment");
        b.putInt("Position",position);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if(prev != null) {
            ft.remove(prev);

        }
        ft.addToBackStack(null);

        DialogFragment dialogFragment = new NewTweetFragmentDialog();
        dialogFragment.setArguments(b);
        dialogFragment.setStyle(DialogFragment.STYLE_NORMAL,R.style.DialogFragmentTheme);
        dialogFragment.show(ft, "dialog");


    }
}
