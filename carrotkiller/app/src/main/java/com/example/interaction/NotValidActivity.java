package com.example.interaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NotValidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.codenotvalid);

        Button backMenu_button = findViewById(R.id.backGame);
        Button backCode_button = findViewById(R.id.backCode);

        backMenu_button.setOnClickListener(view -> {
            Intent intent = new Intent(NotValidActivity.this, NavActivity.class);
            startActivity(intent);
        });

        backCode_button.setOnClickListener(view -> {
            Intent intent = new Intent(NotValidActivity.this, MurderedActivity.class);
            startActivity(intent);
        });
    }
}