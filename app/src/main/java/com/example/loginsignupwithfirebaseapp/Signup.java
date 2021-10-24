package com.example.loginsignupwithfirebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    EditText e1, e2;
    Button b1, b2;
    ProgressBar p;
    FirebaseAuth f1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        e1 = findViewById(R.id.editText3);
        e2 = findViewById(R.id.editText4);
        b1 = findViewById(R.id.button3);
        b2 = findViewById(R.id.button4);
        p = findViewById(R.id.progressBar2);
        f1 = FirebaseAuth.getInstance();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Signup.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}