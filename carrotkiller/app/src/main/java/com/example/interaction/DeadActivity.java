package com.example.interaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DeadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dead);

        Button backMenu_button = findViewById(R.id.backMenu);

        backMenu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DeadActivity.this, "Iría a la ventana de MENU", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(ProfileActivity.this, LoginActivity.class); // tendria que ir al menu
                //startActivity(intent);
            }
        });
    }
}