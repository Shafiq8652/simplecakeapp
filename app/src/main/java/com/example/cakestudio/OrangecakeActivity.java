package com.example.cakestudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OrangecakeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    EditText MessageCake,AddressCake;
    TextView textViewPrice;
    Button submit;
    String selectedItem="";
    String message;
    String Address;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orangecake);
        getSupportActionBar().setTitle("Orange cake");

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final EditText MessageCake=(EditText) findViewById(R.id.MessageCake);
        final EditText AddressCake=(EditText)findViewById(R.id.AddressCake);

        TextView textViewPrice=(TextView)findViewById(R.id.textViewPrice);

        Button Submit=(Button)findViewById(R.id.Submit);

        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);


        List<String> Weight = new ArrayList<String>();
        Weight.add("1kg ₹400 of Orange Cake");
        Weight.add("1.5kg ₹550 of Orange Cake");
        Weight.add("2kg ₹700 of Orange Cake");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Weight);


        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                selectedItem = spinner.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), "Selected:weight ", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        spinner.setAdapter(dataAdapter);


        Submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Intent code for open new activity through intent.

                String message=MessageCake.getText().toString();
                String Address=AddressCake.getText().toString();


                Intent intent = new Intent(getApplicationContext(), Order_cart.class);
                intent.putExtra("SelectedItem",selectedItem);
                intent.putExtra("address",Address);
                intent.putExtra("name",message);


                Toast.makeText(getApplicationContext(), "your order is placed" , Toast.LENGTH_LONG).show();
                startActivity(intent);

            }
        });







    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {



        Toast.makeText(getApplicationContext(), "Selected:weight " , Toast.LENGTH_SHORT).show();







    }



    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }




}
