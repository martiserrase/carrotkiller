package com.example.interaction;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
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
                if (snapshot.exists()) {
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

    // Toolbar menu options
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.share:
                Toast.makeText(this, "THANKS FOR SHARING!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.chuck_norris_item:
                // Api function not working, gets Null and fails
                // For further code check StatisticsActivity
                Toast.makeText(this, "CHUCK NORRIS FACT NOT WORKING", Toast.LENGTH_LONG).show();
                return true;

            case R.id.log_out_icon:
                Toast.makeText(this, "CONFIRM LOG OUT!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.confirm_log_out:
                Toast.makeText(ProfileActivity.this, "LOGGING OUT", Toast.LENGTH_LONG).show();
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}