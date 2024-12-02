package com.app.mycalculator;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GravityCalculatorActivity extends AppCompatActivity {

    private EditText mass1EditText, mass2EditText, distanceEditText;
    private Button calculateGravityButton;
    private TextView gravityResultTextView;

    private static final double G = 6.67430e-11; // Gravitational constant

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity_calculator);

        String title = getIntent().getStringExtra("title");
        setTitle(title);

        mass1EditText = findViewById(R.id.mass1EditText);
        mass2EditText = findViewById(R.id.mass2EditText);
        distanceEditText = findViewById(R.id.distanceEditText);
        calculateGravityButton = findViewById(R.id.calculateGravityButton);
        gravityResultTextView = findViewById(R.id.gravityResultTextView);

        calculateGravityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateGravity();
            }
        });
    }

    private void calculateGravity() {
        try {
            double mass1 = Double.parseDouble(mass1EditText.getText().toString());
            double mass2 = Double.parseDouble(mass2EditText.getText().toString());
            double distance = Double.parseDouble(distanceEditText.getText().toString());

            if (distance == 0) {
                Toast.makeText(this, "Distance cannot be zero.", Toast.LENGTH_SHORT).show();
                return;
            }

            double force = G * (mass1 * mass2) / (distance * distance);
            gravityResultTextView.setText(String.format("Gravity Force: %.5e N", force));

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers.", Toast.LENGTH_SHORT).show();
        }
    }
}
