package com.example.cesarsantacruz.tw.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cesarsantacruz.tw.Activities.CommentsActivity;
import com.example.cesarsantacruz.tw.Activities.LikesActivity;
import com.example.cesarsantacruz.tw.R;
import com.example.cesarsantacruz.tw.Models.TwitterFeed;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    Context context;
    private ArrayList<TwitterFeed> arrstrTweets;
    boolean isFavorite = false;
    int intLikes;

    public RecyclerViewAdapter(Context context, ArrayList<TwitterFeed> arrstrTweets) {
        this.context = context;
        this.arrstrTweets = arrstrTweets;
    }

    /*public void addData (ArrayList<TwitterFeed> arrstrTweets) {
        this.arrstrTweets = arrstrTweets;
        //notifyDataSetChanged();
    }*/

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view, parent, false);
        ViewHolder holder = new ViewHolder(view, this);
        return holder;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder2, int position) {
        final ViewHolder holder = holder2;

        if (
                arrstrTweets.get(position).getPicture() == 0
                ) {
            holder.imageTweet.setVisibility(View.GONE);
        } else {
            holder.imageTweet.setVisibility(View.VISIBLE);
        }

        //--------------------------------------------------------------------------------------------------------------
        holder.likesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LikesActivity.class);
                context.startActivity(intent);
            }
        });

        holder.commentsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(context, CommentsActivity.class);
                context.startActivity(intent2);
            }
        });

        //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        holder.imageFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFavorite = !isFavorite;

                if (
                        isFavorite
                        ) {
                    holder.imageFavorite.setImageResource(R.drawable.ic_favorite_clicked);
                    intLikes = intLikes + 1;

                } else {
                    holder.imageFavorite.setImageResource(R.drawable.ic_favorite);
                    intLikes = intLikes - 1;
                }
            }
        });
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public int getItemCount() {
        return arrstrTweets.size();
    }

    //==================================================================================================================
    public class ViewHolder extends RecyclerView.ViewHolder  {

        ImageView imageFavorite;
        ImageView imageComment;
        ImageView imageFavoriteClicked;
        ImageView imageTweet;
        TextView tweet;
        TextView likes;
        TextView likesView;
        TextView commentsView;
        RelativeLayout parentLayout;

        //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        public ViewHolder(final View itemView, RecyclerViewAdapter adapter) {
            super(itemView);

            imageFavorite = itemView.findViewById(R.id.favorite);
            imageComment = itemView.findViewById(R.id.comentario);
            imageFavoriteClicked = itemView.findViewById(R.id.favorite);
            imageTweet = itemView.findViewById(R.id.foto_view);
            likesView = itemView. findViewById(R.id.seccion_likes);
            commentsView = itemView.findViewById(R.id.seccion_comentarios);

            tweet = itemView.findViewById(R.id.tweet_view);
            parentLayout = itemView.findViewById(R.id.activity_main_smmain);
            likes = itemView.findViewById(R.id.likes);

        }
    }
}
