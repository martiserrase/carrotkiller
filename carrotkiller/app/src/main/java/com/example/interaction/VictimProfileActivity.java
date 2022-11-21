package com.example.interaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VictimProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.victimsprofile);

        Button kill_button = findViewById(R.id.kill);

        kill_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VictimProfileActivity.this, KillVictimActivity.class);
                startActivity(intent);
            }
        });

        Button button = findViewById(R.id.backMenu);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(VictimProfileActivity.this, "Iría a la ventana de MENU", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(VictimProfileActivity.this, LoginActivity.class); // tendria que ir al menu
                //startActivity(intent);
            }
        });
    }
}