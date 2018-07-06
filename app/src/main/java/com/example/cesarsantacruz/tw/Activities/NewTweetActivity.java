package com.example.cesarsantacruz.tw.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.cesarsantacruz.tw.R;

public class NewTweetActivity extends AppCompatActivity {
    Button btnNewTweet;
    ProgressBar pbarCharCounter;
//----------------------------------------------------------------------------------------------------------------------
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_new_tweet);

        btnNewTweet = findViewById(R.id.activity_new_tweet_toolbar_btnNewTweet);
        EditText etNewTweet = findViewById(R.id.activity_new_tweet_etNewTweet);
        pbarCharCounter = findViewById(R.id.activity__new_tweet_pbarCharCounter);
                                                            //Activar Boton de Crear Tweet
        etNewTweet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                pbarCharCounter.setProgress(editable.length());
                Log.i("Counter" ,"the counter is in position:"+editable.length());
                /*CASE*/
                if (editable.length() > 0) {
                    btnNewTweet.setEnabled(true);
                } else {
                    btnNewTweet.setEnabled(false);
                }

                if (editable.length() > 100) {
                    pbarCharCounter.setProgressDrawable
                            (getDrawable(R.drawable.progress_determinate_almost_full_circular_bar));
                    if (editable.length()>119){
                        pbarCharCounter.setProgressDrawable
                                (getDrawable(R.drawable.progress_determinate_full_circular_bar));
                    }
                }

                    else {
                        pbarCharCounter.setProgressDrawable
                                (getDrawable(R.drawable.progress_determinate_circular_bar));
                    }
                }
                /*END CASE*/


        });

        btnNewTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
//----------------------------------------------------------------------------------------------------------------------

    }
}
