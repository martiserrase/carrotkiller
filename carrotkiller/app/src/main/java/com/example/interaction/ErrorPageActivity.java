package com.example.interaction;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ErrorPageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_page);

        Button backMenu = findViewById(R.id.backGame);

        backMenu.setOnClickListener(view -> {
            Intent intent = new Intent(ErrorPageActivity.this, NavActivity.class);
            startActivity(intent);
        });
    }
}
