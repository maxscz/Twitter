package com.example.cesarsantacruz.tw.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cesarsantacruz.tw.R;
import com.example.cesarsantacruz.tw.Models.TwitterFeed;

import java.util.ArrayList;

public class LikesAdapter extends RecyclerView.Adapter<LikesAdapter.ViewHolder> {
    private ArrayList<TwitterFeed> arrstrLikes;
    private Context context;

    public LikesAdapter(Context context, ArrayList<TwitterFeed> arrstrLikes) {
        this.context = context;
        this.arrstrLikes = arrstrLikes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_likes, parent, false);
        ViewHolder holder = new ViewHolder(view, this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ViewHolder holder2 = holder;

    }

    @Override
    public int getItemCount() {
        return arrstrLikes.size();
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profilePic;
        TextView profileName;
        TextView profileUser;
        TextView fecha;
        TextView hora;

        public ViewHolder(View itemView, LikesAdapter adapter) {
            super(itemView);

            profilePic = itemView.findViewById(R.id.like_picture);
            profileName = itemView.findViewById(R.id.nombre_likes);
            profileUser = itemView.findViewById(R.id.user_likes);
            fecha = itemView.findViewById(R.id.fecha_view);
            hora = itemView.findViewById(R.id.hora_view);
        }

    }
}
