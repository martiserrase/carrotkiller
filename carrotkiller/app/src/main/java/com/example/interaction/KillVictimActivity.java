package com.example.interaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class KillVictimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.killvictim);

        Button backMenu_button = findViewById(R.id.backGame);
        /*Button backProfile_button = findViewById(R.id.backProfile);

        backProfile_button.setOnClickListener(view -> {
            Intent intent = new Intent(KillVictimActivity.this, NavActivity.class);
            startActivity(intent);
        });*/

        backMenu_button.setOnClickListener(view -> {
            Intent intent = new Intent(KillVictimActivity.this, NavActivity.class);
            startActivity(intent);
        });
    }
}