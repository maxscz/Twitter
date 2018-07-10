package com.example.cesarsantacruz.tw.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.example.cesarsantacruz.tw.Activities.MainActivity;
import com.example.cesarsantacruz.tw.R;

//======================================================================================================================
public class LoginActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener {
    Button btLogingButton;
    EditText etUserLoging;
    EditText etPasswordLoging;
    boolean checked;
    SharedPreferences loginPrefs;
    SharedPreferences.Editor editLogin;

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

        loginPrefs = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        editLogin = loginPrefs.edit();

        etPasswordLoging.addTextChangedListener(this);
        btLogingButton.setOnClickListener(this);


    }

    //------------------------------------------------------------------------------------------------------------------
    private void TextChange(CharSequence charSequence, String etToCompare){
        if ((charSequence.length() >= 4)&&(etToCompare.length() >= 6) ) {
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
            TextChange(charSequence, etPasswordLoging.getText().toString());
        }
        else if(etPasswordLoging.getText().hashCode() == charSequence.hashCode()){
            TextChange(charSequence, etUserLoging.getText().toString());
        }
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public void afterTextChanged(Editable editable) {

    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void rememberMe(View view) {
        checked = ((CheckBox) view).isChecked();
        if (
                checked
                ) {
            editLogin.putBoolean("remember me", true);
            editLogin.putString("user", etUserLoging.toString());
            editLogin.putString("password", etPasswordLoging.toString());
            editLogin.commit();
        } else {
            editLogin.clear();
            editLogin.commit();
        }
        onClick(view);
    }

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    public void onClick(View view) {
        if((Button)view == btLogingButton){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this,"Sign in succesful!",Toast.LENGTH_SHORT).show();
        }
    }
}

//----------------------------------------------------------------------------------------------------------------------
//======================================================================================================================
/*END TASK*/
