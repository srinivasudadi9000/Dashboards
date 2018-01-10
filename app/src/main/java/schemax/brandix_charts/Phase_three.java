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

public class Phase_three extends Activity {
    @BindView(R.id.servers)
    Button servers;
    @BindView(R.id.network)
    Button network;
    @BindView(R.id.utilization)
    Button utilization;
    @BindView(R.id.compliance)
    Button compliance;
    @BindView(R.id.availability)
    Button availability;
    @BindView(R.id.licence)
    Button licence;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phase_three);
        ButterKnife.bind(this);
        switch (getIntent().getStringExtra("Options")) {
            case "hardware":
                servers.setVisibility(View.VISIBLE);
                network.setVisibility(View.VISIBLE);
                break;
            case "software":
                utilization.setVisibility(View.VISIBLE);
                compliance.setVisibility(View.VISIBLE);
                availability.setVisibility(View.VISIBLE);
                licence.setVisibility(View.VISIBLE);
                break;

        }
    }
    @OnClick({R.id.servers,R.id.network,R.id.utilization,R.id.compliance,R.id.availability,R.id.licence})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.servers:
                Intent servers = new Intent(Phase_three.this, Phase_four.class);
                servers.putExtra("Options","servers");
                startActivity(servers);
                break;
            case R.id.network:
                Intent network = new Intent(Phase_three.this, Phase_four.class);
                network.putExtra("Options","network");
                startActivity(network);
                break;
            case R.id.utilization:
                Intent utilization = new Intent(Phase_three.this, Home.class);
               // utilization.putExtra("Options","utilization");
                startActivity(utilization);
                break;
            case R.id.compliance:
                Intent compliance = new Intent(Phase_three.this, Home.class);
               // compliance.putExtra("Options","compliance");
                startActivity(compliance);
                break;
            case R.id.availability:
                Intent availability = new Intent(Phase_three.this, Home.class);
               // availability.putExtra("Options","availability");
                startActivity(availability);
                break;
            case R.id.licence:
                Intent licence = new Intent(Phase_three.this, Home.class);
                //licence.putExtra("Options","licence");
                startActivity(licence);
                break;

        }
    }
}
