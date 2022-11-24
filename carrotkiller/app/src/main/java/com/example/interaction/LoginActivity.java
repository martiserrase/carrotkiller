package com.example.interaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
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
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton;
    private Button registerButton;
    private EditText emailView;
    private EditText passwordView;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginButton = findViewById(R.id.login_button);
        registerButton = findViewById(R.id.register_button);
        emailView = findViewById(R.id.email);
        passwordView = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    private void loginUser() {
        String email = emailView.getText().toString();
        String password = passwordView.getText().toString();

        if(TextUtils.isEmpty(email)) {
            emailView.setError("Email cannot be empty");
            emailView.requestFocus();
        } else if(TextUtils.isEmpty(password)) {
            passwordView.setError("Password cannot be empty");
            passwordView.requestFocus();
        } else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "SUCESSFULLY LOGGED", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MenuActivity.class));
                    } else {
                        Toast.makeText(LoginActivity.this, "THE USERNAME/PASSWORD IS NOT CORRECT", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }
}