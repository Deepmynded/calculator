package com.app.mycalculator;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class CalculatorActivity extends AppCompatActivity {

    private EditText display;
    private String expression = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        String title = getIntent().getStringExtra("title");
        setTitle(title);

        display = findViewById(R.id.display);

        // Initialize buttons
        int[] buttonIds = {
                R.id.btn_zero, R.id.btn_one, R.id.btn_two, R.id.btn_three,
                R.id.btn_four, R.id.btn_five, R.id.btn_six, R.id.btn_seven,
                R.id.btn_eight, R.id.btn_nine, R.id.btn_add, R.id.btn_subtract,
                R.id.btn_multiply, R.id.btn_divide, R.id.btn_dot, R.id.btn_percent,
                R.id.btn_clear, R.id.btn_del, R.id.btn_equals
        };

        for (int id : buttonIds) {
            Button btn = findViewById(id);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onButtonClick(v);
                }
            });
        }
    }

    private void onButtonClick(View view) {
        Button btn = (Button) view;
        String btnText = btn.getText().toString();

        switch (btnText) {
            case "C":
                expression = "";
                display.setText(expression);
                break;
            case "DEL":
                if (expression.length() > 0) {
                    expression = expression.substring(0, expression.length() - 1);
                    display.setText(expression);
                }
                break;
            case "=":
                try {
                    Expression exp = new ExpressionBuilder(expression)
                            .build();
                    double result = exp.evaluate();
                    display.setText(String.valueOf(result));
                    expression = String.valueOf(result);
                } catch (Exception e) {
                    display.setText("Error");
                    expression = "";
                }
                break;
            default:
                expression += btnText;
                display.setText(expression);
                break;
        }
    }
}
