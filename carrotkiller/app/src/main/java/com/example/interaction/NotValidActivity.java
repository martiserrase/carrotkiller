package com.example.interaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NotValidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.codenotvalid);

        Button backMenu_button = findViewById(R.id.backMenu);
        Button backCode_button = findViewById(R.id.backCode);

        backMenu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NotValidActivity.this, "Iría a la ventana de MENU", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(ProfileActivity.this, LoginActivity.class); // tendria que ir al menu
                //startActivity(intent);
            }
        });

        backCode_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotValidActivity.this, MurderedActivity.class);
                startActivity(intent);
            }
        });
    }
}