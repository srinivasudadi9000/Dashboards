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

public class Phase_four extends Activity {
    @BindView(R.id.bussinesshrs_server)
    Button bussinesshrs_server;
    @BindView(R.id.stability_server)
    Button stability_server;
    @BindView(R.id.lostbusiness)
    Button lostbusiness;
    @BindView(R.id.usage_server)
    Button usage_server;
    @BindView(R.id.stability)
    Button stability;
    @BindView(R.id.vulnerability)
    Button vulnerability;
    @BindView(R.id.protection)
    Button protection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phase_four);
        ButterKnife.bind(this);
        switch (getIntent().getStringExtra("Options")) {
            case "servers":
                bussinesshrs_server.setVisibility(View.VISIBLE);
                stability_server.setVisibility(View.VISIBLE);
                usage_server.setVisibility(View.VISIBLE);
                break;
            case "network":
                lostbusiness.setVisibility(View.VISIBLE);
                stability.setVisibility(View.VISIBLE);
                vulnerability.setVisibility(View.VISIBLE);
                protection.setVisibility(View.VISIBLE);
                break;

        }
    }

    @OnClick({R.id.bussinesshrs_server, R.id.stability_server, R.id.usage_server, R.id.lostbusiness, R.id.stability, R.id.vulnerability
            , R.id.protection})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.bussinesshrs_server:
                Intent bussinesshrs_server = new Intent(Phase_four.this, Phase_five.class);
                bussinesshrs_server.putExtra("Options", "bussinesshrs_server");
                startActivity(bussinesshrs_server);
                break;
            case R.id.stability_server:
                Intent stability_server = new Intent(Phase_four.this, Phase_five.class);
                stability_server.putExtra("Options", "stability_server");
                startActivity(stability_server);
                break;
            case R.id.usage_server:
                Intent usage_server = new Intent(Phase_four.this, Phase_five.class);
                usage_server.putExtra("Options", "usage_server");
                startActivity(usage_server);
                break;
            case R.id.lostbusiness:
                Intent lostbusiness = new Intent(Phase_four.this, Phase_five.class);
                lostbusiness.putExtra("Options", "lostbusiness");
                startActivity(lostbusiness);
                break;
            case R.id.stability:
                Intent stability = new Intent(Phase_four.this, Phase_five.class);
                stability.putExtra("Options", "stability");
                startActivity(stability);
                break;
            case R.id.vulnerability:
                Intent vulnerability = new Intent(Phase_four.this, Phase_five.class);
                vulnerability.putExtra("Options", "vulnerability");
                startActivity(vulnerability);
                break;
            case R.id.protection:
                Intent protection = new Intent(Phase_four.this, Phase_five.class);
                protection.putExtra("Options", "protection");
                startActivity(protection);
                break;

        }
    }
}
