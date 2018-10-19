package com.example.yell;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;

public class MainPage extends AppCompatActivity {

    DayNightSwitch dayNightSwitch;
    View background_view;
    ImageButton backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        dayNightSwitch = findViewById(R.id.dayNight);
        background_view = findViewById(R.id.background_view);

        dayNightSwitch.setDuration(450);
        dayNightSwitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean isNight) {
               if(isNight){
                   Toast.makeText(MainPage.this, "Night mode selected", Toast.LENGTH_SHORT).show();
                   background_view.setAlpha(1f);

               }
               else{

                   Toast.makeText(MainPage.this, "Day mode selected", Toast.LENGTH_SHORT).show();
                   background_view.setAlpha(0f);
               }
                   
            }
        });

        backButton = findViewById(R.id.backButton);
        configureBackButton();

    }

    private void configureBackButton(){

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPage.this, Yell1.class));
            }
        });


    }
}
