package com.example.interaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class KillVictimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.killvictim);

        Button backMenu_button = findViewById(R.id.backMenu);
        Button backProfile_button = findViewById(R.id.backProfile);

        backProfile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KillVictimActivity.this, VictimProfileActivity.class);
                startActivity(intent);
            }
        });

        backMenu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(KillVictimActivity.this, "Iría a la ventana de MENU", Toast.LENGTH_SHORT).show();
            }
        });
    }
}