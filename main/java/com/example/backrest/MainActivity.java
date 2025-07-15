package com.example.backrest;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
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
    }
}