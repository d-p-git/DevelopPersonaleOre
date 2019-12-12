package com.example.developpersonaleore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpPage extends AppCompatActivity {

    EditText emailSignInET;
    EditText passwordSignInET;

    Button signInBtn;
    
    DBManager dbManager;

    Bundle user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        emailSignInET = findViewById(R.id.email_sign_up_edit_text);
        passwordSignInET = findViewById(R.id.password_sign_up_edit_text);

        signInBtn = findViewById(R.id.sign_up_button);
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveUser();
            }
        });
    }

    void saveUser(){
        user = new Bundle();
        user.putString("email",emailSignInET.getText().toString());
        user.putString("password",passwordSignInET.getText().toString());
        int contactID = (int) dbManager.insertUser(user);
        Toast.makeText(this,"Registrazione effettuata",Toast.LENGTH_SHORT).show();
        finish();

    }
}
