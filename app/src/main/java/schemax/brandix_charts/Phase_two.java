package schemax.brandix_charts;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Phase_two extends Activity {
    @BindView(R.id.hardware)
    Button hardware;
    @BindView(R.id.software)
    Button software;
    @BindView(R.id.ticket_vol_trends)
    Button ticket_vol_trends;
    @BindView(R.id.sla_trends)
    Button sla_trends;
    @BindView(R.id.cost_per_ticket)
    Button cost_per_ticket;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phase_two);
        ButterKnife.bind(this);
        switch (getIntent().getStringExtra("Options")) {
            case "itinfra_btn":
                hardware.setVisibility(View.VISIBLE);
                software.setVisibility(View.VISIBLE);
                break;
            case "ithelpdesk":
                ticket_vol_trends.setVisibility(View.VISIBLE);
                sla_trends.setVisibility(View.VISIBLE);
                cost_per_ticket.setVisibility(View.VISIBLE);
                break;

        }
    }

    @OnClick({R.id.hardware,R.id.software,R.id.ticket_vol_trends,R.id.sla_trends,R.id.cost_per_ticket})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.hardware:
                Intent hardware = new Intent(Phase_two.this, Phase_three.class);
                hardware.putExtra("Options","hardware");
                startActivity(hardware);
                break;
            case R.id.software:
                Intent software = new Intent(Phase_two.this, Phase_three.class);
                software.putExtra("Options","software");
                startActivity(software);
                break;
            case R.id.ticket_vol_trends:
                Intent ticket_vol_trends = new Intent(Phase_two.this, Home.class);
                ticket_vol_trends.putExtra("Options","ticket_vol_trends");
                startActivity(ticket_vol_trends);
                break;
            case R.id.sla_trends:
                Intent sla_trends = new Intent(Phase_two.this, Home.class);
                sla_trends.putExtra("Options","sla_trends");
                startActivity(sla_trends);
                break;
            case R.id.cost_per_ticket:
                Intent cost_per_ticket = new Intent(Phase_two.this, Home.class);
                cost_per_ticket.putExtra("Options","cost_per_ticket");
                startActivity(cost_per_ticket);
                break;

        }
    }
}
