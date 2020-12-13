package com.example.cakestudio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class designActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView DesignBrandedCard, DesignMakeupCard, DesignSleepCard, DesignComputerCard, DesignIphoneCard, DesignSocialCard;

    Button Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);
        getSupportActionBar().setTitle("Designer cake");
        Logout=(Button)findViewById(R.id.Logout);

        DesignBrandedCard=(CardView)findViewById(R.id.DesignBrandedCard);
        DesignMakeupCard=(CardView)findViewById(R.id.DesignMakeupCard);
        DesignSleepCard=(CardView)findViewById(R.id.DesignSleepCard);
        DesignComputerCard=(CardView)findViewById(R.id.DesignComputerCard);
        DesignIphoneCard=(CardView)findViewById(R.id.DesignIphoneCard);
        DesignSocialCard=(CardView)findViewById(R.id.DesignSocialCard);

        DesignBrandedCard.setOnClickListener(this);
        DesignMakeupCard.setOnClickListener(this);
        DesignSleepCard.setOnClickListener(this);
        DesignComputerCard.setOnClickListener(this);
        DesignIphoneCard.setOnClickListener(this);
        DesignSocialCard.setOnClickListener(this);


        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(designActivity.this,MainActivity.class);
                Toast.makeText(getApplicationContext(), "You have Logged Out" , Toast.LENGTH_LONG).show();
                startActivity(intent);

            }
        });

    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.DesignBrandedCard:i=new Intent(this,DesignBrandedActivity.class);startActivity(i);break;
            case R.id.DesignMakeupCard:i=new Intent(this,DesignMakeupActivity.class);startActivity(i);break;
            case R.id.DesignSleepCard:i=new Intent(this,DesignSleepActivity.class);startActivity(i);break;
            case R.id.DesignComputerCard:i=new Intent(this,DesignComputerActivity.class);startActivity(i);break;
            case R.id.DesignIphoneCard:i=new Intent(this,DesignIphoneActivity.class);startActivity(i);break;
            case R.id.DesignSocialCard:i=new Intent(this,DesignSocialActivity.class);startActivity(i);break;

        }


    }
}
