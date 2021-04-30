package com.example.sprout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sprout.user.User;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        View rootView;
        rootView = LayoutInflater.from(this).inflate(R.layout.activity_signup, null);

        Button signupBtn = (Button) findViewById(R.id.signupBtn);
        TextView singup_text = (TextView) findViewById(R.id.singup_text);
        TextView signup_email_text = (TextView) findViewById(R.id.signup_email_text);
        EditText signup_hint_email = (EditText) findViewById(R.id.signup_hint_email);
        TextView signup_password_text = (TextView) findViewById(R.id.signup_password_text);
        EditText signup_hint_password = (EditText) findViewById(R.id.signup_hint_password);
        CheckBox signup_checkBox = (CheckBox) findViewById(R.id.signup_checkBox);
        ImageView signup_sprout_view = (ImageView) findViewById(R.id.signup_sprout_view);
        TextView singup_sprout_text = (TextView) findViewById(R.id.singup_sprout_text);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(signup_hint_email.length() == 0) {
                    signup_hint_email.setError("ERROR");
                    signup_hint_email.requestFocus();
                    return;
                }
                if (signup_hint_password.length() == 0) {
                    signup_hint_password.setError("ERROR");
                    signup_hint_password.requestFocus();
                    return;
                }
                if (signup_hint_password.length() < 6) {
                    signup_hint_password.setError("ERROR");
                    signup_hint_password.requestFocus();
                    return;
                }
                if (signup_checkBox.isChecked() == false) {
                    signup_hint_password.setError("ERROR");
                    signup_hint_password.requestFocus();
                    return;
                }
                User user = new User(signup_hint_email.toString(), signup_hint_password.toString());
                signupBtn.setEnabled(false);

                /*Database olustuktan sonra editlenecek.
                 @userCreatorDb - class
                 @UserCreatorCallBack - interface
                userCreatorDb.createUser(user, signup_hint_password, new UserCreatorCallBack() {
                    @Override
                    public void onCallBack(boolean isCreated) {
                        if(isCreated){
                            Toast.makeText(getBaseContext(), "success", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(rootView.getContext(), HomeScreen.class);
                            rootView.getContext().startActivity(intent);
                        } else {
                            Toast.makeText(getBaseContext(), "error", Toast.LENGTH_LONG).show();
                            signupBtn.setEnabled(true);
                        }
                    }
                });
                */
            }
        });
    }
}