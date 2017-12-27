package schemax.brandix_charts;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends Activity implements View.OnClickListener{
Button mypiechart,mybarchart,myLinechart,myplainchart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        mybarchart = (Button) findViewById(R.id.mybarchart);
        mypiechart = (Button) findViewById(R.id.mypiechart);
        myLinechart = (Button) findViewById(R.id.myLinechart);
        myplainchart = (Button) findViewById(R.id.myplainchart);
        myLinechart.setOnClickListener(this);
        mypiechart.setOnClickListener(this);
        mybarchart.setOnClickListener(this);
        myplainchart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mybarchart:
                Intent barchart = new Intent(Home.this,My_Bar_Chart.class);
                startActivity(barchart);
                break;
            case R.id.mypiechart:
                Intent piechart = new Intent(Home.this,My_Pie_Chart.class);
                startActivity(piechart);
                break;
            case R.id.myLinechart:
                Intent linechart = new Intent(Home.this,My_Line_Chart.class);
                startActivity(linechart);
                break;
            case R.id.myplainchart:
                Intent plainchart = new Intent(Home.this,Materialdesigndashboard.class);
                startActivity(plainchart);
                break;
        }

    }
}
