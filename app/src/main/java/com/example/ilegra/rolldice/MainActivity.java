package com.example.ilegra.rolldice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.btn_roll);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Random r = new Random();

                TextView total = (TextView)findViewById(R.id.total);
                int total_int = 0;

                // D2 Roll
                EditText d2_quant = (EditText)findViewById(R.id.d2_quant);
                TextView d2_total = (TextView)findViewById(R.id.d2_total);

                int d2_total_int = 0;

                if(Integer.valueOf(d2_quant.getText().toString()) > 0) {
                    for (int i = 0; i < Integer.valueOf(d2_quant.getText().toString()); i++) {
                        d2_total_int += r.nextInt(2);
                    }
                }

                d2_total_int++;
                d2_total.setText(String.valueOf(d2_total_int));

                // D4 Roll
                EditText d4_quant = (EditText)findViewById(R.id.d4_quant);
                TextView d4_total = (TextView)findViewById(R.id.d4_total);

                int d4_total_int = 0;

                //@TODO - test not work
                if(Integer.valueOf(d4_quant.getText().toString()) > 0) {
                    for (int i = 0; i < Integer.valueOf(d4_quant.getText().toString()); i++) {
                        d4_total_int += r.nextInt(4);
                    }
                }

                d4_total_int++;
                d4_total.setText(String.valueOf(d4_total_int));

                total_int = d2_total_int + d4_total_int;
                total.setText(String.valueOf(total_int ));
            }
        });
    }
}
