package com.example.cakestudio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class DashboardActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView chocolate_card, vanilla_card, redvelvet_card, design_card, fruit_cake, photo_cake;
    Button Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().setTitle("Dashboard");
        Logout=(Button)findViewById(R.id.Logout);


        chocolate_card=(CardView)findViewById(R.id.chocolate_card);
        vanilla_card=(CardView)findViewById(R.id.vanilla_card);
        redvelvet_card=(CardView)findViewById(R.id.redvelvet_card);
        design_card=(CardView)findViewById(R.id.design_card);
        fruit_cake=(CardView)findViewById(R.id.fruit_cake);
        photo_cake=(CardView)findViewById(R.id.photo_cake);


        chocolate_card.setOnClickListener(this);
        vanilla_card.setOnClickListener(this);
        redvelvet_card.setOnClickListener(this);
        design_card.setOnClickListener(this);
        fruit_cake.setOnClickListener(this);
        photo_cake.setOnClickListener(this);

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(DashboardActivity.this,MainActivity.class);
                Toast.makeText(getApplicationContext(), "You have Logged Out" , Toast.LENGTH_LONG).show();
                startActivity(intent);

            }
        });

    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.chocolate_card:i=new Intent(this,ChocolateActivity.class);startActivity(i);break;
            case R.id.vanilla_card:i=new Intent(this,VanillaActivity.class);startActivity(i); break;
            case R.id.redvelvet_card:i=new Intent(this, RedVelvetActivity.class);startActivity(i); break;
            case R.id.design_card:i=new Intent(this,designActivity.class);startActivity(i); break;
            case R.id.fruit_cake:i=new Intent(this,FruitActivity.class);startActivity(i); break;
            case R.id.photo_cake:i=new Intent(this,PhotoActivity.class);startActivity(i); break;
        }

    }


}
