package com.example.sprout;

import android.graphics.Color;
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

import com.example.sprout.model.Event;

import org.eazegraph.lib.models.PieModel;

public class TimerActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private TextView textView;
    private EditText editText;
    private String activityName;
    private String activityCategory;
    private long activityTime;
    private int seconds;


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
                activityCategory = radioButton.getText().toString();
                textView.setText("Category: " + activityCategory + "\nName: " + activityName + "\nTime: " + (activityTime) );
                //textView.setText(activityName);
                Event newEvent = new Event(activityName,activityCategory,activityTime);
                HomeScreen.activeUser.getTimeline().addEvent(newEvent);

                setData();
                HomeScreen.pieChart.clearChart();
                HomeScreen.pieChart.addPieSlice(
                        new PieModel(
                                "Entertainment",
                                Integer.parseInt(HomeScreen.tvEntertainment.getText().toString()),
                                Color.parseColor("#5E35B1")));
                HomeScreen.pieChart.addPieSlice(
                        new PieModel(
                                "Study",
                                Integer.parseInt(HomeScreen.tvStudy.getText().toString()),
                                Color.parseColor("#1E88E5")));
                HomeScreen.pieChart.addPieSlice(
                        new PieModel(
                                "Sport",
                                Integer.parseInt(HomeScreen.tvSport.getText().toString()),
                                Color.parseColor("#005E04")));
                HomeScreen.pieChart.addPieSlice(
                        new PieModel(
                                "Socializing",
                                Integer.parseInt(HomeScreen.tvSocializing.getText().toString()),
                                Color.parseColor("#8E24AA")));
                HomeScreen.pieChart.addPieSlice(
                        new PieModel(
                                "Work",
                                Integer.parseInt(HomeScreen.tvWork.getText().toString()),
                                Color.parseColor("#E53935")));
                HomeScreen.pieChart.addPieSlice(
                        new PieModel(
                                "Unknown",
                                Integer.parseInt(HomeScreen.tvUnknown.getText().toString()),
                                Color.parseColor("#525555")));



// To animate the pie chart
                HomeScreen.pieChart.startAnimation();
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

    private void setData() {
        if(activityCategory.equals("Entertainment")){
            HomeScreen.tvEntertainment.setText(Integer.toString(HomeScreen.entertainmentValue + (int)activityTime));
        } else if (activityCategory.equals("Study")){
            HomeScreen.tvStudy.setText(Integer.toString(HomeScreen.studyValue + (int)activityTime));
        } else if (activityCategory.equals("Sport")){
            HomeScreen.tvSport.setText(Integer.toString(HomeScreen.sportValue + (int)activityTime));
        } else if (activityCategory.equals("Socializing")){
            HomeScreen.tvSocializing.setText(Integer.toString(HomeScreen.socializingValue + (int)activityTime));
        } else if (activityCategory.equals("Work")){
            HomeScreen.tvWork.setText(Integer.toString(HomeScreen.workValue + (int)activityTime));
        } else {            //unknown
            HomeScreen.tvUnknown.setText(Integer.toString(HomeScreen.unknownValue + (int)activityTime));
        }
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