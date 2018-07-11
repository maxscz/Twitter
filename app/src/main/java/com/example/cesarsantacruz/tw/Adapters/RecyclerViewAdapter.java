
        package com.example.cesarsantacruz.tw.Adapters;

        import android.app.Activity;
        import android.app.DialogFragment;
        import android.app.FragmentTransaction;
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

        import com.example.cesarsantacruz.tw.Activities.CommentsActivity;
        import com.example.cesarsantacruz.tw.Activities.DetailActivity;
        import com.example.cesarsantacruz.tw.Activities.GalleryActivity;
        import com.example.cesarsantacruz.tw.Activities.LikesActivity;
        import com.example.cesarsantacruz.tw.Activities.MainActivity;
        import com.example.cesarsantacruz.tw.Activities.NewTweetFragmentDialog;
        import com.example.cesarsantacruz.tw.R;
        import com.example.cesarsantacruz.tw.Models.TwitterFeed;
        import com.squareup.picasso.Picasso;

        import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int NUMPIC = 4;
    private RecyclerView mRecyclerView;
    Context context;
    private ArrayList<TwitterFeed> arrstrTweets;




    public RecyclerViewAdapter(Context context, ArrayList<TwitterFeed> arrstrTweets) {
        this.context = context;
        this.arrstrTweets = arrstrTweets;
    }

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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder2, final int position) {
        final ViewHolder holder = (ViewHolder) holder2;

        if (
                arrstrTweets.get(position).getPicture() == 0
                ) {
            //     holder.imageTweet.setVisibility(View.GONE);
        } else {
            //    holder.imageTweet.setVisibility(View.VISIBLE); poner id de linear layout
        }
        holder.llDetailActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Tweet",arrstrTweets.get(position));
                intent.putExtras(bundle);

                context.startActivity(intent);
            }
        });
        holder.tvUserName.setText(arrstrTweets.get(position).getUser());
        holder.likesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LikesActivity.class);
                context.startActivity(intent);
            }
        });

        holder.imageComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) context).callToFragmentInbox(position);

                }

           /* setOnClickListener(new View.OnClickListener() {
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
                    dialogFragment.show(ft, "dialog");*/
        });
        holder.tweet.setText(arrstrTweets.get(position).getTweet());

        holder.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewImages(position, 0);
            }
        });

        holder.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewImages(position, 1);
            }
        });
        holder.image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewImages(position, 2);
            }
        });
        holder.image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewImages(position, 3);
            }
        });


        holder.numberofComents.setText(""+  arrstrTweets.get(position).getTweetsComments().size());

        holder.likes.setText(" "+arrstrTweets.get(position).getLikes());

        holder.imageFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (
                        arrstrTweets.get(position).getIsLike()
                        ) {

                    holder.imageFavorite.setImageResource(R.drawable.ic_favorite);
                    arrstrTweets.get(position).setLikes(arrstrTweets.get(position).getLikes()-1);
                    arrstrTweets.get(position).setIsLike(false);
                    holder.likes.setText(arrstrTweets.get(position).getLikes()+"");

                } else {
                    holder.imageFavorite.setImageResource(R.drawable.ic_favorite_clicked);
                    arrstrTweets.get(position).setLikes(arrstrTweets.get(position).getLikes()+1);
                    arrstrTweets.get(position).setIsLike(true);
                    holder.likes.setText(arrstrTweets.get(position).getLikes()+"");
                }
            }
        });
        validateImage(arrstrTweets.get(position),holder.image1,holder.image2, holder.image3 ,
                holder.image4 , holder.tvForCountImages, holder.rl, holder.linearLayoutdown, holder.linearLayoutup);

    }
    private void viewImages(int position, int imagesPosition){
        Intent intent = new Intent(context, GalleryActivity.class);
        Bundle b = new Bundle();
        b.putStringArrayList("image", arrstrTweets.get(position).getUrlPictures());
        b.putInt("position", imagesPosition);
        intent.putExtras(b);
        context.startActivity(intent);
    }
    private void validateImage(TwitterFeed imageTweet,
                               ImageView image1,
                               ImageView image2,
                               ImageView image3,
                               ImageView image4,
                               TextView textQuantity,
                               RelativeLayout rl,
                               LinearLayout linearlayoutdown,
                               LinearLayout linearlayoutup) {

        /*CASE*/
        if (imageTweet.getUrlPictures().size() < 1) {
            image1.setVisibility(View.GONE);
            image2.setVisibility(View.GONE);
            image3.setVisibility(View.GONE);
            image4.setVisibility(View.GONE);
            textQuantity.setVisibility(View.GONE);

        } else if (imageTweet.getUrlPictures().size() < 2) {
            Picasso.get().load(imageTweet.getUrlPictures().get(0)).into(image1);
            image1.setVisibility(View.VISIBLE);
            image2.setVisibility(View.GONE);
            image3.setVisibility(View.GONE);
            image4.setVisibility(View.GONE);
            textQuantity.setVisibility(View.GONE);
            linearlayoutdown.setVisibility(View.GONE);

        } else if (imageTweet.getUrlPictures().size() < 3) {
            Picasso.get().load(imageTweet.getUrlPictures().get(0)).into(image1);
            Picasso.get().load(imageTweet.getUrlPictures().get(1)).into(image2);
            image1.setVisibility(View.VISIBLE);
            image2.setVisibility(View.VISIBLE);
            image3.setVisibility(View.GONE);
            image4.setVisibility(View.GONE);
            textQuantity.setVisibility(View.GONE);
        } else if (imageTweet.getUrlPictures().size() < 4) {
            Picasso.get().load(imageTweet.getUrlPictures().get(0)).into(image1);
            Picasso.get().load(imageTweet.getUrlPictures().get(1)).into(image2);
            Picasso.get().load(imageTweet.getUrlPictures().get(2)).into(image3);
            image1.setVisibility(View.VISIBLE);
            image2.setVisibility(View.VISIBLE);
            image3.setVisibility(View.VISIBLE);
            image4.setVisibility(View.GONE);
            textQuantity.setVisibility(View.GONE);
            rl.setVisibility(View.GONE);
            linearlayoutdown.setVisibility(View.VISIBLE);
        } else if (imageTweet.getUrlPictures().size() < 5) {
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
            linearlayoutdown.setVisibility(View.VISIBLE);

        } else {
            Picasso.get().load(imageTweet.getUrlPictures().get(0)).into(image1);
            Picasso.get().load(imageTweet.getUrlPictures().get(1)).into(image2);
            Picasso.get().load(imageTweet.getUrlPictures().get(2)).into(image3);
            Picasso.get().load(imageTweet.getUrlPictures().get(3)).into(image4);
            image1.setVisibility(View.VISIBLE);
            image2.setVisibility(View.VISIBLE);
            image3.setVisibility(View.VISIBLE);
            image4.setVisibility(View.VISIBLE);
            textQuantity.setVisibility(View.VISIBLE);
            textQuantity.setText("+" + (imageTweet.getUrlPictures().size() - NUMPIC));
            rl.setVisibility(View.VISIBLE);
            linearlayoutdown.setVisibility(View.VISIBLE);

        }
        /*END CASE*/
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public int getItemCount() {
        return arrstrTweets.size();
    }

    //==================================================================================================================
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageFavorite;
        ImageView imageComment;
        ImageView imageFavoriteClicked;
        TextView tvUserName;
        TextView tweet;
        TextView likes;
        TextView likesView;
        TextView tvForCountImages;

        ImageView image1;
        ImageView image2;
        ImageView image3;
        ImageView image4;

        public RelativeLayout parentLayout;
        RelativeLayout rl;
        RelativeLayout relativeLayoutComments;
        LinearLayout linearLayout;
        TextView numberofComents;
        LinearLayout linearLayoutdown;
        LinearLayout linearLayoutup;
        LinearLayout llDetailActivity;

        RecyclerViewAdapter mAdapter;

        //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        public ViewHolder(final View itemView, RecyclerViewAdapter adapter) {
            super(itemView);
            tvUserName = itemView.findViewById(R.id.row_view_tv_username);
            imageFavorite = itemView.findViewById(R.id.row_view_iv_favorite);
            imageComment = itemView.findViewById(R.id.row_view_iv_comentario);
            imageFavoriteClicked = itemView.findViewById(R.id.row_view_iv_favorite);

            likesView =itemView. findViewById(R.id.row_view_tv_seccion_likes);

            tweet = itemView.findViewById(R.id.row_view_tv_tweet_view);

            likes = itemView.findViewById(R.id.row_view_tv_likes);


            parentLayout = itemView.findViewById(R.id.activity_main_dlMain);


            image1 = itemView.findViewById(R.id.row_view_iv_image1);
            image2 = itemView.findViewById(R.id.row_view_image2);
            image3 = itemView.findViewById(R.id.row_view_image3);
            image4 = itemView.findViewById(R.id.row_view_image4);

            tvForCountImages = itemView.findViewById(R.id.row_view_tvForCountImages);
            rl = itemView.findViewById(R.id.rl);
            linearLayout = itemView.findViewById(R.id.row_view_linear_layout_imageview);
            numberofComents = itemView.findViewById(R.id.row_view_iv_number_of_coments);
            linearLayoutdown = itemView.findViewById(R.id.row_view_linear_layout_down);
            llDetailActivity = itemView.findViewById(R.id.row_view_ll_detail_activity);

        }
    }
//----------------------------------------------------------------------------------------------------------------------
}