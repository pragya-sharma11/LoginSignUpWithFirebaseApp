package com.example.loginsignupwithfirebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    Button b1, b2;
    ProgressBar p;
    FirebaseAuth f1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.editText1);
        e2 = findViewById(R.id.editText2);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        p = findViewById(R.id.progressBar);
        f1 = FirebaseAuth.getInstance();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Signup.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString(), s2 = e2.getText().toString();
                if(s1.isEmpty() && s2.isEmpty()){
                    e1.setError("Fill the email.");
                    e2.setError("Fill the password.");
                    return;
                }
                else if(s1.isEmpty()){
                    e1.setError("Fill the email.");
                    return;
                }
                else if(s2.isEmpty()){
                    e2.setError("Fill the password.");
                    return;
                }
                p.setVisibility(View.VISIBLE);
                e1.setVisibility(View.INVISIBLE);
                e2.setVisibility(View.INVISIBLE);
                b1.setVisibility(View.INVISIBLE);
                b2.setVisibility(View.INVISIBLE);
                f1.signInWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            p.setVisibility(View.INVISIBLE);
                            e1.setVisibility(View.VISIBLE);
                            e2.setVisibility(View.VISIBLE);
                            b1.setVisibility(View.VISIBLE);
                            b2.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(MainActivity.this, Logout.class);
                            startActivity(i);
                            finish();
                        }
                        else {
                            p.setVisibility(View.INVISIBLE);
                            e1.setVisibility(View.VISIBLE);
                            e2.setVisibility(View.VISIBLE);
                            b1.setVisibility(View.VISIBLE);
                            b2.setVisibility(View.VISIBLE);
                            Toast.makeText(MainActivity.this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}