package com.example.cakestudio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FruitActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView MangoCakeCard, OrangeCakeCard, PineappleCakeCard, BlueberryCakeCard, MixFruitCakeCard;

    Button Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        getSupportActionBar().setTitle("Fruit cake");
        Logout=(Button)findViewById(R.id.Logout);

        MangoCakeCard=(CardView)findViewById(R.id.MangoCakeCard);
        OrangeCakeCard=(CardView)findViewById(R.id.OrangeCakeCard);
        PineappleCakeCard=(CardView)findViewById(R.id.PineappleCakeCard);
        BlueberryCakeCard=(CardView)findViewById(R.id.BlueberryCakeCard);
        MixFruitCakeCard=(CardView)findViewById(R.id.MixFruitCakeCard);

        MangoCakeCard.setOnClickListener(this);
        OrangeCakeCard.setOnClickListener(this);
        PineappleCakeCard.setOnClickListener(this);
        BlueberryCakeCard.setOnClickListener(this);
        MixFruitCakeCard.setOnClickListener(this);




        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(FruitActivity.this,MainActivity.class);
                Toast.makeText(getApplicationContext(), "You have Logged Out" , Toast.LENGTH_LONG).show();
                startActivity(intent);

            }
        });


    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.MangoCakeCard:i=new Intent(this,MangocakeActivity.class);startActivity(i);break;
            case R.id.OrangeCakeCard:i=new Intent(this,OrangecakeActivity.class);startActivity(i);break;
            case R.id.PineappleCakeCard:i=new Intent(this,PineapplecakeActivity.class);startActivity(i);break;
            case R.id.BlueberryCakeCard:i=new Intent(this,BlueberrycakeActivity.class);startActivity(i);break;
            case R.id.MixFruitCakeCard:i=new Intent(this,MixfruitcakeActivity.class);startActivity(i);break;
        }

    }
}
