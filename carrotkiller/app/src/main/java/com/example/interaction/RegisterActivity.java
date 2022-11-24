package com.example.interaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        TextView email = (TextView) findViewById(R.id.email);
        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);
        TextView repeat_password = (TextView) findViewById(R.id.repeat_password);

        Button signIn_button = (Button) findViewById(R.id.sign_in_button);

        signIn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Habría que añadir a la base de datos el email, username y contraseña
                if(password.getText().toString().equals(repeat_password.getText().toString()) && !password.getText().toString().equals("")) {
                    //correct
                    Toast.makeText(RegisterActivity.this, "Misma contraseña", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, ProfileActivity.class);
                    startActivity(intent);
                } else {
                    //fail
                    Toast.makeText(RegisterActivity.this, "THE PASSWORD DOESN'T MATCH", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}