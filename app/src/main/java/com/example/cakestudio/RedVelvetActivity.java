package com.example.cakestudio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RedVelvetActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView BasicRedVelvetCard, RedVelvetSpecialCard, RedVelvetCheeseCard, RedVelvetCupcakeCard;

    Button Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redvelvet);
        getSupportActionBar().setTitle("Red Velvet cake");
        Logout=(Button)findViewById(R.id.Logout);

        BasicRedVelvetCard=(CardView)findViewById(R.id.BasicRedVelvetCard);
        RedVelvetSpecialCard=(CardView)findViewById(R.id.RedVelvetSpecialCard);
        RedVelvetCheeseCard=(CardView)findViewById(R.id.RedVelvetCheeseCard);
        RedVelvetCupcakeCard=(CardView)findViewById(R.id.RedVelvetCupcakeCard);

        BasicRedVelvetCard.setOnClickListener(this);
        RedVelvetSpecialCard.setOnClickListener(this);
        RedVelvetCheeseCard.setOnClickListener(this);
        RedVelvetCupcakeCard.setOnClickListener(this);


        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(RedVelvetActivity.this,MainActivity.class);
                Toast.makeText(getApplicationContext(), "You have Logged Out" , Toast.LENGTH_LONG).show();
                startActivity(intent);

            }
        });

    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.BasicRedVelvetCard:i=new Intent(this,BasicRedVelvettActivity.class);startActivity(i);break;
            case R.id.RedVelvetSpecialCard:i=new Intent(this,RedVellvetSpecialActivity.class);startActivity(i);break;
            case R.id.RedVelvetCheeseCard:i=new Intent(this,RedVelvetCheeseActivity.class);startActivity(i);break;
            case R.id.RedVelvetCupcakeCard:i=new Intent(this,RedVelvetCupcakeActivity.class);startActivity(i);break;
        }
    }
}
