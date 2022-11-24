package com.example.interaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class pruebaRegister extends AppCompatActivity {

    private Button registerButton;
    private Button loginButton;
    private FirebaseAuth mAuth;
    private TextView emailView;
    private TextView passwordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        registerButton = findViewById(R.id.sign_in_button);
        loginButton = findViewById(R.id.login_button);
        mAuth = FirebaseAuth.getInstance();
        emailView = findViewById(R.id.email);
        passwordView = findViewById(R.id.password);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(pruebaRegister.this, LoginActivity.class));
            }
        });
    }

    private void createUser() {
        String email = emailView.getText().toString();
        String password = passwordView.getText().toString();

        if(TextUtils.isEmpty(email)) {
            emailView.setError("Email cannot be empty");
            emailView.requestFocus();
        } else if(TextUtils.isEmpty(password)) {
            passwordView.setError("Password cannot be empty");
            passwordView.requestFocus();
        } else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        Toast.makeText(pruebaRegister.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(pruebaRegister.this, LoginActivity.class));
                    } else {
                        Toast.makeText(pruebaRegister.this, "Registration error: ", Toast.LENGTH_SHORT).show(); //task.getException().getMessage()
                    }
                }
            });
        }
    }
}