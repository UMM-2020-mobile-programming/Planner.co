package com.roomdb.note;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.roomdb.note.main.MainActivity;

public class login extends AppCompatActivity {
    EditText username, password;
    Button logg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);
        logg = (Button) findViewById(R.id.buttonLogin);

        logg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                String user = username.getText().toString();
                String pas = password.getText().toString();

                if(user.equals("admin") && pas.equals("123")){
                    Toast.makeText(getApplicationContext(),"Username dan Password benar",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent (login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(login.this);
                    builder.setMessage("username dan password salah")
                            .setNegativeButton("Retry", null).create().show();
                }
            }
        });
    }
}