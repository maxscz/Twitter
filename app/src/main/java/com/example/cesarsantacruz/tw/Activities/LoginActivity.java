package com.example.cesarsantacruz.tw.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cesarsantacruz.tw.R;

//======================================================================================================================
public class LoginActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener {
    Toolbar toolbar;
    Button btLogingButton;
    EditText etUserLoging;
    EditText etPasswordLoging;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);
                                                            //Asignacion de xml toolbar a variable toolbar
        Toolbar myToolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(myToolbar);
                                                            //Asignacion de xml button a variable button
        btLogingButton = findViewById(R.id.activity_loging_view_btLogingButton);

        etUserLoging = findViewById(R.id.activity_loging_etUserLoging);

        etPasswordLoging = findViewById(R.id.activity_loging_etPasswordLoging);


        etUserLoging.addTextChangedListener(this);
//----------------------------------------------------------------------------------------------------------------------
        etPasswordLoging.addTextChangedListener(this);
        btLogingButton.setOnClickListener(this);

    }

    private void TextChange(CharSequence charSequence, String etToCompare){
        if ((charSequence.length()>0)&&(etToCompare.length()>0) ) {
            btLogingButton.setEnabled(true);

        } else {
            btLogingButton.setEnabled(false);

        }
        Log.d("button","is enable: "  + btLogingButton.isEnabled());
    }
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
                                                            //Metodos de apoyo para TOOLBAR
    @Override
    //Creacion de menu
    public boolean onCreateOptionsMenu(
            Menu menu) {
        getMenuInflater().inflate(R.menu.directory, menu);
        return true;
    }
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @Override
    //Adiccion de opcion @param about_us
    public boolean onOptionsItemSelected(
            MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.option_menu) {

        }

        return true;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if(etUserLoging.getText().hashCode() == charSequence.hashCode()){
            TextChange(charSequence, etPasswordLoging.getText().toString());
        }
        else if(etPasswordLoging.getText().hashCode() == charSequence.hashCode()){
            TextChange(charSequence, etUserLoging.getText().toString());
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        if((Button)view == btLogingButton){
            Toast.makeText(this,"Se ha iniciado sesión!!",Toast.LENGTH_SHORT).show();
        }
    }

//----------------------------------------------------------------------------------------------------------------------

}
//======================================================================================================================
/*END TASK*/
