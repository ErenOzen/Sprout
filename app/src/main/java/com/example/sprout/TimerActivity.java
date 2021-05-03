package com.example.sprout;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TimerActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;

    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.text_view_selected);
        Button buttonApply = findViewById(R.id.button_apply);
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                textView.setText("Your choice: " + radioButton.getText());
            }
        });

        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("Time: %s");
        //chronometer.setBase(SystemClock.elapsedRealtime());
        //chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            //@Override
            //public void onChronometerTick(Chronometer chronometer) {
                //if ((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 10000) {
                    //chronometer.setBase(SystemClock.elapsedRealtime());
                    //Toast.makeText(TimerActivity.this, "Bing!", Toast.LENGTH_SHORT).show();
                //}
            //}
        //});
    }
    public void startChronometer(View v) {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;
        }
    }
    public void pauseChronometer(View v) {
        if (running) {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }
    public void resetChronometer(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }

    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        //Toast.makeText(this,"Selected Radio Button: " + radioButton.getText(),Toast.LENGTH_LONG).show();

    }
}