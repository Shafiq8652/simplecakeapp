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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class signupActivity extends AppCompatActivity implements View.OnClickListener {

    ProgressBar progressBar;

    EditText edittextemail, edittextpassword, edittextname, edittextphone ;
    String number;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();




        edittextname=(EditText)findViewById(R.id.edittextname);
        edittextemail=(EditText)findViewById(R.id.edittextemail);
        edittextpassword=(EditText)findViewById(R.id.editTextpassword);
        edittextphone=(EditText)findViewById(R.id.edittextphone);

        progressBar=(ProgressBar)findViewById(R.id.progressbar);


        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.buttonsignup).setOnClickListener(this);
        findViewById(R.id.textviewlogin).setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() != null) {
        }
    }

    private void registerUser() {

        final String name =edittextname.getText().toString().trim();
        final String email = edittextemail.getText().toString().trim();
        String password = edittextpassword.getText().toString().trim();
        final String phone= edittextphone.getText().toString().trim();

        if (name.isEmpty()){
            edittextname.setError("Name is required");
            edittextname.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            edittextemail.setError("Email is required");
            edittextemail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edittextemail.setError("Please enter a valid email");
            edittextemail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            edittextpassword.setError("password is required");
            edittextpassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            edittextpassword.setError("minimum length of password be 6");
            edittextpassword.requestFocus();
            return;
        }

        if (phone.length()!=10){
            edittextphone.setError("enter a valid phone number");
            edittextphone.requestFocus();
            return;
        }


        progressBar.setVisibility(View.VISIBLE);



        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    User user = new User(
                            name,
                            email,
                            phone
                    );

                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {

                                Intent intent = new Intent(signupActivity.this, MainActivity.class);
                                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(),"successful registered",Toast.LENGTH_SHORT).show();
                            } else {
                                if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                    Toast.makeText(getApplicationContext(), "User Already registered", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
                }
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonsignup:
                registerUser();
                break;
            case R.id.textviewlogin:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
