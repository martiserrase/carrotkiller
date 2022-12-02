package com.example.interaction;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GameResultsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_results);

        Button backMenu = findViewById(R.id.backGame);

        backMenu.setOnClickListener(view -> {
            Intent intent = new Intent(GameResultsActivity.this, NavActivity.class);
            startActivity(intent);
        });
    }
}
