package com.example.interaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartedGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started_game);

        Button backGame_button = findViewById(R.id.go_to_menu);
        Button statistics_button = findViewById(R.id.statistics_button);
        Button iveBeenKilled_button = findViewById(R.id.ive_been_killed_button);
        //Button victimsProfile_button = findViewById(R.id.victim_profile_button);
        Button myProfile_button = findViewById(R.id.my_profile_button);


        backGame_button.setOnClickListener(view -> {
            Intent intent = new Intent(StartedGameActivity.this, NavActivity.class);
            startActivity(intent);

        });


        statistics_button.setOnClickListener(view -> {
            Intent intent = new Intent(StartedGameActivity.this, StatisticsActivity.class);
            startActivity(intent);

        });

        iveBeenKilled_button.setOnClickListener(view -> {
            Intent intent = new Intent(StartedGameActivity.this, MurderedActivity.class);
            startActivity(intent);

        });

        /*victimsProfile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartedGameActivity.this, NavActivity.class);
                startActivity(intent);

            }
        });*/

        myProfile_button.setOnClickListener(view -> {
            Intent intent = new Intent(StartedGameActivity.this, ProfileActivity.class);
            startActivity(intent);

        });
    }
}
