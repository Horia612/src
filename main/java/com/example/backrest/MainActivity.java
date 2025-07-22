package com.example.backrest;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.graphics.Color;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private ConstraintLayout mainLayout;
    private Switch darkLightSwitch;
    private TextView welcomeMessage;

    //main activity
    @Override protected void onCreate(Bundle savedInstanceState) //bundle object parameter contains the saved state of the activity
    {
        super.onCreate(savedInstanceState); //call the superclass (AppCompatActivity) override method onCreate
        EdgeToEdge.enable(this); //feature that enables drawing behind the system bars
        setContentView(R.layout.activity_main); //set the xml layout file for the activity
        //listener for when window padding changes getting as arguments the view and the insets through a lambda expression
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars()); //get margins of system bars
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom); //set margins of view
            return insets; //return margins of view
        });

        mainLayout = findViewById(R.id.main);
        darkLightSwitch = findViewById(R.id.darklight);
        welcomeMessage = findViewById(R.id.welcome_message);

        darkLightSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //the method is called when the switch state changes

                if (isChecked)
                {
                    mainLayout.setBackgroundColor(Color.BLACK);
                    welcomeMessage.setTextColor(Color.WHITE);
                    darkLightSwitch.setText("Light");
                    darkLightSwitch.setTextColor(Color.WHITE);
                }
                else
                {
                    mainLayout.setBackgroundColor(Color.WHITE);
                    welcomeMessage.setTextColor(Color.DKGRAY);
                    darkLightSwitch.setText("Dark");
                    darkLightSwitch.setTextColor(Color.BLACK);
                }
            }
        });
    }
}