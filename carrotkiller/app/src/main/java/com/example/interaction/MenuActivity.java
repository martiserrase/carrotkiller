package com.example.interaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button myProfile_button = findViewById(R.id.my_profile_button);
        Button newGame_button = findViewById(R.id.new_game_button);
        Button joinGame_button = findViewById(R.id.join_game_button);
        Button continueGame_button = findViewById(R.id.continue_game_button);

        newGame_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, NewGameActivity.class);
                startActivity(intent);

            }
        });

        joinGame_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, JoinGameActivity.class);
                startActivity(intent);

            }
        });

        continueGame_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, StartedGameActivity.class);
                startActivity(intent);

            }
        });


        myProfile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, ProfileActivity.class);
                startActivity(intent);

            }
        });
    }
}
