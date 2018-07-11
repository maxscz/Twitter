package com.example.cesarsantacruz.tw.Activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cesarsantacruz.tw.Adapters.CommentsAdapter;
import com.example.cesarsantacruz.tw.Models.TwitterFeed;
import com.example.cesarsantacruz.tw.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CommentsActivity extends MainActivity {
    RecyclerView mRecyclerView;
    ArrayList<TwitterFeed> arrstrComments;

    Calendar calendar;
    SimpleDateFormat dateFormat;
    String textDate;

    TextView user;
    CommentsAdapter commentsAdapter;
    EditText mEditComment;
    ImageView mSendComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        mRecyclerView = findViewById(R.id.activity_comments_rvcomments);
        mEditComment = findViewById(R.id.activity_comments_etcomments);

        sendComment();
        getComments();

        commentsAdapter = new CommentsAdapter(this, arrstrComments);
        mRecyclerView.setAdapter(commentsAdapter);

        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
    }

    public void getComments() {
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        arrstrComments = new ArrayList<>();

        textDate = dateFormat.format(calendar.getTime());
    }

    private void sendComment () {
        mSendComment = findViewById(R.id.activity_comment_ivbtn);

        mSendComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = mEditComment.getText().toString();

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                textDate = dateFormat.format(calendar.getTime());


            }
        });
    }
}
