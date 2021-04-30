package com.example.sprout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sprout.user.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

/**
 * This class is the java file for SignUp Activity screen / exm file .
 * @author DilayYigit, ErenOzen
 * @version 30 April 2021
 */
public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView sprout;
    private TextView signUp;
    private EditText email;
    private EditText password;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        sprout = (TextView) findViewById(R.id.signup_activity_textview_sprout);
        sprout.setOnClickListener(this);

        signUp = (Button) findViewById(R.id.signup_activity_signupBtn);
        signUp.setOnClickListener(this);

        email = (EditText) findViewById(R.id.signup_activity_hint_email);
        password = (EditText) findViewById(R.id.signup_activity_hint_password);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signup_activity_textview_sprout:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.signup_activity_signupBtn:
                registerUser();
                break;
        }
    }

    private void registerUser() {

        String emailString =  email.getText().toString().trim();
        String passwordString =  password.getText().toString().trim();

        if(emailString.isEmpty()) {
            email.setError("Email is required!");
            email.requestFocus();
            return;
        }

        if(passwordString.isEmpty()) {
            password.setError("Password is required!");
            password.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(emailString).matches()){
            email.setError("Please provide valid email!");
            email.requestFocus();
            return;
        }

        if (passwordString.length() < 6) {
            password.setError("Min password length should be 6 characters!");
            password.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(emailString,passwordString)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            User user = new User(emailString,passwordString);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if(task.isSuccessful()){
                                        Toast.makeText(SignupActivity.this, "User has been registered successfully!",
                                                Toast.LENGTH_LONG).show();
                                    } else {
                                        Toast.makeText(SignupActivity.this,"Failed to register! Try Again!",
                                                Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(SignupActivity.this,"Failed to register! Try Again!",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }
}