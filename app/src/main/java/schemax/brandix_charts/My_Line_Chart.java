package schemax.brandix_charts;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class My_Line_Chart extends Activity {
    LineChart myline_chart;
    TextView myheader_tv;
    ImageView myback_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.line__chart);
        myback_img = (ImageView) findViewById(R.id.myback_img);
        myheader_tv = (TextView) findViewById(R.id.myheader_tv);
        myheader_tv.setText("Shop Floor Line Chart ");

        myline_chart = (LineChart) findViewById(R.id.myline_chart);
        myline_chart.setDragXEnabled(true);
        myline_chart.setDragYEnabled(true);
        myline_chart.setScaleEnabled(true);
        myline_chart.setEnabled(true);
        myline_chart.setNoDataTextColor(Color.GREEN);
         myline_chart.setBorderColor(Color.BLACK);
        myline_chart.setDrawMarkers(true);
        myline_chart.setActivated(true);
        myline_chart.animate();

        myline_chart.bringToFront();
        myline_chart.buildDrawingCache(true);

        ArrayList<Entry> yValues = new ArrayList<>();
        yValues.add(new Entry(0, 50f));
        yValues.add(new Entry(1, -50f));
        yValues.add(new Entry(2, 10f));
        yValues.add(new Entry(3, 50f));
        yValues.add(new Entry(4, 30f));
        yValues.add(new Entry(5, 70f));

        LineDataSet set1 = new LineDataSet(yValues, "Dates");
        set1.setFillAlpha(110);
       // set1.setColor(Color.RED);
        set1.setLineWidth(5f);
        set1.setValueTextSize(10f);
        set1.setValueTextColor(Color.GREEN);
        set1.setCircleRadius(10f);
        set1.setCircleHoleRadius(5f);
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData lineData = new LineData(dataSets);
        myline_chart.setData(lineData);
        myline_chart.animateY(3000);


        LimitLine upper_limit = new LimitLine(90f, "Upper Limit");
        upper_limit.setLineWidth(4f);
        upper_limit.setLineColor(Color.GREEN);
        upper_limit.enableDashedLine(10f, 10f, 0f);
        upper_limit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
        upper_limit.setTextSize(10f);

        LimitLine lower_limit = new LimitLine(-30f, "Lower Limit");
        lower_limit.setLineWidth(4f);
        lower_limit.setLineColor(Color.RED);
        lower_limit.enableDashedLine(10f, 10f, 0f);
        lower_limit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        lower_limit.setTextSize(10f);

        YAxis leftAxis = myline_chart.getAxisLeft();
        leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
        leftAxis.addLimitLine(upper_limit);
        leftAxis.addLimitLine(lower_limit);
        leftAxis.setAxisMaxValue(100f);
        leftAxis.setAxisMinValue(-50f);
        //leftAxis.setYOffset(20f);
        leftAxis.enableGridDashedLine(10f, 10f, 0f);
        leftAxis.setDrawZeroLine(false);

        // limit lines are drawn behind data (and not on top)
        leftAxis.setDrawLimitLinesBehindData(true);

        myline_chart.getAxisRight().setEnabled(false);
        //myline_chart.animateX(2500, Easing.EasingOption.EaseInOutQuart);
        leftAxis.setDrawLimitLinesBehindData(true);

        myline_chart.getAxisRight().setEnabled(false);

        myback_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
