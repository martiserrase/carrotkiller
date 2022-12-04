package com.example.interaction;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;

public class NewGameActivity extends AppCompatActivity {


    EditText initial_date;
    EditText initial_time;
    EditText final_date;
    EditText final_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        Button cancel_button = findViewById(R.id.cancel_button);
        Button submit_button = findViewById(R.id.submit_button);

        initial_date = findViewById(R.id.initial_date_input);
        initial_time = findViewById(R.id.initial_time_input);
        final_date = findViewById(R.id.final_date_input);
        final_time = findViewById(R.id.final_time_input);

        initial_date.setInputType(InputType.TYPE_NULL);
        initial_time.setInputType(InputType.TYPE_NULL);
        final_date.setInputType(InputType.TYPE_NULL);
        final_time.setInputType(InputType.TYPE_NULL);


        initial_date.setOnClickListener(view -> showInitialDateDialog(initial_date));

        initial_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInitialTimeDialog(initial_time);
            }
        });

        final_date.setOnClickListener(view -> showFinalDateDialog(final_date));

        final_time.setOnClickListener(view -> showFinalTimeDialog(final_time));

        cancel_button.setOnClickListener(view -> {
            Intent intent = new Intent(NewGameActivity.this, NavActivity.class);
            startActivity(intent);
        });

        submit_button.setOnClickListener(view -> {
            Intent intent = new Intent(NewGameActivity.this, NavActivity.class);
            startActivity(intent);

        });
    }

    private void showInitialDateDialog(EditText initial_date) {
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = (view, year, month, dayOfMonth) -> {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            initial_date.setText(dayOfMonth + "/" + month + "/" + year);
        };
        new DatePickerDialog(NewGameActivity.this, dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void showInitialTimeDialog(EditText initial_time) {
        final Calendar calendar = Calendar.getInstance();
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);
                initial_time.setText(hourOfDay + ":" + minute);
            }
        };
        new TimePickerDialog(NewGameActivity.this, timeSetListener,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE), false).show();
    }

    private void showFinalDateDialog(EditText final_date) {
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                final_date.setText(dayOfMonth + "/" + month + "/" + year);
            }
        };
        new DatePickerDialog(NewGameActivity.this, dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void showFinalTimeDialog(EditText final_time) {
        final Calendar calendar = Calendar.getInstance();
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);
                final_time.setText(hourOfDay + ":" + minute);
            }
        };
        new TimePickerDialog(NewGameActivity.this, timeSetListener,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE), false).show();
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
                Toast.makeText(NewGameActivity.this, "LOGGING OUT", Toast.LENGTH_LONG).show();
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(NewGameActivity.this, LoginActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
