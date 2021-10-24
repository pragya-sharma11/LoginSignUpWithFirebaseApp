package com.example.loginsignupwithfirebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Logout extends AppCompatActivity {
    Button b;
    FirebaseAuth f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        b = findViewById(R.id.button);
        f = FirebaseAuth.getInstance();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f.signOut();
                Toast.makeText(Logout.this, "Logout successfully", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Logout.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}