package com.example.cakestudio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PhotoActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView CartoonCakeCard, CoupleCakeCard, AvengersCakeCard, DoreamonCakeCard;

    Button Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        getSupportActionBar().setTitle("Photo cake");

        Logout=(Button)findViewById(R.id.Logout);

        CartoonCakeCard=(CardView)findViewById(R.id.CartoonCakeCard);
        CoupleCakeCard=(CardView)findViewById(R.id.CoupleCakeCard);
        AvengersCakeCard=(CardView)findViewById(R.id.AvengersCakeCard);
        DoreamonCakeCard=(CardView)findViewById(R.id.DoraemonCakeCard);


        CartoonCakeCard.setOnClickListener(this);
        CoupleCakeCard.setOnClickListener(this);
        AvengersCakeCard.setOnClickListener(this);
        DoreamonCakeCard.setOnClickListener(this);


        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(PhotoActivity.this,MainActivity.class);
                Toast.makeText(getApplicationContext(), "You have Logged Out" , Toast.LENGTH_LONG).show();
                startActivity(intent);

            }
        });


    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.CartoonCakeCard:i=new Intent(this,CartooncakeActivity.class);startActivity(i);break;
            case R.id.CoupleCakeCard:i=new Intent(this,CouplecakeActivity.class);startActivity(i);break;
            case R.id.AvengersCakeCard:i=new Intent(this,AvengerscakeActivity.class);startActivity(i);break;
            case R.id.DoraemonCakeCard:i=new Intent(this,DoreamoncakeActivity.class);startActivity(i);break;

        }

    }

}