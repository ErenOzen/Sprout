package com.example.sprout;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ReportActivity extends AppCompatActivity {

    BarChart barChart;
    ArrayList<BarEntry> barEntryArrayList;
    ArrayList<String> activityNames;

    ArrayList<ReportDatas> reportDatasArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        barChart = findViewById(R.id.barChart);

        //create new object of bar entries arraylist and activity names arraylist
        barEntryArrayList = new ArrayList<>();
        activityNames = new ArrayList<>();


        for (int i = 0; i <reportDatasArrayList.size(); i++) {
            String dates = reportDatasArrayList.get(i).getDates();
            int activityTime = reportDatasArrayList.get(i).getActivityTime();
            barEntryArrayList.add(new BarEntry(i,activityTime));
            activityNames.add(dates);
        }
        BarDataSet barDataSet = new BarDataSet(barEntryArrayList,"Weekly Activity Reports");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        Description description = new Description();
        description.setText("Days");
        barChart.setDescription(description);
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(activityNames));

        xAxis.setPosition(XAxis.XAxisPosition.TOP);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(activityNames.size());
        xAxis.setLabelRotationAngle(270);
        barChart.animateY(2000);
        barChart.invalidate();
    }
    private void fillDatas() {
        reportDatasArrayList.clear();
        reportDatasArrayList.add(new ReportDatas("1",500));
        reportDatasArrayList.add(new ReportDatas("2",600));
        reportDatasArrayList.add(new ReportDatas("3",700));
        reportDatasArrayList.add(new ReportDatas("4",800));
        reportDatasArrayList.add(new ReportDatas("5",900));
        reportDatasArrayList.add(new ReportDatas("6",100));


    }
}