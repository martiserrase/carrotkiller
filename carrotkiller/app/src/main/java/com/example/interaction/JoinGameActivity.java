package com.example.interaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class JoinGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_game);

        Button cancel_button = findViewById(R.id.cancel_button);
        Button submit_button = findViewById(R.id.submit_button);

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JoinGameActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

//        submit_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(JoinGameActivity.this, MenuActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}
