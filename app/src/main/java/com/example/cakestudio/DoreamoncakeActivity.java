package com.example.cakestudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class DoreamoncakeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    EditText MessageCake;
    EditText AddressCake;
    TextView textViewPrice;
    List<String>list;
    Button submit;
    String selectedItem="";
    String message;
    String Address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doreamoncake);
        getSupportActionBar().setTitle("Doreamon cake");

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final EditText MessageCake=(EditText) findViewById(R.id.MessageCake);
        final EditText AddressCake=(EditText)findViewById(R.id.AddressCake);

        final TextView textViewPrice=(TextView)findViewById(R.id.textViewPrice);

        final Button Submit=(Button)findViewById(R.id.Submit);
        list=new ArrayList<String>();
        list.add("1kg ₹450 of Doreamon cake ");
        list.add("1kg ₹550 of Doreamon cake");
        list.add("1kg ₹650 of Doreamon cake");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
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

                String message=MessageCake.getText().toString();
                String Address=AddressCake.getText().toString();


                // Intent code for open new activity through intent.

                Intent intent = new Intent(getApplicationContext(), Order_cart.class);
                intent.putExtra("SelectedItem",selectedItem);
                intent.putExtra("name",message);
                intent.putExtra("address",Address);

                Toast.makeText(getApplicationContext(), "your order is placed" , Toast.LENGTH_LONG).show();
                startActivity(intent);

                           }
        });





    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
