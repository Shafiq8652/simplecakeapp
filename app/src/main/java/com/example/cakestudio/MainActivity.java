package com.example.cakestudio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth mAuth;

    EditText edittextemail, edittextpassword;
    ProgressBar progressBar;
    String Email1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();




        mAuth =FirebaseAuth.getInstance();

        edittextemail=(EditText)findViewById(R.id.edittextemail);
        edittextpassword=(EditText)findViewById(R.id.editTextpassword);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);



        findViewById(R.id.textviewsignup).setOnClickListener(this);
        findViewById(R.id.buttonlogin).setOnClickListener(this);

    }
    private void userLogin(){
        String email=edittextemail.getText().toString().trim();
        String password=edittextpassword.getText().toString().trim();

        if (email.isEmpty()){
            edittextemail.setError("Email is required");
            edittextemail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edittextemail.setError("Please enter a valid email");
            edittextemail.requestFocus();
            return;
        }

        if (password.isEmpty()){
            edittextpassword.setError("password is required");
            edittextpassword.requestFocus();
            return;
        }
        if (password.length()<6){
            edittextpassword.setError("minimum length of password be 6");
            edittextpassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);



        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()){


                    Intent intent=new Intent(MainActivity.this, DashboardActivity.class);
                    intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(),"this email is not registered",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textviewsignup:
            startActivity(new Intent(this, signupActivity.class));
            break;

            case R.id.buttonlogin:
                userLogin();
                break;
        }
    }
}
