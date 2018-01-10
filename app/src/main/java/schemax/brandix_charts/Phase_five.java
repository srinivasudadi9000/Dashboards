package schemax.brandix_charts;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Phase_five extends Activity {
    @BindView(R.id.average_amount)
    Button average_amount;
    @BindView(R.id.longestdowntime)
    Button longestdowntime;
    @BindView(R.id.critical)
    Button critical;
    @BindView(R.id.lenght_of_time)
    Button lenght_of_time;
    @BindView(R.id.no_of_downtime)
    Button no_of_downtime;
    @BindView(R.id.per_red_assests)
    Button per_red_assests;
    @BindView(R.id.per_red_major)
    Button per_red_major;
    @BindView(R.id.cpu)
    Button cpu;
    @BindView(R.id.ram)
    Button ram;
    @BindView(R.id.aver_amount_downtime)
    Button aver_amount_downtime;
    @BindView(R.id.long_lost_busines)
    Button long_lost_busines;
    @BindView(R.id.critical_lost_business)
    Button critical_lost_business;
    @BindView(R.id.lenght_of_time_lost)
    Button lenght_of_time_lost;
    @BindView(R.id.no_of_downtime_lost)
    Button no_of_downtime_lost;
    @BindView(R.id.per_red_assests_stability)
    Button per_red_assests_stability;
    @BindView(R.id.per_red_major_stability)
    Button per_red_major_stability;
    @BindView(R.id.vul_incident)
    Button vul_incident;
    @BindView(R.id.vul_bus_lost)
    Button vul_bus_lost;
    @BindView(R.id.vul_percentage)
    Button vul_percentage;
    @BindView(R.id.prot_security)
    Button prot_security;
    @BindView(R.id.prot_complaince)
    Button prot_complaince;
    @BindView(R.id.prot_incident)
    Button prot_incident;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phase_five);
        ButterKnife.bind(this);
        switch (getIntent().getStringExtra("Options")) {
            case "bussinesshrs_server":
                average_amount.setVisibility(View.VISIBLE);
                longestdowntime.setVisibility(View.VISIBLE);
                critical.setVisibility(View.VISIBLE);
                lenght_of_time.setVisibility(View.VISIBLE);
                no_of_downtime.setVisibility(View.VISIBLE);
                break;
            case "stability_server":
                per_red_major.setVisibility(View.VISIBLE);
                per_red_assests.setVisibility(View.VISIBLE);
                break;
            case "usage_server":
                cpu.setVisibility(View.VISIBLE);
                ram.setVisibility(View.VISIBLE);
                break;
            case "lostbusiness":
                aver_amount_downtime.setVisibility(View.VISIBLE);
                long_lost_busines.setVisibility(View.VISIBLE);
                critical_lost_business.setVisibility(View.VISIBLE);
                lenght_of_time_lost.setVisibility(View.VISIBLE);
                no_of_downtime_lost.setVisibility(View.VISIBLE);
                break;
            case "stability":
                per_red_assests_stability.setVisibility(View.VISIBLE);
                per_red_major_stability.setVisibility(View.VISIBLE);
                 break;
            case "vulnerability":
                vul_incident.setVisibility(View.VISIBLE);
                vul_bus_lost.setVisibility(View.VISIBLE);
                vul_percentage.setVisibility(View.VISIBLE);
                break;
            case "protection":
                prot_security.setVisibility(View.VISIBLE);
                prot_complaince.setVisibility(View.VISIBLE);
                prot_incident.setVisibility(View.VISIBLE);
                break;

        }
    }
}
