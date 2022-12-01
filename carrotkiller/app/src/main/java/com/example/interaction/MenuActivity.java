package com.example.interaction;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MenuActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mAuth = FirebaseAuth.getInstance();

        Button myProfile_button = findViewById(R.id.my_profile_button);
        Button newGame_button = findViewById(R.id.new_game_button);
        Button joinGame_button = findViewById(R.id.join_game_button);
        Button continueGame_button = findViewById(R.id.continue_game_button);
        Button logout_button = findViewById(R.id.log_out_button);

        newGame_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, NewGameActivity.class);
                startActivity(intent);

            }
        });

        joinGame_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, JoinGameActivity.class);
                startActivity(intent);

            }
        });

        continueGame_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, StartedGameActivity.class);
                startActivity(intent);

            }
        });


        myProfile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, ProfileActivity.class);
                startActivity(intent);

            }
        });

        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MenuActivity.this, "LOGGED OUT!", Toast.LENGTH_SHORT).show();
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

//    // Toolbar menu options
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.settings_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.share:
//                Toast.makeText(this, "THANKS FOR SHARING!", Toast.LENGTH_SHORT).show();
//                screenShot(getWindow().getDecorView().getRootView());
//                return true;
//            case R.id.quit_game:
//                Toast.makeText(this, "GOODBYE!", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.log_out:
//                Toast.makeText(this, "CONFIRM LOG OUT!", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.confirm_log_out:
//                Toast.makeText(this, "LOGGED OUT", Toast.LENGTH_SHORT).show();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//    public Bitmap screenShot(View view) {
//        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(),
//                view.getHeight(), Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(bitmap);
//        view.draw(canvas);
//        return bitmap;
//    }
}