package com.example.sprout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.sprout.user.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

/**
 * This class is the java file for HomeScreen Activity screen / exm file .
 * @author DilayYigit, Eren Ozen
 * @version 30 April 2021
 */
public class HomeScreen extends AppCompatActivity implements View.OnClickListener {

    //Instance Variables
    private FloatingActionButton addEvent;
    private FloatingActionButton report;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    public static User activeUser;
    public static TextView tvEntertainment;
    public static TextView tvStudy;
    public static TextView tvSport;
    public static TextView tvSocializing;
    public static TextView tvWork;
    public static TextView tvUnknown;

    public static int entertainmentValue = 3;
    public static int studyValue = 2;
    public static int sportValue = 1;
    public static int socializingValue = 3;
    public static int workValue = 2;
    public static int unknownValue = 5;

    public static PieChart pieChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        tvEntertainment = findViewById(R.id.tvEntertainment);
        tvStudy = findViewById(R.id.tvStudy);
        tvSport = findViewById(R.id.tvSport);
        tvSocializing = findViewById(R.id.tvSocializing);
        tvUnknown = findViewById(R.id.tvUnknown);
        tvWork = findViewById(R.id.tvWork);
        pieChart = findViewById(R.id.piechart);
        setData();

        addEvent = (FloatingActionButton) findViewById(R.id.floatingActionButtonNewEvent);
        report = (FloatingActionButton) findViewById(R.id.floatingActionButtonReport);
        addEvent.setOnClickListener(this);
        report.setOnClickListener(this);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();
        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);
                if (userProfile != null) {
                    String email = userProfile.getEmail();
                    activeUser = new User(email);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(HomeScreen.this, "Something wrong happened!", Toast.LENGTH_LONG).show();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.home_toolbar);
        toolbar.setTitle(R.string.drawer_item_home);
//if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName(R.string.drawer_item_home).withIcon(R.drawable.ic_home);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName(R.string.drawer_item_todo).withIcon(R.drawable.ic_todo);
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName(R.string.drawer_item_calendar).withIcon(R.drawable.ic_calendar);
        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(4).withName(R.string.drawer_item_habit).withIcon(R.drawable.ic_habit);
        SecondaryDrawerItem item5 = new SecondaryDrawerItem().withIdentifier(5).withName(R.string.drawer_item_account).withIcon(R.drawable.ic_account);
        SecondaryDrawerItem item6 = new SecondaryDrawerItem().withIdentifier(6).withName(R.string.drawer_item_settings).withIcon(R.drawable.ic_settings);

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.ic_launcher_background)
                .withTextColorRes(R.color.color_white)
                .addProfiles(
                        new ProfileDrawerItem().withName("Eren Özen").withEmail("erenozen@outlook.com").withIcon(getResources().getDrawable(R.drawable.noun_sprout_109966))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();
//create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        item1,
                        item2,
                        item3,
                        item4,
                        new DividerDrawerItem(),
                        item5,
                        item6
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switch ((int) drawerItem.getIdentifier()) {
                            case 1:
                                //startActivity(new Intent(HomeScreen.this, HomeScreen.class));
                                break;
                            case 2:
                                startActivity(new Intent(HomeScreen.this, TodoActivity.class));
                                break;
                            case 3:
                                startActivity(new Intent(HomeScreen.this, CalendarActivity.class));
                                break;
                            case 4:
                                startActivity(new Intent(HomeScreen.this, HabitActivity.class));
                                break;
                            case 5:
                                startActivity(new Intent(HomeScreen.this, ProfileActivity.class));
                                break;


                        }
                        return false;

                    }
                })

                .build();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.floatingActionButtonNewEvent:
            startActivity(new Intent(this,TimerActivity.class));
            break;
            case R.id.floatingActionButtonReport:
                startActivity(new Intent(this,ReportActivity.class));
                break;

        }
    }

    private void setData() {
        // Set the percentage of language used
        tvEntertainment.setText(Integer.toString(entertainmentValue));
        tvStudy.setText(Integer.toString(studyValue));
        tvSport.setText(Integer.toString(sportValue));
        tvSocializing.setText(Integer.toString(socializingValue));
        tvWork.setText(Integer.toString(workValue));
        tvUnknown.setText(Integer.toString(unknownValue));

        // Set the data and color to the pie chart
        pieChart.addPieSlice(
                new PieModel(
                        "Entertainment",
                        Integer.parseInt(tvEntertainment.getText().toString()),
                        Color.parseColor("#5E35B1")));
        pieChart.addPieSlice(
                new PieModel(
                        "Study",
                        Integer.parseInt(tvStudy.getText().toString()),
                        Color.parseColor("#1E88E5")));
        pieChart.addPieSlice(
                new PieModel(
                        "Sport",
                        Integer.parseInt(tvSport.getText().toString()),
                        Color.parseColor("#005E04")));
        pieChart.addPieSlice(
                new PieModel(
                        "Socializing",
                        Integer.parseInt(tvSocializing.getText().toString()),
                        Color.parseColor("#8E24AA")));
        pieChart.addPieSlice(
                new PieModel(
                        "Work",
                        Integer.parseInt(tvWork.getText().toString()),
                        Color.parseColor("#E53935")));
        pieChart.addPieSlice(
                new PieModel(
                        "Unknown",
                        Integer.parseInt(tvUnknown.getText().toString()),
                        Color.parseColor("#525555")));



// To animate the pie chart
        pieChart.startAnimation();
    }

    public static void resetEntertainmentValue() {
        entertainmentValue = 0;
    }
    public static void resetWorkValue() {
        workValue = 0;
    }
    public static void resetUnknownValue() {
        unknownValue = 0;
    }
    public static void resetSocializingValue() {
        socializingValue = 0;
    }
    public static void resetSportValue() {
        sportValue = 0;
    }
    public static void resetStudyValue() {
        studyValue = 0;
    }


}