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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class ChangeProfileActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference().child("profile");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changeprofile);

        Button photo_button = findViewById(R.id.change_photo);
        Button cancel_button = findViewById(R.id.cancel_button);
        Button save_button = findViewById(R.id.save_button);
        EditText name = findViewById(R.id.name);
        EditText surname = findViewById(R.id.surname);
        EditText addinfo = findViewById(R.id.additional_info);


        photo_button.setOnClickListener(view -> Toast.makeText(ChangeProfileActivity.this, "Saltaría una pestaña para seleccionar foto??", Toast.LENGTH_SHORT).show());

        // Para mostrar algo de la base de datos
        cancel_button.setOnClickListener(view -> {
            Intent intent = new Intent(ChangeProfileActivity.this, ProfileActivity.class);
            startActivity(intent);
        });


        // Para guardar en la base de datos
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameS = name.getText().toString();
                String surnameS = surname.getText().toString();
                String addInfo = addinfo.getText().toString();

                HashMap<String, String> userMap = new HashMap<>();

                userMap.put("name", nameS);
                userMap.put("surname", surnameS);
                userMap.put("additionalInfo", addInfo);

                ref.setValue(userMap);
                Intent intent = new Intent(ChangeProfileActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}