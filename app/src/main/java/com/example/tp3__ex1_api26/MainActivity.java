package com.example.tp3__ex1_api26;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex1);

        changeTitle();

        Button changeBackgroundButton = findViewById(R.id.button1);
        Button defaultBackgroundButton = findViewById(R.id.button2);

        radioGroup = findViewById(R.id.radioGroup1);

        changeBackgroundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    String selectedColor = selectedRadioButton.getText().toString().toLowerCase();


                    int backgroundColor = getColorFromName(selectedColor);
                    findViewById(android.R.id.content).setBackgroundColor(backgroundColor);
                } else {

                    Toast.makeText(MainActivity.this, "Veuillez choisir une couleur", Toast.LENGTH_SHORT).show();
                }
            }
        });

        defaultBackgroundButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Set the background color to gray
                findViewById(android.R.id.content).setBackgroundColor(Color.GRAY);

                // Uncheck the selected RadioButton
                radioGroup.clearCheck();

                return true;
            }
        });
    }

    private int getColorFromName(String colorName) {
        switch (colorName) {
            case "yellow":
                return Color.YELLOW;
            case "green":
                return Color.GREEN;
            case "red":
                return Color.RED;
            default:
                return Color.WHITE;
        }
    }

    public void changeTitle() {
        setTitle("Welcome to TP_3");
    }



}