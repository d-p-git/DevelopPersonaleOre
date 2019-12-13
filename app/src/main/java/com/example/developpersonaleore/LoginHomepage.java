package com.example.developpersonaleore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginHomepage extends AppCompatActivity {


    TextView userTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_homepage);

        userTV = findViewById(R.id.login_user_text_view);
        Intent intent = getIntent();
        String message = intent.getStringExtra("user");

        userTV.setText("Benvenuto, "+message);

    }
}
