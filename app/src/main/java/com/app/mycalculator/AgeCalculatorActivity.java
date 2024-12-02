package com.app.mycalculator;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class AgeCalculatorActivity extends AppCompatActivity {

    private EditText birthDateEditText;
    private Button calculateAgeButton;
    private TextView ageResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculator);

        String title = getIntent().getStringExtra("title");
        setTitle(title);

        birthDateEditText = findViewById(R.id.birthDateEditText);
        calculateAgeButton = findViewById(R.id.calculateAgeButton);
        ageResultTextView = findViewById(R.id.ageResultTextView);

        calculateAgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAge();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void calculateAge() {
        String birthDateStr = birthDateEditText.getText().toString();
        try {
            LocalDate birthDate = LocalDate.parse(birthDateStr);
            LocalDate currentDate = LocalDate.now();
            if (birthDate.isAfter(currentDate)) {
                Toast.makeText(this, "Birth date cannot be in the future.", Toast.LENGTH_SHORT).show();
                return;
            }
            Period period = Period.between(birthDate, currentDate);
            String age = period.getYears() + " Years, " + period.getMonths() + " Months, " + period.getDays() + " Days";
            ageResultTextView.setText("Your Age: " + age);
        } catch (DateTimeParseException e) {
            Toast.makeText(this, "Invalid date format. Please use YYYY-MM-DD.", Toast.LENGTH_SHORT).show();
        }
    }
}
