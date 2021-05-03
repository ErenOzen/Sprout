package com.example.sprout;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.igalata.bubblepicker.BubblePickerListener;
import com.igalata.bubblepicker.adapter.BubblePickerAdapter;
import com.igalata.bubblepicker.model.BubbleGradient;
import com.igalata.bubblepicker.model.PickerItem;
import com.igalata.bubblepicker.rendering.BubblePicker;
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

import org.jetbrains.annotations.NotNull;

public class HabitActivity extends AppCompatActivity {
    BubblePicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit);

        final String[] habits = getResources().getStringArray(R.array.habits);
        final TypedArray colors = getResources().obtainTypedArray(R.array.colors);
        final TypedArray images = getResources().obtainTypedArray(R.array.images);

        picker = (BubblePicker) findViewById(R.id.picker);
        picker.setAdapter(new BubblePickerAdapter() {
            @Override
            public int getTotalCount() {
                return habits.length;
            }

            @NotNull
            @Override
            public PickerItem getItem(int i) {
                PickerItem item = new PickerItem();
                item.setTitle(habits[i]);
                item.setGradient(new BubbleGradient(colors.getColor((i*2)%8,0),
                        colors.getColor((i*2)%8+1,0),BubbleGradient.VERTICAL));
                item.setTextColor(ContextCompat.getColor(HabitActivity.this, android.R.color.white));
                item.setBackgroundImage(ContextCompat.getDrawable(HabitActivity.this, images.getResourceId(i,0)));
                return item;
            }
        });
        picker.setListener(new BubblePickerListener() {
            @Override
            public void onBubbleSelected(@NotNull PickerItem item) {
                Toast.makeText(HabitActivity.this, item.getTitle(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBubbleDeselected(@NotNull PickerItem item) {

            }
        });



        Toolbar toolbar = (Toolbar) findViewById(R.id.habit_toolbar);
        toolbar.setTitle(R.string.drawer_item_habit);
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
                        new ProfileDrawerItem().withName("Birwar Biryok").withEmail("nowar@gmail.com").withIcon(getResources().getDrawable(R.drawable.noun_sprout_109966))
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
                                startActivity(new Intent(HabitActivity.this, HomeScreen.class));
                                break;
                            case 2:
                                startActivity(new Intent(HabitActivity.this, TodoActivity.class));
                                break;
                            case 3:
                                startActivity(new Intent(HabitActivity.this, CalendarActivity.class));
                                break;
                            case 4:
                                //startActivity(new Intent(HomeScreen.this, HabitActivity.class));
                                break;
                            case 5:
                                startActivity(new Intent(HabitActivity.this, ProfileActivity.class));
                                break;


                        }
                        return false;

                    }
                })

                .build();












    }

    @Override
    protected void onResume() {
        super.onResume();
        picker.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        picker.onPause();
    }
}