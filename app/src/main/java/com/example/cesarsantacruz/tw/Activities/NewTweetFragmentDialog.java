package com.example.cesarsantacruz.tw.Activities;

import android.app.DialogFragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.cesarsantacruz.tw.Models.TwitterFeed;
import com.example.cesarsantacruz.tw.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class NewTweetFragmentDialog extends DialogFragment {
    Button btnNewTweet;
    ProgressBar pbarCharCounter;
    EditText etNewTweet;
    private SimpleDateFormat simpleDateFormat;
    private Calendar calendar;
    private String fecha;
    private String hora;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
         View v = inflater.inflate(R.layout.activity_new_tweet,container,false);



        btnNewTweet = v.findViewById(R.id.activity_new_tweet_toolbar_btnNewTweet);
        etNewTweet = v.findViewById(R.id.activity_new_tweet_etNewTweet);
        pbarCharCounter = v.findViewById(R.id.activity__new_tweet_pbarCharCounter);
        Bundle b = getArguments();
        final String type = b.getString("Type");
        final int position = b.getInt("Position");
        if ( type.equalsIgnoreCase("Tweet"))
        {
            btnNewTweet.setText("TWITTEAR");
        }
        else {
            btnNewTweet.setText("RESPONDER");
        }
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
                            (getContext().getDrawable(R.drawable.progress_determinate_almost_full_circular_bar));
                    if (editable.length()>119){
                        pbarCharCounter.setProgressDrawable
                                (getContext().getDrawable(R.drawable.progress_determinate_full_circular_bar));
                    }
                }

                else {
                    pbarCharCounter.setProgressDrawable
                            (getContext().getDrawable(R.drawable.progress_determinate_circular_bar));
                }
            }
            /*END CASE*/


        });
        /*TwitterFeed twitterFeed = new TwitterFeed("probando probando probando", "perro chido",
                "@perro123", R.drawable.perro, R.drawable.perro, 4, 6,arrUrl);
        arrstrTweets.add(twitterFeed); */
        btnNewTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                fecha = simpleDateFormat.format(calendar.getTime());
                if ( type.equalsIgnoreCase("Tweet"))
                {

                    MainActivity activity = (MainActivity) getActivity();
                    ArrayList<String> arrUrl = new ArrayList<>();
                    arrUrl.add("https://www.viajaraitalia.com/wp-content/uploads/2009/09/venecia-de-noche.jpg");
                    TwitterFeed newTweet = new TwitterFeed(etNewTweet.getText().toString(), "perro chido",
                            "@perro123",fecha ,R.drawable.perro, R.drawable.perro, 0, 0,arrUrl);
                    activity.createNewTweet(newTweet);
                    dismiss();
                }
                else {
                    MainActivity activity = (MainActivity) getActivity();
                    ArrayList<String> arrUrl = new ArrayList<>();
                    arrUrl.add("https://www.viajaraitalia.com/wp-content/uploads/2009/09/venecia-de-noche.jpg");
                    TwitterFeed newTweet = new TwitterFeed(etNewTweet.getText().toString(), "perro chido",
                            "@perro123",fecha, R.drawable.perro, R.drawable.perro, 0, 0,arrUrl);
                    activity.addCommentToTwitter(newTweet,position);
                    dismiss();

                }

            }
        });
//----------------------------------------------------------------------------------------------------------------------



        return v;

    }
//
}
