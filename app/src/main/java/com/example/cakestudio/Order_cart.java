package com.example.cakestudio;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Order_cart extends AppCompatActivity {

    Bundle Bundle;
    TextView textView1,textView2,textView3,textView4;
    String list;
    Button Logout,menu1,cancelorder;



    ListView allusers;
    ProgressDialog mProgressDialog;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    ListingAdapter adapter;
    ArrayList<User> users = new ArrayList<>();
    String st;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_cart);
        getSupportActionBar().setTitle("Order cart");
        Logout=(Button)findViewById(R.id.Logout);
        menu1=(Button)findViewById(R.id.menu1);
        cancelorder=(Button)findViewById(R.id.cancelorder);






        allusers = (ListView) findViewById(R.id.allusers);

        adapter = new ListingAdapter(Order_cart.this, users);
        allusers.setAdapter(adapter);
        getDataFromServer();

        Intent launch=getIntent();
        list =launch.getStringExtra("SelectedItem");
        textView1=(TextView)findViewById(R.id.textView1);
        textView2=(TextView)findViewById(R.id.textView2);
        textView3=(TextView)findViewById(R.id.textView3);



        textView1.setText(list);
        textView2.setText(getIntent().getStringExtra("name"));
        textView3.setText(getIntent().getStringExtra("address"));


        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Order_cart.this,MainActivity.class);
                Toast.makeText(getApplicationContext(), "You have Logged Out" , Toast.LENGTH_LONG).show();
                startActivity(intent);

            }
        });

        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Order_cart.this,DashboardActivity.class);
                Toast.makeText(getApplicationContext(), "Dashboard", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        cancelorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Order_cart.this,DashboardActivity.class);
                Toast.makeText(getApplicationContext(), "your order has been cancel", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });







    }

    public void getDataFromServer() {
        showProgressDialog();
        databaseReference.child("UserNode").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                        User user = postSnapShot.getValue(User.class);
                        users.add(user);
                        adapter.notifyDataSetChanged();
                    }
                }
                hideProgressDialog();
            }

            private void hideProgressDialog() {
                if (mProgressDialog != null && mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                hideProgressDialog();


            }


        });
    }

    private void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(Order_cart.this);
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(true);
        }
        mProgressDialog.show();

    }


    private class ListingAdapter extends BaseAdapter {
        Context context;
        LayoutInflater layoutInflater;
        ArrayList<User> users;

        public ListingAdapter(Context con, ArrayList<User> users) {
            context = con;
            layoutInflater = LayoutInflater.from(context);
            this.users = users;
        }

        @Override
        public int getCount() {
            return users.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.adapter_listing, null, false);
                holder = new ViewHolder();
                holder.name = (TextView) convertView.findViewById(R.id.name);
                holder.email = (TextView) convertView.findViewById(R.id.email);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            User user = users.get(position);
            holder.name.setText(user.getname());
            holder.email.setText(user.getemail());
            return convertView;
        }

        public class ViewHolder {
            TextView name, email;
        }

        @Override
        public Object getItem(int position) {

            return users.get(position);
        }

        @Override
        public long getItemId(int position) {

            return position;
        }
    }



}