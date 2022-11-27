package com.example.interaction;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
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


        initial_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInitialDateDialog(initial_date);
            }
        });

        initial_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInitialTimeDialog(initial_time);
            }
        });

        final_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFinalDateDialog(final_date);
            }
        });

        final_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFinalTimeDialog(final_time);
            }
        });

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewGameActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

//        submit_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(NewGameActivity.this, MenuActivity.class);
//                startActivity(intent);
//
//            }
//        });
    }

    private void showInitialDateDialog(EditText initial_date) {
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
                initial_date.setText(simpleDateFormat.format(calendar));
            }
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
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                initial_time.setText(simpleDateFormat.format(calendar));
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
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
                final_date.setText(simpleDateFormat.format(calendar));
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
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                final_time.setText(simpleDateFormat.format(calendar));
            }
        };
        new TimePickerDialog(NewGameActivity.this, timeSetListener,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE), false).show();
    }
}
