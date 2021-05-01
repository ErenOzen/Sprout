package com.example.sprout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.igalata.bubblepicker.BubblePickerListener;
import com.igalata.bubblepicker.adapter.BubblePickerAdapter;
import com.igalata.bubblepicker.model.BubbleGradient;
import com.igalata.bubblepicker.model.PickerItem;
import com.igalata.bubblepicker.rendering.BubblePicker;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

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