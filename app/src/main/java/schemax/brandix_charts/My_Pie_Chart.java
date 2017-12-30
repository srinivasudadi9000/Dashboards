package schemax.brandix_charts;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class My_Pie_Chart extends Activity {
    PieChart mypiechart;
    float[] yData = {22.22f, 32.33f, 34.22f, 38.33f, 45.55f,23.33f,22.22f,10.10f};
    String[] xData = {"stock", "material", "cotton", "shopfloor", "seeds","filter","glit","mary"};

    BarChart mybarchart;

    ArrayList<BarEntry> BARENTRY;
    ArrayList<String> BarEntryLabels;
    BarDataSet Bardataset;
    BarData BARDATA;

    int avg = 0;
    String[][] Array2D = new String[60][2];
    Float[][] AvgArray = new Float[40][2];
    Float[][] FinalAvg = new Float[40][2];

    TextView myheader_tv;
    ImageView myback_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        Log.d("hello", "pie chart created");

        myheader_tv = (TextView) findViewById(R.id.myheader_tv);
        myheader_tv.setText("Shop Floor Pie Chart");

        myback_img = (ImageView) findViewById(R.id.myback_img);

        // Pie Chart Description ...
        mypiechart = (PieChart) findViewById(R.id.mypie_chart);
        mypiechart.setRotationEnabled(true);
        mypiechart.setTransparentCircleAlpha(0);
        mypiechart.setHoleRadius(25f);
        mypiechart.setCenterText("shop floor");
        mypiechart.setCenterTextSize(20);
        mypiechart.setDrawEntryLabels(true);
        addPieChart();

        myback_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void addBarChart() {
        ArrayList<BarEntry> bargroup1 = new ArrayList<>();
        bargroup1.add(new BarEntry(8f, 0));
        bargroup1.add(new BarEntry(2f, 1));
        bargroup1.add(new BarEntry(5f, 2));
        bargroup1.add(new BarEntry(20f, 3));
        bargroup1.add(new BarEntry(15f, 4));
        bargroup1.add(new BarEntry(19f, 5));

// create BarEntry for Bar Group 1
        ArrayList<BarEntry> bargroup2 = new ArrayList<>();
        bargroup2.add(new BarEntry(6f, 0));
        bargroup2.add(new BarEntry(10f, 1));
        bargroup2.add(new BarEntry(5f, 2));
        bargroup2.add(new BarEntry(25f, 3));
        bargroup2.add(new BarEntry(4f, 4));
        bargroup2.add(new BarEntry(17f, 5));

// creating dataset for Bar Group1
        BarDataSet barDataSet1 = new BarDataSet(bargroup1, "Bar Group 1");

//barDataSet1.setColor(Color.rgb(0, 155, 0));
        barDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);

// creating dataset for Bar Group 2
        BarDataSet barDataSet2 = new BarDataSet(bargroup2, "Bar Group 2");
        barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("2016");
        labels.add("2015");
        labels.add("2014");
        labels.add("2013");
        labels.add("2012");
        labels.add("2011");

        ArrayList<BarDataSet> dataSets = new ArrayList<>();  // combined all dataset into an arraylist
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);

// initialize the Bardata with argument labels and dataSet
        BarData data = new BarData();
        mybarchart.setData(data);

    }

    private void addPieChart() {
        ArrayList<PieEntry> yEntries = new ArrayList<>();
        ArrayList<String> xEntries = new ArrayList<>();

        for (int i = 0; i < yData.length; i++) {
            yEntries.add(new PieEntry(yData[i], i));
        }
        for (int j = 0; j < xData.length; j++) {
            xEntries.add(xData[j]);
        }

        PieDataSet pieDataSet = new PieDataSet(yEntries, "Shop Floor");
        pieDataSet.setSliceSpace(5.5f);
        pieDataSet.setValueTextSize(20);

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.GRAY);
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.RED);
        colors.add(Color.YELLOW);
        pieDataSet.setColors(colors);

        Legend legend = mypiechart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        PieData pieData = new PieData(pieDataSet);
        mypiechart.setData(pieData);
        mypiechart.invalidate();
        mypiechart.animateY(1000, Easing.EasingOption.EaseInCubic);
        mypiechart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Toast.makeText(getBaseContext(),e.getData().toString(),Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alertadd = new AlertDialog.Builder(My_Pie_Chart.this);
                LayoutInflater factory = LayoutInflater.from(My_Pie_Chart.this);
                final View view = factory.inflate(R.layout.image_view, null);
                alertadd.setView(view);
                alertadd.setNeutralButton("Here!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dlg, int sumthin) {

                    }
                });

                AlertDialog alertDialog = alertadd.create();
                alertDialog.getWindow().setLayout(100, 100);
                alertadd.show();
            }

            @Override
            public void onNothingSelected() {

            }
        });
    }


}
