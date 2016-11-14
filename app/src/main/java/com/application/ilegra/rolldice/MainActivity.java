package com.application.ilegra.rolldice;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link Tracker} used to record screen views.
     */
    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // [START shared_tracker]
        // Obtain the shared Tracker instance.
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();
        // [END shared_tracker]

        final Button button = (Button) findViewById(R.id.btn_roll);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView total = (TextView)findViewById(R.id.total);
                total.setText(String.valueOf(calc()));

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(total.getWindowToken(),
                        InputMethodManager.RESULT_UNCHANGED_SHOWN);

            }
        });

        mTracker.setScreenName("Home");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    public void clean( View v ) {
        switch (v.getId()) {
            case (R.id.d2_clean_button):
                EditText d2_quant = (EditText)findViewById(R.id.d2_quant);
                d2_quant.setText("");
                d2_quant.requestFocus();
                break;
            case (R.id.d4_clean_button):
                EditText d4_quant = (EditText)findViewById(R.id.d4_quant);
                d4_quant.setText("");
                d4_quant.requestFocus();
                break;
            case (R.id.d6_clean_button):
                EditText d6_quant = (EditText)findViewById(R.id.d6_quant);
                d6_quant.setText("");
                d6_quant.requestFocus();
                break;
            case (R.id.d8_clean_button):
                EditText d8_quant = (EditText)findViewById(R.id.d8_quant);
                d8_quant.setText("");
                d8_quant.requestFocus();
                break;
            case (R.id.d10_clean_button):
                EditText d10_quant = (EditText)findViewById(R.id.d10_quant);
                d10_quant.setText("");
                d10_quant.requestFocus();
                break;
            case (R.id.d12_clean_button):
                EditText d12_quant = (EditText)findViewById(R.id.d12_quant);
                d12_quant.setText("");
                d12_quant.requestFocus();
                break;
            case (R.id.d20_clean_button):
                EditText d20_quant = (EditText)findViewById(R.id.d20_quant);
                d20_quant.setText("");
                d20_quant.requestFocus();
                break;
        }

        TextView total = (TextView)findViewById(R.id.total);
        total.setText(String.valueOf(calc()));
    }

    public int calc(){
        int total_int = 0;

        // D2 Roll
        EditText d2_quant = (EditText)findViewById(R.id.d2_quant);
        TextView d2_total = (TextView)findViewById(R.id.d2_total);
        Dice d2_dice = new Dice(d2_quant.getText().toString(), 2);
        int d2_total_int = d2_dice.roll();
        total_int += d2_total_int;
        d2_total.setText(String.valueOf(d2_total_int));

        // D4 Roll
        EditText d4_quant = (EditText)findViewById(R.id.d4_quant);
        TextView d4_total = (TextView)findViewById(R.id.d4_total);
        Dice d4_dice = new Dice(d4_quant.getText().toString(), 4);
        int d4_total_int = d4_dice.roll();
        total_int += d4_total_int;
        d4_total.setText(String.valueOf(d4_total_int));

        // D6 Roll
        EditText d6_quant = (EditText)findViewById(R.id.d6_quant);
        TextView d6_total = (TextView)findViewById(R.id.d6_total);
        Dice d6_dice = new Dice(d6_quant.getText().toString(), 6);
        int d6_total_int = d6_dice.roll();
        total_int += d6_total_int;
        d6_total.setText(String.valueOf(d6_total_int));

        // D8 Roll
        EditText d8_quant = (EditText)findViewById(R.id.d8_quant);
        TextView d8_total = (TextView)findViewById(R.id.d8_total);
        Dice d8_dice = new Dice(d8_quant.getText().toString(), 8);
        int d8_total_int = d8_dice.roll();
        total_int += d8_total_int;
        d8_total.setText(String.valueOf(d8_total_int));

        // D10 Roll
        EditText d10_quant = (EditText)findViewById(R.id.d10_quant);
        TextView d10_total = (TextView)findViewById(R.id.d10_total);
        Dice d10_dice = new Dice(d10_quant.getText().toString(), 10);
        int d10_total_int = d10_dice.roll();
        total_int += d10_total_int;
        d10_total.setText(String.valueOf(d10_total_int));

        // D12 Roll
        EditText d12_quant = (EditText)findViewById(R.id.d12_quant);
        TextView d12_total = (TextView)findViewById(R.id.d12_total);
        Dice d12_dice = new Dice(d12_quant.getText().toString(), 12);
        int d12_total_int = d12_dice.roll();
        total_int += d12_total_int;
        d12_total.setText(String.valueOf(d12_total_int));

        // D20 Roll
        EditText d20_quant = (EditText)findViewById(R.id.d20_quant);
        TextView d20_total = (TextView)findViewById(R.id.d20_total);
        Dice d20_dice = new Dice(d20_quant.getText().toString(), 20);
        int d20_total_int = d20_dice.roll();
        total_int += d20_total_int;
        d20_total.setText(String.valueOf(d20_total_int));

        return total_int;
    }
}
