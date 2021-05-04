package com.example.sprout;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TimerActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private TextView textView;
    private EditText editText;
    private String activityName;
    private long activityTime;
    private int seconds;
    private String chrobase;

    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        editText = (EditText) findViewById(R.id.timerEditText);
        radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.text_view_selected);

        Button buttonApply = findViewById(R.id.button_apply);
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                seconds = (int) (chronometer.getBase())/ 1000;

                activityName = editText.getText().toString();
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                textView.setText("Category: " + radioButton.getText() + "\nName: " + activityName + "\nTime: " + (activityTime) );
                //textView.setText(activityName);
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
            activityTime = ((SystemClock.elapsedRealtime() - chronometer.getBase()) / 1000);
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
        //Toast.makeText(TimerActivity.this, activityName, Toast.LENGTH_SHORT).show();
    }
}