package com.example.interaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class StartedGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started_game);

        Button backGame_button = findViewById(R.id.go_to_menu);
        Button statistics_button = findViewById(R.id.statistics_button);
        Button iveBeenKilled_button = findViewById(R.id.ive_been_killed_button);
        Button victimsProfile_button = findViewById(R.id.victim_profile_button);
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

        victimsProfile_button.setOnClickListener( view -> {
            Intent intent = new Intent(StartedGameActivity.this, NavActivity.class);
            startActivity(intent);

        });

        myProfile_button.setOnClickListener(view -> {
            Intent intent = new Intent(StartedGameActivity.this, ProfileActivity.class);
            startActivity(intent);

        });
    }

    // Toolbar menu options
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.share:
                Toast.makeText(this, "THANKS FOR SHARING!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.chuck_norris_item:
                // Api function not working, gets Null and fails
                // For further code check StatisticsActivity
                Toast.makeText(this, "CHUCK NORRIS FACT NOT WORKING", Toast.LENGTH_LONG).show();
                return true;

            case R.id.log_out_icon:
                Toast.makeText(this, "CONFIRM LOG OUT!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.confirm_log_out:
                Toast.makeText(StartedGameActivity.this, "LOGGING OUT", Toast.LENGTH_LONG).show();
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(StartedGameActivity.this, LoginActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
