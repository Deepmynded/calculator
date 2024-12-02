package com.app.mycalculator;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMICalculatorActivity extends AppCompatActivity {

    private EditText weightEditText, heightEditText;
    private Button calculateBMIButton;
    private TextView bmiResultTextView, bmiCategoryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        String title = getIntent().getStringExtra("title");
        setTitle(title);

        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);
        calculateBMIButton = findViewById(R.id.calculateBMIButton);
        bmiResultTextView = findViewById(R.id.bmiResultTextView);
        bmiCategoryTextView = findViewById(R.id.bmiCategoryTextView);

        calculateBMIButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightEditText.getText().toString());
            double heightCm = Double.parseDouble(heightEditText.getText().toString());

            if (heightCm == 0) {
                Toast.makeText(this, "Height cannot be zero.", Toast.LENGTH_SHORT).show();
                return;
            }

            double heightM = heightCm / 100;
            double bmi = weight / (heightM * heightM);
            bmiResultTextView.setText(String.format("Your BMI: %.2f", bmi));

            String category;
            if (bmi < 18.5) {
                category = "Underweight";
            } else if (bmi < 24.9) {
                category = "Normal weight";
            } else if (bmi < 29.9) {
                category = "Overweight";
            } else {
                category = "Obesity";
            }

            bmiCategoryTextView.setText("Category: " + category);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers.", Toast.LENGTH_SHORT).show();
        }
    }
}
