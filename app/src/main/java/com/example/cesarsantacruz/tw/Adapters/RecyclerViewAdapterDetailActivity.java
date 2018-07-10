package com.example.cesarsantacruz.tw.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cesarsantacruz.tw.Models.TwitterFeed;
import com.example.cesarsantacruz.tw.R;

import java.util.ArrayList;

public class RecyclerViewAdapterDetailActivity extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int NUMPIC = 4;
    private RecyclerView mRecyclerView;
    Context context;
    private ArrayList<TwitterFeed> arrstrTweets;
    boolean isFavorite = false;
    int intLikes;
    int TYPE_NORMAL=1;
    int TYPE_COMMENTS=2;


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
            holder = new ViewHolderTweetSon(view, this);
        }
        else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_footer, parent, false);
            holder = new ViewHolderTweetFather(view, this);
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ViewHolderTweetSon)
        {
        final ViewHolderTweetSon holderSon = (ViewHolderTweetSon) holder;
        }
        else if( holder instanceof  ViewHolderTweetFather)
        {

            final ViewHolderTweetFather holderFat = (ViewHolderTweetFather) holder;
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
            TextView rvFLikes;
            TextView rvFLikesView;
            ImageView rvFPimage1;

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