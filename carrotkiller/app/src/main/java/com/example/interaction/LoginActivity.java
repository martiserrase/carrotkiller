package com.example.interaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Toast.makeText(this, "prueba", Toast.LENGTH_SHORT).show();

        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);

        Button login = findViewById(R.id.login_button);
        Button register = findViewById(R.id.register_button);

        //TextView forgotPass = (TextView) findViewById(R.id.forgotpass);

        //user y user
        login.setOnClickListener(view -> {
            // Habría que buscar en la base de datos el username y después que ese nombre coincida con la contraseña guardada
            if(username.getText().toString().equals("user") && password.getText().toString().equals("user")) {
                //correct
                Toast.makeText(LoginActivity.this, "SUCESSFULLY LOGGED", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                startActivity(intent);
            } else {
                //fail
                Toast.makeText(LoginActivity.this, "THE USERNAME/PASSWORD IS NOT CORRECT", Toast.LENGTH_SHORT).show();
            }
        });

        register.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
        /*
        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Podríamos poner que si olvida la contraseña puede poner un código de recuperación
            }
        });*/
    }
}