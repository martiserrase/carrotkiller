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

public class MurderedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.murdered);

        Button backMenu_button = findViewById(R.id.backGame);
        Button exec_button = findViewById(R.id.exec);

        EditText code = findViewById(R.id.code);

        backMenu_button.setOnClickListener(view -> {
            Intent intent = new Intent(MurderedActivity.this, StartedGameActivity.class);
            startActivity(intent);
        });

        exec_button.setOnClickListener(view -> {
            //Buscaría en la base de datos el código del killer
            if(code.getText().toString().equals("0000")) {
                Intent intent = new Intent(MurderedActivity.this, DeadActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(MurderedActivity.this, NotValidActivity.class);
                startActivity(intent);
            }
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
                Toast.makeText(MurderedActivity.this, "LOGGING OUT", Toast.LENGTH_LONG).show();
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MurderedActivity.this, LoginActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}