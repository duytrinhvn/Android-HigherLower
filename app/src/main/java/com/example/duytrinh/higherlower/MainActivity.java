// Author: Khac Duy Trinh

package com.example.duytrinh.higherlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNum;	// Generates a random number, user needs to guess this number
    EditText guessEditText;
    Random r;
    int guessNum;	// Stores the number that user guesses

    public void guessOnClick(View v) {
        try {
            guessNum = Integer.parseInt(guessEditText.getText().toString());
			
			// When user's input is correct
            if (guessNum == randomNum) {
                Toast.makeText(this, "You are right! Try again.", Toast.LENGTH_LONG).show();
                randomNum = (r.nextInt(20) + 1);
            } else {
				// When user's input is less than the random number
                if (guessNum < randomNum) {
                    Toast.makeText(this, "It's Higher!", Toast.LENGTH_LONG).show();
				// When user's input is higher than the random number
                } else if (guessNum > randomNum) {
                    Toast.makeText(this, "It's Lower!", Toast.LENGTH_LONG).show();
                }
            }
        } catch (NumberFormatException e){
            Toast.makeText(this, "Invalid input", Toast.LENGTH_LONG).show();
        }
    }

        {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();
        randomNum = (r.nextInt(20) + 1);
        guessEditText = findViewById(R.id.guessEditText);
    }
}
