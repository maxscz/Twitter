package com.example.cesarsantacruz.tw.Activities;

import android.app.VoiceInteractor;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cesarsantacruz.tw.Activities.MainActivity;
import com.example.cesarsantacruz.tw.Connection.Ws;
import com.example.cesarsantacruz.tw.R;
import com.example.cesarsantacruz.tw.Utils.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

//======================================================================================================================
public class LoginActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener {
    Button btLogingButton;
    EditText etUserLoging;
    EditText etPasswordLoging;
    boolean checked;
    final int INT_REQUIRED_USER = 4;
    final int INT_REQUIRED_PASSWORD = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);
                                                            //Asignacion de xml toolbar a variable toolbar
        Toolbar myToolbar = findViewById(R.id.activity_login_tblogin);
        setSupportActionBar(myToolbar);
                                                            //Asignacion de xml button a variable button
        btLogingButton = findViewById(R.id.activity_loging_view_btLogingButton);
        etUserLoging = findViewById(R.id.activity_loging_etUserLoging);
        etPasswordLoging = findViewById(R.id.activity_loging_etPasswordLoging);
        etUserLoging.addTextChangedListener(this);

        etPasswordLoging.addTextChangedListener(this);
        btLogingButton.setOnClickListener(this);

        etUserLoging.setText(SessionManager.getInstace(this).getRememberUser());
        etPasswordLoging.setText(SessionManager.getInstace(this).getRememberPassword());
    }

    //------------------------------------------------------------------------------------------------------------------
    private void TextChange(CharSequence charSequence, String etToCompare, int intRequired, int intRequiredToCompare) {
        if ((charSequence.length() >= intRequired)&&(etToCompare.length() >= intRequiredToCompare)) {
            btLogingButton.setEnabled(true);

        } else {
            btLogingButton.setEnabled(false);

        }
        Log.d("button","is enabled: "  + btLogingButton.isEnabled());
    }
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    //Adiccion de opcion @param about_us
    public boolean onOptionsItemSelected(
            MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.directory_item_signOut) {

        }
        return true;
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if(etUserLoging.getText().hashCode() == charSequence.hashCode()){
            TextChange(charSequence, etPasswordLoging.getText().toString(), INT_REQUIRED_USER, INT_REQUIRED_PASSWORD);
        }
        else if(etPasswordLoging.getText().hashCode() == charSequence.hashCode()){
            TextChange(charSequence, etUserLoging.getText().toString(), INT_REQUIRED_PASSWORD, INT_REQUIRED_USER);
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public void afterTextChanged(Editable editable) {

    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public void onClick(View view) {

        if((Button)view == btLogingButton){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this,"Sign in succesful!",Toast.LENGTH_SHORT).show();
            finish();
        }
        CheckBox checkBox = findViewById(R.id.activity_login_cbRemember);
        String user = "";
        String password = "";

        if (
                checkBox.isChecked()
                ){
            user = etUserLoging.getText().toString();
            password = etPasswordLoging.getText().toString();
            postLogin(user,password);
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    private void postLogin(final String username_I, final String password_I)
    {
        final RequestQueue mRequestQueue = Volley.newRequestQueue(this);
        StringRequest postRequest = new StringRequest(Request.Method.POST, Ws.LOGIN(),
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        JSONObject jsonResponse = null;
                        try {
                            jsonResponse = new JSONObject(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        String token = jsonResponse.optString("access_token");
                        Log.d("Access Token: ", token);

                        SessionManager.getInstace(LoginActivity.this).setRememberUser(username_I);
                        SessionManager.getInstace(LoginActivity.this).setRememberPassword(password_I);
                        SessionManager.getInstace(LoginActivity.this).setAccessToken(token);

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        Toast.makeText(LoginActivity.this,"Sign in succesful!",Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.toString());
                    }
                }
        ) {
            @Override
            protected Map getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("username", username_I);
                params.put("password", password_I);
                params.put("grant_type", "password");

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                params.put("Accepts", "application/json");
              /*params.put("Accept-Language", "en-gb");
                params.put("Audience", "Any");
                params.put("Cache-Control", "no-cache");*/

                return params;
            }

            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";

            }
        };
        mRequestQueue.add(postRequest);
    }
}
//======================================================================================================================
/*END TASK*/
