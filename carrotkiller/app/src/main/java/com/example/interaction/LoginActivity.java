package com.example.interaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        Button login = (Button) findViewById(R.id.login_button);

        //TextView forgotPass = (TextView) findViewById(R.id.forgotpass);

        //pruebauser y pruebapass
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Habría que buscar en la base de datos el username y después que ese nombre coincida con la contraseña guardada
                if(username.getText().toString().equals("pruebauser") && password.getText().toString().equals("pruebapass")) {
                    //correct
                    Toast.makeText(LoginActivity.this, "SUCESSFULLY LOGGED", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), ProfileActivity.class);
                    startActivityForResult(intent, 0);
                } else {
                    //fail
                    Toast.makeText(LoginActivity.this, "THE USERNAME/PASSWORD IS NOT CORRECT", Toast.LENGTH_SHORT).show();
                }
            }
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