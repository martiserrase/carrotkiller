package com.example.interaction;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfileActivity extends AppCompatActivity {

    //FirebaseUser user;
    DatabaseReference database;
    Button backMenu_button;
    Button change_button;

    TextView name;
    TextView surname;
    TextView addInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        database = FirebaseDatabase.getInstance("https://carrot-game-4cea2-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        //database = FirebaseDatabase.getInstance().getReference();

        //String id = user.getUid();
        //DatabaseReference ref = database.child(id);

        backMenu_button = findViewById(R.id.backGame);
        change_button = findViewById(R.id.change);

        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        addInfo = findViewById(R.id.additional_info);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()) {
                    String nameS = snapshot.getValue().toString();
                    String surnameS = snapshot.getValue().toString();
                    String addInfoS = snapshot.getValue().toString();
                    name.setText(nameS);
                    surname.setText(surnameS);
                    addInfo.setText(addInfoS);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        backMenu_button.setOnClickListener(view -> {
            Intent intent = new Intent(ProfileActivity.this, StartedGameActivity.class);
            startActivity(intent);
        });

        change_button.setOnClickListener(view -> {
            Intent intent = new Intent(ProfileActivity.this, ChangeProfileActivity.class);
            startActivity(intent);
        });

    }
}