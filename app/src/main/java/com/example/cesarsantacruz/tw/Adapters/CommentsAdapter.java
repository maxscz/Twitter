package com.example.cesarsantacruz.tw.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cesarsantacruz.tw.R;
import com.example.cesarsantacruz.tw.Models.TwitterFeed;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {
    ArrayList<TwitterFeed> arrstrComments;
    Context context;
    EditText mEditComment;
    String strComment;
    Calendar calendar;
    SimpleDateFormat dateFormat;
    String textDate;

    public CommentsAdapter(Context context, ArrayList<TwitterFeed> arrstrComments) {
        this.context = context;
        this.arrstrComments = arrstrComments;
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    }

    @NonNull
    @Override
    public CommentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_comments, parent, false);
        ViewHolder holder = new ViewHolder(view, this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsAdapter.ViewHolder holder3, int position) {
        final ViewHolder holder = holder3;
        textDate = dateFormat.format(calendar.getTime());

        holder.profilePicture.setImageResource(R.drawable.gato);
        holder.name.setText("Gato");
        holder.user.setText("@Gato");
        holder.fecha.setText(textDate);
        holder.comentario.setText(arrstrComments.get(position).getComentario());

    }

    @Override
    public int getItemCount() {
        return arrstrComments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView profilePicture;
        TextView name;
        TextView user;
        TextView fecha;
        TextView comentario;

        public ViewHolder(View itemView, CommentsAdapter adapter) {
            super(itemView);

            profilePicture = itemView.findViewById(R.id.comment_picture);
            name = itemView.findViewById(R.id.comment_name);
            user = itemView.findViewById(R.id.comment_user);
            comentario = itemView.findViewById(R.id.comment_comentario);
            fecha = itemView.findViewById(R.id.fecha_hora_comment);
        }
    }
}
