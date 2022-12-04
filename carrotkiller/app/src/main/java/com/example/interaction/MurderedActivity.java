package com.example.interaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MurderedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.murdered);

        Button backMenu_button = findViewById(R.id.backGame);
        Button exec_button = findViewById(R.id.exec);

        EditText code = findViewById(R.id.code);

        backMenu_button.setOnClickListener(view -> {
            Intent intent = new Intent(MurderedActivity.this, StartedGameActivity.class);
            startActivity(intent);
        });

        exec_button.setOnClickListener(view -> {
            //Buscaría en la base de datos el código del killer
            if(code.getText().toString().equals("0000")) {
                Intent intent = new Intent(MurderedActivity.this, DeadActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(MurderedActivity.this, NotValidActivity.class);
                startActivity(intent);
            }
        });
    }
}