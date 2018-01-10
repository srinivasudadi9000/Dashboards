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

public class Cipp extends Activity {
    //Button customer_btn,investor_btn,process_btn,people_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cipp);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.customer_btn, R.id.investor_btn, R.id.process_btn, R.id.people_btn})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.customer_btn:
                Intent phaseone = new Intent(Cipp.this, Phase_one.class);
                phaseone.putExtra("Options","customer");
                startActivity(phaseone);
                break;
            case R.id.investor_btn:
                Intent investor_btn = new Intent(Cipp.this, Phase_one.class);
                investor_btn.putExtra("Options","investor");
                startActivity(investor_btn);
                break;
            case R.id.process_btn:
                Intent process_btn = new Intent(Cipp.this, Phase_one.class);
                process_btn.putExtra("Options","process");
                startActivity(process_btn);
                break;
            case R.id.people_btn:
                Intent people_btn = new Intent(Cipp.this, Phase_one.class);
                people_btn.putExtra("Options","people");
                startActivity(people_btn);
                break;

        }
    }
}
