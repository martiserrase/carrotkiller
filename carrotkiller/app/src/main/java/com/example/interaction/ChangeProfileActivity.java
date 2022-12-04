package com.example.interaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChangeProfileActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;
    DatabaseReference ref;
    Button photo_button, cancel_button, save_button;
    EditText nameT, surnameT, addinfoT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changeprofile);

        auth = FirebaseAuth.getInstance();
        ref = FirebaseDatabase.getInstance("https://carrot-game-4cea2-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        user = auth.getCurrentUser();
        //String id = auth.getUid();

        photo_button = findViewById(R.id.change_photo);
        cancel_button = findViewById(R.id.cancel_button);
        save_button = findViewById(R.id.save_button);
        nameT = findViewById(R.id.name);
        surnameT = findViewById(R.id.surname);
        addinfoT = findViewById(R.id.additional_info);


        photo_button.setOnClickListener(view -> Toast.makeText(ChangeProfileActivity.this, "Saltaría una pestaña para seleccionar foto??", Toast.LENGTH_SHORT).show());

        cancel_button.setOnClickListener(view -> {
            Intent intent = new Intent(ChangeProfileActivity.this, ProfileActivity.class);
            startActivity(intent);
        });


        // Para guardar en la base de datos
        save_button.setOnClickListener(view -> {

            //String nameS = nameT.getText().toString();
                /*ref.child("profiles").child(id).push().setValue(new Profiles(nameS, surnameS, addInfoS)).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                    }
                });*/
            String nameS = nameT.getEditableText().toString();
            String addInfoS = addinfoT.getText().toString();
            String surnameS = surnameT.getText().toString();

            ref.child("Profile").push().setValue(new Profiles(nameS, surnameS, addInfoS)).addOnCompleteListener(task -> nameT.setText(""));

            /*HashMap<String, String> userMap = new HashMap<>();
            userMap.put("name", nameS);
            userMap.put("surname", surnameS);
            userMap.put("additionalInfo", addInfoS);*/
            Intent intent = new Intent(ChangeProfileActivity.this, ProfileActivity.class);
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
                Toast.makeText(ChangeProfileActivity.this, "LOGGING OUT", Toast.LENGTH_LONG).show();
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(ChangeProfileActivity.this, LoginActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}