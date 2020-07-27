package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button buttonrock,buttonpaper,buttonscissors;
    TextView text1,text2,text3,text4;
    ImageView image1;
    EditText editText;
    int UserScore, ComputerScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonrock = (Button) findViewById(R.id.buttonrock);
        buttonpaper = (Button) findViewById(R.id.buttonpaper);
        buttonscissors = (Button) findViewById(R.id.buttonscissors);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        image1 = (ImageView) findViewById(R.id.image1);
        editText = (EditText) findViewById(R.id.editText);

        buttonrock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = computer_random("rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                text3.setText("Score: User " + Integer.toString(UserScore) + " Computer " + Integer.toString(ComputerScore));

            }
        });
        buttonpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = computer_random("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                text3.setText("Score: User " + Integer.toString(UserScore) + " Computer " + Integer.toString(ComputerScore));

            }
        });
        buttonscissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = computer_random("scissors");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                text3.setText("Score: User " + Integer.toString(UserScore) + " Computer " + Integer.toString(ComputerScore));

            }
        });

    }

    public String computer_random(String user_input) {
        String computer_input="";
        Random r = new Random();
        int computer_input_number = r.nextInt(3) + 1;

        if (computer_input_number == 1) {
            computer_input = "rock";
        }
        if (computer_input_number == 2) {
            computer_input = "paper";
        }
        if (computer_input_number == 3) {
            computer_input = "scissors";
        }

        if (computer_input == user_input) {
            return "Friends! Nobody wins.";
        }
        else if (user_input == "rock" && computer_input == "scissors") {
            UserScore++;
            return "Rock beats Scissors! You win.";
        }
        else if (user_input == "rock" && computer_input == "paper") {
            ComputerScore++;
            return "Paper beats Rock! You loose.";
        }
        else if (user_input == "scissors" && computer_input == "rock") {
            ComputerScore++;
            return "Rock beats Scissors! You loose.";
        }
        else if (user_input == "scissors" && computer_input == "paper") {
            UserScore++;
            return "Scissors beat Paper! You win.";
        }
        else if (user_input == "paper" && computer_input == "rock") {
            UserScore++;
            return "Paper beats Rock! You win.";
        }
        else if (user_input == "paper" && computer_input == "scissors") {
            UserScore++;
            return "Scissors beat Paper! You win.";
        }else return "Invalid";
    }
}