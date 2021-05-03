package com.example.sprout;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;

public class TimerActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
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
}