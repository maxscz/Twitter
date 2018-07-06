
        package com.example.cesarsantacruz.tw.Adapters;

        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.RelativeLayout;
        import android.widget.TextView;

        import com.example.cesarsantacruz.tw.Activities.GalleryActivity;
        import com.example.cesarsantacruz.tw.Activities.LikesActivity;
        import com.example.cesarsantacruz.tw.R;
        import com.example.cesarsantacruz.tw.Models.TwitterFeed;
        import com.squareup.picasso.Picasso;

        import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private final int NUMPIC = 4;
    private RecyclerView mRecyclerView;
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
    public void onBindViewHolder(@NonNull ViewHolder holder2, final int position) {
        final ViewHolder holder = holder2;

        if (
                arrstrTweets.get(position).getPicture() == 0
                ) {
            //     holder.imageTweet.setVisibility(View.GONE);
        } else {
            //    holder.imageTweet.setVisibility(View.VISIBLE); poner id de linear layout
        }

        holder.likesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LikesActivity.class);
                context.startActivity(intent);
            }
        });

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, GalleryActivity.class);
                Bundle b = new Bundle();
                b.putStringArrayList("image", arrstrTweets.get(position).getUrlPictures());
                intent.putExtras(b);
                context.startActivity(intent);
            }


        });
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
                }
            }
        });
        validateImage(arrstrTweets.get(position),holder.image1,holder.image2, holder.image3 ,
                holder.image4 , holder.tvForCountImages, holder.rl);


    }
    private void validateImage(TwitterFeed imageTweet,
                               ImageView image1,
                               ImageView image2,
                               ImageView image3,
                               ImageView image4,
                               TextView textQuantity,
                               RelativeLayout rl)
    {

        /*CASE*/
        if(imageTweet.getUrlPictures().size()<1)
        {
            image1.setVisibility(View.GONE);
            image2.setVisibility(View.GONE);
            image3.setVisibility(View.GONE);
            image4.setVisibility(View.GONE);
            textQuantity.setVisibility(View.GONE);
        }
        else if(imageTweet.getUrlPictures().size()<2)
        {
            Picasso.get().load(imageTweet.getUrlPictures().get(0)).into(image1);
            image1.setVisibility(View.VISIBLE);
            image2.setVisibility(View.GONE);
            image3.setVisibility(View.GONE);
            image4.setVisibility(View.GONE);
            textQuantity.setVisibility(View.GONE);
        }
        else if(imageTweet.getUrlPictures().size()<3)
        {
            Picasso.get().load(imageTweet.getUrlPictures().get(0)).into(image1);
            Picasso.get().load(imageTweet.getUrlPictures().get(1)).into(image2);
            image1.setVisibility(View.VISIBLE);
            image2.setVisibility(View.VISIBLE);
            image3.setVisibility(View.GONE);
            image4.setVisibility(View.GONE);
            textQuantity.setVisibility(View.GONE);
        }
        else if(imageTweet.getUrlPictures().size()<4)
        {
            Picasso.get().load(imageTweet.getUrlPictures().get(0)).into(image1);
            Picasso.get().load(imageTweet.getUrlPictures().get(1)).into(image2);
            Picasso.get().load(imageTweet.getUrlPictures().get(2)).into(image3);
            image1.setVisibility(View.VISIBLE);
            image2.setVisibility(View.VISIBLE);
            image3.setVisibility(View.VISIBLE);
            image4.setVisibility(View.GONE);
            textQuantity.setVisibility(View.GONE);
            rl.setVisibility(View.GONE);
        }
        else if(imageTweet.getUrlPictures().size()<5)
        {
            Picasso.get().load(imageTweet.getUrlPictures().get(0)).into(image1);
            Picasso.get().load(imageTweet.getUrlPictures().get(1)).into(image2);
            Picasso.get().load(imageTweet.getUrlPictures().get(2)).into(image3);
            Picasso.get().load(imageTweet.getUrlPictures().get(3)).into(image4);
            image1.setVisibility(View.VISIBLE);
            image2.setVisibility(View.VISIBLE);
            image3.setVisibility(View.VISIBLE);
            image4.setVisibility(View.VISIBLE);
            textQuantity.setVisibility(View.GONE);
            rl.setVisibility(View.VISIBLE);

        }
        else
        {
            Picasso.get().load(imageTweet.getUrlPictures().get(0)).into(image1);
            Picasso.get().load(imageTweet.getUrlPictures().get(1)).into(image2);
            Picasso.get().load(imageTweet.getUrlPictures().get(2)).into(image3);
            Picasso.get().load(imageTweet.getUrlPictures().get(3)).into(image4);
            image1.setVisibility(View.VISIBLE);
            image2.setVisibility(View.VISIBLE);
            image3.setVisibility(View.VISIBLE);
            image4.setVisibility(View.VISIBLE);
            textQuantity.setVisibility(View.VISIBLE);
            textQuantity.setText("+"+(imageTweet.getUrlPictures().size()- NUMPIC));
            rl.setVisibility(View.VISIBLE);

        }
        /*END CASE*/
        ;

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

        TextView tweet;
        TextView likes;
        TextView likesView;
        RelativeLayout parentLayout;
        ImageView image1;
        ImageView image2;
        ImageView image3;
        ImageView image4;
        TextView tvForCountImages;
        RelativeLayout rl;
        LinearLayout linearLayout;



        //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        public ViewHolder(final View itemView, RecyclerViewAdapter adapter) {
            super(itemView);

            imageFavorite = itemView.findViewById(R.id.favorite);
            imageComment = itemView.findViewById(R.id.comentario);
            imageFavoriteClicked = itemView.findViewById(R.id.favorite);

            likesView =itemView. findViewById(R.id.seccion_likes);

            tweet = itemView.findViewById(R.id.tweet_view);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            likes = itemView.findViewById(R.id.likes);

            image1 = itemView.findViewById(R.id.row_view_image1);
            image2 = itemView.findViewById(R.id.row_view_image2);
            image3 = itemView.findViewById(R.id.row_view_image3);
            image4 = itemView.findViewById(R.id.row_view_image4);
            tvForCountImages = itemView.findViewById(R.id.row_view_tvForCountImages);
            rl = itemView.findViewById(R.id.rl);
            linearLayout = itemView.findViewById(R.id.linear_view);


        }
//----------------------------------------------------------------------------------------------------------------------


    }


}