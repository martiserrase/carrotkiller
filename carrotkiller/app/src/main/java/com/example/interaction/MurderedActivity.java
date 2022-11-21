package com.example.interaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MurderedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.murdered);

        Button backMenu_button = findViewById(R.id.backMenu);
        Button exec_button = findViewById(R.id.exec);

        EditText code = findViewById(R.id.code);

        backMenu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MurderedActivity.this, StartedGameActivity.class);
                startActivity(intent);
            }
        });

        exec_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Buscaría en la base de datos el código del killer
                if(code.getText().toString().equals("0000")) {
                    Intent intent = new Intent(MurderedActivity.this, DeadActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(MurderedActivity.this, NotValidActivity.class);
                    startActivity(intent);
                }
                //Toast.makeText(MurderedActivity.this, "Comprobaría que el código introducido sea el correcto", Toast.LENGTH_SHORT).show();
            }
        });
    }
}