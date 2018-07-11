package com.example.cesarsantacruz.tw.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cesarsantacruz.tw.Activities.DetailActivity;
import com.example.cesarsantacruz.tw.Activities.LikesActivity;
import com.example.cesarsantacruz.tw.Models.TwitterFeed;
import com.example.cesarsantacruz.tw.R;

import java.util.ArrayList;

public class RecyclerViewAdapterDetailActivity extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int NUMPIC = 4;
    private RecyclerView mRecyclerView;
    Context context;
    private ArrayList<TwitterFeed> arrstrTweets;
    boolean isFavorite = false;
    int TYPE_NORMAL=1;
    int TYPE_COMMENTS=2;
    int intLikesCount = 0;

    public RecyclerViewAdapterDetailActivity(Context context, ArrayList<TwitterFeed> arrstrTweets) {
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
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder holder;
        if(viewType == TYPE_NORMAL) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_header, parent, false);
            holder = new ViewHolderTweetFather(view, this);
        }
        else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_footer, parent, false);
            holder = new ViewHolderTweetSon(view, this);
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof ViewHolderTweetSon)
        {
        final ViewHolderTweetSon holderSon = (ViewHolderTweetSon) holder;

        ((ViewHolderTweetSon) holder).rvSTweet.setText(arrstrTweets.get(position).getTweet());
        }
        else if( holder instanceof  ViewHolderTweetFather)
        {
            ((ViewHolderTweetFather) holder).rvFLikes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, LikesActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Tweet",arrstrTweets.get(position));
                    bundle.putInt("position",position);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });

            ((ViewHolderTweetFather) holder).rvFfecha.setText(arrstrTweets.get(position).getFecha());
            ((ViewHolderTweetFather) holder).rvFTweet.setText(arrstrTweets.get(position).getTweet());
            final ViewHolderTweetFather holderFat = (ViewHolderTweetFather) holder;

            holderFat.rvFLikesView.setText(arrstrTweets.get(position).getLikes()+" Likes");
            if (
                    arrstrTweets.get(position).getIsLike()
                    ) {

                ((ViewHolderTweetFather) holder).rvFImageFavorite.setImageResource(R.drawable.ic_favorite_clicked);}
            } else {

            ((ViewHolderTweetFather) holder).rvFImageFavorite.setImageResource(R.drawable.ic_favorite);


        }

    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0)
        {
            return  TYPE_NORMAL;
        }
        return TYPE_COMMENTS;
    }


    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        @Override
        public int getItemCount () {
            return arrstrTweets.size();
        }

        //==================================================================================================================
        public class ViewHolderTweetFather extends RecyclerView.ViewHolder {

            //  ImageView imageFavorite;
            //ImageView imageComment;
            ImageView rvFImageFavorite;
            ImageView rvFImageComment;
            TextView rvFTvUserName;
            TextView rvFTweet;
            LinearLayout rvFLikes;
            TextView rvFLikesView;
            ImageView rvFPimage1;
            TextView rvFfecha;

            //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            public ViewHolderTweetFather(final View itemView, RecyclerViewAdapterDetailActivity adapter) {
                super(itemView);

                rvFTvUserName = itemView.findViewById(R.id.rv_header_tvUserName);
                rvFImageFavorite = itemView.findViewById(R.id.rv_header_favorite);
                rvFImageComment = itemView.findViewById(R.id.rv_header_comentario);
                rvFLikesView =itemView. findViewById(R.id.rv_header_seccion_likes);
                rvFTweet = itemView.findViewById(R.id.rv_header_tweet_view);
                rvFLikes = itemView.findViewById(R.id.rv_header_text_likes);
                rvFPimage1 = itemView.findViewById(R.id.rv_header_image1);
                rvFfecha = itemView.findViewById(R.id.rv_header_fecha);
            }

            //----------------------------------------------------------------------------------------------------------------------

        }

        public class ViewHolderTweetSon extends RecyclerView.ViewHolder {

            //  ImageView imageFavorite;
            //ImageView imageComment;
              TextView rvSTvUserName;
            TextView rvSTweet;
            ImageView rvSImage1;
            LinearLayout rvSLinearLayoutImageUpload;
            LinearLayout rvSLlDetailActivity;

            //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            public ViewHolderTweetSon(final View itemView, RecyclerViewAdapterDetailActivity adapter) {
                super(itemView);
                rvSTvUserName = itemView.findViewById(R.id.rv_footer_tvuserName);
                rvSTweet = itemView.findViewById(R.id.rv_footer_tweet_view);
                rvSImage1 = itemView.findViewById(R.id.rv_footer_image1);
                rvSLinearLayoutImageUpload = itemView.findViewById(R.id.rv_footer_linear_view);
                rvSLlDetailActivity = itemView.findViewById(R.id.rv_footer_ll_detail_activity);




            }
//----------------------------------------------------------------------------------------------------------------------


        }



}