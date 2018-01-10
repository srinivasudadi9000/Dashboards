package schemax.brandix_charts;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class My_Bar_Chart extends Activity {
    BarChart mybar_chart;
    HorizontalBarChart myhorizontal_chart;
    TextView show_horizontal, myheader_tv;
    ImageView myback_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my__bar__chart);
        mybar_chart = (BarChart) findViewById(R.id.mybar_chart);
        myback_img = (ImageView) findViewById(R.id.myback_img);
        myheader_tv = (TextView) findViewById(R.id.myheader_tv);
        myheader_tv.setText("Shop Floor Bar Chart ");
        myhorizontal_chart = (HorizontalBarChart) findViewById(R.id.myhorizontal_chart);
        show_horizontal = (TextView) findViewById(R.id.show_horizontal);

         ArrayList<BarEntry> barEntries = new ArrayList<>();
       // barEntries = new DBHelper(My_Bar_Chart.this).getNormal(My_Bar_Chart.this);

        barEntries.add(new BarEntry(0f, 10));
        barEntries.add(new BarEntry(15f, 20));
        barEntries.add(new BarEntry(30f, 30));
        barEntries.add(new BarEntry(45f, 40));
        barEntries.add(new BarEntry(60f, 50));
        barEntries.add(new BarEntry(75f, 60));
        barEntries.add(new BarEntry(90f, 70));

        BarDataSet dd = new BarDataSet(barEntries, "Dates");
        dd.setColors(ColorTemplate.COLORFUL_COLORS);

        ArrayList<BarEntry> barEntries2 = new ArrayList<>();
        barEntries2.add(new BarEntry(5f, 50));
        barEntries2.add(new BarEntry(20f, 100));
        barEntries2.add(new BarEntry(35f, 150));
        barEntries2.add(new BarEntry(50f, 200));
        barEntries2.add(new BarEntry(65f, 250));
        barEntries2.add(new BarEntry(80f, 300));
        barEntries2.add(new BarEntry(95f, 350));

        BarDataSet dd2 = new BarDataSet(barEntries2, "Dates");
        //dd2.setColors(ColorTemplate.COLORFUL_COLORS);

        ArrayList<String> thedates = new ArrayList<>();
        thedates.add("January");
        thedates.add("Febuary");
        thedates.add("March");
        thedates.add("April");
        thedates.add("May");
        thedates.add("June");
        thedates.add("July");
        //thedates.add("May");

        final BarData barData = new BarData(dd, dd2);
        barData.setBarWidth(7f);
        mybar_chart.setData(barData);
        mybar_chart.setDragXEnabled(true);
        mybar_chart.setDragYEnabled(true);
        mybar_chart.setScaleEnabled(true);
        //  mybar_chart.setAnimation();

        show_horizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (show_horizontal.getText().toString().equals("Show Vertical")) {
                    show_horizontal.setText("Show Horizontal");
                    myhorizontal_chart.setVisibility(View.VISIBLE);
                    myhorizontal_chart.animateY(3000);
                    myhorizontal_chart.setData(barData);
                    mybar_chart.setVisibility(View.GONE);
                } else {
                    show_horizontal.setText("Show Vertical");
                    mybar_chart.setVisibility(View.VISIBLE);
                    myhorizontal_chart.setData(barData);
                    mybar_chart.animateX(1000);
                    myhorizontal_chart.setVisibility(View.GONE);
                }

            }
        });
        myback_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
