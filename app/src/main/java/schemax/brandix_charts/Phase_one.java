package schemax.brandix_charts;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Phase_one extends Activity {
    @BindView(R.id.csat)
    Button csat;
    @BindView(R.id.capital_expense)
    Button capital_expense;
    @BindView(R.id.operational)
    Button operational;
    @BindView(R.id.adhbud_list)
    Button adhbud_list;
    @BindView(R.id.itinfra_btn)
    Button itinfra_btn;
    @BindView(R.id.ithelpdesk)
    Button ithelpdesk;
    @BindView(R.id.emp_sta_index)
    Button emp_sta_index;
    @BindView(R.id.emp_turnover)
    Button emp_turnover;
    @BindView(R.id.staff_user_ratio)
    Button staff_user_ratio;
    @BindView(R.id.emp_cost_per_ticket)
    Button emp_cost_per_ticket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phase_one);
        ButterKnife.bind(this);
        switch (getIntent().getStringExtra("Options")) {
            case "customer":
                csat.setVisibility(View.VISIBLE);
                break;
            case "investor":
                capital_expense.setVisibility(View.VISIBLE);
                operational.setVisibility(View.VISIBLE);
                adhbud_list.setVisibility(View.VISIBLE);
                break;
            case "process":
                itinfra_btn.setVisibility(View.VISIBLE);
                ithelpdesk.setVisibility(View.VISIBLE);
                break;
            case "people":
                emp_sta_index.setVisibility(View.VISIBLE);
                emp_turnover.setVisibility(View.VISIBLE);
                staff_user_ratio.setVisibility(View.VISIBLE);
                emp_cost_per_ticket.setVisibility(View.VISIBLE);
                break;
        }

    }

    @OnClick({R.id.csat, R.id.capital_expense, R.id.operational, R.id.adhbud_list, R.id.itinfra_btn, R.id.emp_sta_index, R.id.staff_user_ratio,
            R.id.ithelpdesk, R.id.emp_turnover, R.id.emp_cost_per_ticket})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.csat:
                Intent home = new Intent(Phase_one.this, Home.class);
                startActivity(home);
                break;
            case R.id.capital_expense:
                Intent home2 = new Intent(Phase_one.this, Home.class);
                startActivity(home2);
                break;
            case R.id.operational:
                Intent home3 = new Intent(Phase_one.this, Home.class);
                startActivity(home3);
                break;
            case R.id.adhbud_list:
                Intent home4 = new Intent(Phase_one.this, Home.class);
                startActivity(home4);
                break;
            case R.id.itinfra_btn:
                Intent itinfra_btn = new Intent(Phase_one.this, Phase_two.class);
                itinfra_btn.putExtra("Options","itinfra_btn");
                startActivity(itinfra_btn);
                break;
            case R.id.ithelpdesk:
                Intent ithelpdesk = new Intent(Phase_one.this, Phase_two.class);
                ithelpdesk.putExtra("Options","ithelpdesk");
                startActivity(ithelpdesk);
                break;
            case R.id.emp_turnover:
                Intent emp_turnover = new Intent(Phase_one.this, Home.class);
                startActivity(emp_turnover);
                break;
            case R.id.emp_sta_index:
                Intent phasetwo1 = new Intent(Phase_one.this, Home.class);
                startActivity(phasetwo1);
                break;
            case R.id.staff_user_ratio:
                Intent phasetwo2 = new Intent(Phase_one.this, Home.class);
                startActivity(phasetwo2);
                break;
            case R.id.emp_cost_per_ticket:
                Intent emp_cost_per_ticket = new Intent(Phase_one.this, Home.class);
                startActivity(emp_cost_per_ticket);
                break;

        }
    }

}
