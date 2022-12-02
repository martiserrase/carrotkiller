package com.example.interaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class ChangeProfileActivity extends AppCompatActivity {

    FirebaseAuth auth;
    DatabaseReference ref;
    Button photo_button, cancel_button, save_button;
    EditText nameT, surnameT, addinfoT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changeprofile);

        auth = FirebaseAuth.getInstance();
        ref = FirebaseDatabase.getInstance("https://carrot-game-4cea2-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        photo_button = findViewById(R.id.change_photo);
        cancel_button = findViewById(R.id.cancel_button);
        save_button = findViewById(R.id.save_button);
        nameT = findViewById(R.id.name);
        surnameT = findViewById(R.id.surname);
        addinfoT = findViewById(R.id.additional_info);

        String id = auth.getUid();

        photo_button.setOnClickListener(view -> Toast.makeText(ChangeProfileActivity.this, "Saltaría una pestaña para seleccionar foto??", Toast.LENGTH_SHORT).show());

        cancel_button.setOnClickListener(view -> {
            Intent intent = new Intent(ChangeProfileActivity.this, ProfileActivity.class);
            startActivity(intent);
        });


        // Para guardar en la base de datos
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameS = nameT.getText().toString();
                String surnameS = surnameT.getText().toString();
                String addInfoS = addinfoT.getText().toString();
/*
                HashMap<String, String> userMap = new HashMap<>();
                userMap.put("name", nameS);
                userMap.put("surname", surnameS);
                userMap.put("additionalInfo", addInfoS);*/
                ref.child("profiles").child(id).push().setValue(new Profiles(nameS, surnameS, addInfoS)).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                    }
                });
                Intent intent = new Intent(ChangeProfileActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}