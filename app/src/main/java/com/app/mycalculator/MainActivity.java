package com.app.mycalculator;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    List<CalculatorCard> cardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        cardList = new ArrayList<>();

        // Initialize card list
        cardList.add(new CalculatorCard("Calculator", R.drawable.baseline_calculate_24));
        cardList.add(new CalculatorCard("Age Calculator", R.drawable.baseline_person_pin_24));
        cardList.add(new CalculatorCard("Gravity Calculator", R.drawable.baseline_run_circle_24));
        cardList.add(new CalculatorCard("BMI Calculator", R.drawable.baseline_monitor_weight_24));

        CalculatorCardAdapter adapter = new CalculatorCardAdapter(this, cardList);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CalculatorCard selectedCard = cardList.get(position);
                Intent intent;
                switch (selectedCard.getTitle()) {
                    case "Calculator":
                        intent = new Intent(MainActivity.this, CalculatorActivity.class);
                        break;
                    case "Age Calculator":
                        intent = new Intent(MainActivity.this, AgeCalculatorActivity.class);
                        break;
                    case "Gravity Calculator":
                        intent = new Intent(MainActivity.this, GravityCalculatorActivity.class);
                        break;
                    case "BMI Calculator":
                        intent = new Intent(MainActivity.this, BMICalculatorActivity.class);
                        break;
                    default:
                        intent = null;
                }
                if (intent != null) {
                    intent.putExtra("title", selectedCard.getTitle());
                    startActivity(intent);
                }
            }
        });
    }
}
