package com.example.interaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.interaction.api.ChuckNorris;
import com.example.interaction.api.ChuckNorrisApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StatisticsActivity extends AppCompatActivity {

    private TextView chuckNorrisTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        Button backGame_button = findViewById(R.id.go_to_game_button);

        backGame_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StatisticsActivity.this, StartedGameActivity.class);
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
        chuckNorrisTextView = findViewById(R.id.chuck_norris_item);
        switch (item.getItemId()) {

            case R.id.share:
                Toast.makeText(this, "THANKS FOR SHARING!", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.chuck_norris_item:
                // Api function not working, gets Null and fails
                //Toast.makeText(this, chuckNorrisTextView.getText(), Toast.LENGTH_LONG).show();
                //createChuckNorrisFact();
                Toast.makeText(this, "CHUCK NORRIS FACT NOT WORKING", Toast.LENGTH_LONG).show();
                return true;
            case R.id.log_out_icon:
                Toast.makeText(this, "CONFIRM LOG OUT!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.confirm_log_out:
                Toast.makeText(this, "LOGGED OUT", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //function to get the chuck norris fact from the api
    private void createChuckNorrisFact() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ChuckNorrisApi chuckNorrisApi = retrofit.create(ChuckNorrisApi.class);
        Call<ChuckNorris> call = chuckNorrisApi.getChuckNorris();

        call.enqueue(new Callback<ChuckNorris>() {
            @Override
            public void onResponse(Call<ChuckNorris> call, Response<ChuckNorris> response) {
                if (!response.isSuccessful()) {
                    chuckNorrisTextView.setText(response.code());
                    return;
                }
                ChuckNorris randomFact = response.body();
                chuckNorrisTextView.setText(randomFact.getValue());
            }

            @Override
            public void onFailure(Call<ChuckNorris> call, Throwable t) {
                chuckNorrisTextView.setText(t.getMessage());
            }
        });
    }

}
