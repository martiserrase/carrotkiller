package com.example.interaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DeadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dead);

        Button backMenu = findViewById(R.id.backGame);

        backMenu.setOnClickListener(view -> {
            Intent intent = new Intent(DeadActivity.this, NavActivity.class);
            startActivity(intent);
        });
    }
}