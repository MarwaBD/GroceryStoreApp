package com.example.grocerystoreapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.grocerystoreapp.MainActivity;
import com.example.grocerystoreapp.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class WelcomeScreenActivity extends AppCompatActivity {

    Button startBtn;
    ProgressBar progressBar;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        FirebaseApp.initializeApp(this);

        startBtn = findViewById(R.id.Startbtn);
        auth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        if (auth.getCurrentUser() != null){
            progressBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(WelcomeScreenActivity.this, MainActivity.class));
            Toast.makeText(this, "Please wait you are already logged in", Toast.LENGTH_SHORT).show();
            finish();

        }


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeScreenActivity.this, LoginActivity.class));
            }
        });
    }
}