package com.example.sprout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        View rootView;
        rootView = LayoutInflater.from(this).inflate(R.layout.activity_login, null);

        Button loginBtn = (Button) findViewById(R.id.loginBtn);
        Button login_signupBtn = (Button) findViewById(R.id.login_signupBtn);

        TextView login_text = (TextView) findViewById(R.id.login_text);
        TextView login_screen_greet = (TextView) findViewById(R.id.login_screen_greet);
        EditText login_email = (EditText) findViewById(R.id.login_email);
        EditText login_password = (EditText) findViewById(R.id.login_password);
        ImageView login_sprout_view = (ImageView) findViewById(R.id.login_sprout_view);
        TextView login_sprout_text = (TextView) findViewById(R.id.singup_sprout_text);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(login_email.length() == 0){
                    login_email.setError("Email is required!");
                    login_email.requestFocus();
                    return;
                }
                if(login_password.length() == 0 ){
                    login_password.setError("Password is required!");
                    login_password.requestFocus();
                    return;
                }
                /*
                userAuthenticationDb.authUser(email, password, new UserAuthenticationCallBack() {
                    @Override
                    public void onCallBack(boolean isAuth, String message) {
                        if(isAuth){
                            Intent intent = new Intent(rootView.getContext(), HomeScreen.class);
                            rootView.getContext().startActivity(intent);
                        } else {
                            Toast.makeText(getBaseContext(),"Giris yapilamadi ", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                */
            }
        });

        login_signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(rootView.getContext(), SignupActivity.class);
                rootView.getContext().startActivity(intent);
            }
        });
    }
}