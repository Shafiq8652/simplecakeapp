package com.example.cakestudio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ChocolateActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView ChocolateCoconutCard, ChocolateRaspberryCard, ChocolateCheeseCard, ChocolateDevilCard, BlackForestCard;

    Button Logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chocolate);
        getSupportActionBar().setTitle("chocolate cake");

        Logout=(Button)findViewById(R.id.Logout);

        ChocolateCoconutCard=(CardView)findViewById(R.id.ChocolateCoconutCard);
        ChocolateRaspberryCard=(CardView)findViewById(R.id.ChocolateRaspberryCard);
        ChocolateCheeseCard=(CardView)findViewById(R.id.ChocolateCheeseCard);
        ChocolateDevilCard=(CardView)findViewById(R.id.ChocolateDevilCard);
        BlackForestCard=(CardView)findViewById(R.id.BlackForestCard);

        ChocolateCoconutCard.setOnClickListener(this);
        ChocolateRaspberryCard.setOnClickListener(this);
        ChocolateCheeseCard.setOnClickListener(this);
        ChocolateDevilCard.setOnClickListener(this);
        BlackForestCard.setOnClickListener(this);


        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(ChocolateActivity.this,MainActivity.class);
                Toast.makeText(getApplicationContext(), "You have Logged Out" , Toast.LENGTH_LONG).show();
                startActivity(intent);

            }
        });




    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.ChocolateCoconutCard:i=new Intent(this,ChocolateCoconutActivity.class);startActivity(i);break;
            case R.id.ChocolateRaspberryCard:i=new Intent(this,ChocolateRaspberryActivity.class);startActivity(i);break;
            case R.id.ChocolateCheeseCard:i=new Intent(this,ChocolateCheeseActivity.class);startActivity(i);break;
            case R.id.ChocolateDevilCard:i=new Intent(this,ChocolateDevilActivity.class);startActivity(i);break;
            case R.id.BlackForestCard:i=new Intent(this,BlackForestActivity.class);startActivity(i);break;

        }

        }

    }

