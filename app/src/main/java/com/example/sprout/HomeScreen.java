package com.example.sprout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

/**
 * This class is the java file for HomeScreen Activity screen / exm file .
 * @author DilayYigit, Eren Ozen
 * @version 30 April 2021
 */
public class HomeScreen extends AppCompatActivity {

    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        logout = (Button) findViewById(R.id.logout_button);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(HomeScreen.this, LoginActivity.class));
            }
        });
    }
}