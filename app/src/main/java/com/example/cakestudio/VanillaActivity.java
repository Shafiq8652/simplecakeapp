package com.example.cakestudio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class VanillaActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView ClassicVanillaCard, EgglessVanillaCard, GoldenVanillaCard;

    Button Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vanilla);
        getSupportActionBar().setTitle("Vanilla cake");
        Logout=(Button)findViewById(R.id.Logout);

        ClassicVanillaCard=(CardView)findViewById(R.id.ClassicVanillaCard);
        EgglessVanillaCard=(CardView)findViewById(R.id.EgglessVanillaCard);
        GoldenVanillaCard=(CardView)findViewById(R.id.GoldenVanillaCard);

        ClassicVanillaCard.setOnClickListener(this);
        EgglessVanillaCard.setOnClickListener(this);
        GoldenVanillaCard.setOnClickListener(this);

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(VanillaActivity.this,MainActivity.class);
                Toast.makeText(getApplicationContext(), "You have Logged Out" , Toast.LENGTH_LONG).show();
                startActivity(intent);

            }
        });

    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.ClassicVanillaCard:i=new Intent(this,ClassicVanillaActivity.class);startActivity(i);break;
            case R.id.EgglessVanillaCard:i=new Intent(this,EgglessVanillaActivity.class);startActivity(i);break;
            case R.id.GoldenVanillaCard:i=new Intent(this,GoldenVanillaActivity.class);startActivity(i);break;
        }

    }
}
