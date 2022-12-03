package com.example.interaction;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CongratsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);

        Button backMenu = findViewById(R.id.new_victim);

        backMenu.setOnClickListener(view -> {
            Intent intent = new Intent(CongratsActivity.this, NavActivity.class);
            startActivity(intent);
        });
    }
}
