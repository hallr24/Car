package com.example.carloancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private SeekBar MBar;
    private EditText CarCost1;
    private EditText Down1;
    private EditText APR1;
    private EditText Payment;
    private CheckBox LoanButton;
    private CheckBox LeaseButton;
    private TextView Length;
    public Button Button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button = findViewById(R.id.Button);
        MBar = findViewById(R.id.MBar);
        CarCost1= findViewById(R.id.CarCost1);
        Down1= findViewById(R.id.Down1);
        APR1= findViewById(R.id.APR1);
        Payment= findViewById(R.id.Payment);
        LoanButton= findViewById(R.id.LoanButton);
        LeaseButton = findViewById(R.id.LeaseButton);
        Length = findViewById(R.id.Length);
        MBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar MBar, int progress, boolean fromUser) {
            Length.setText("Length of Loan" +MBar.getProgress());
        }
        @Override
        public void onStartTrackingTouch(SeekBar MBar){
        }
        @Override
        public void onStopTrackingTouch(SeekBar MBar){
        }

        });
    }
    public void convert(View v){
        double CT;
        double DP;
        double APR2;
        double Pay;
        double MSBar;
        String parseString = "null";
        int tMonths;
        if(LoanButton.isChecked()) {
            parseString = CarCost1.getText().toString();
            CT = Double.parseDouble(parseString);
            parseString = Down1.getText().toString();
            DP = Double.parseDouble(parseString);
            parseString = APR1.getText().toString();
            APR2 = Double.parseDouble(parseString) / 12;
            Pay = CT - DP;
            tMonths = MBar.getProgress();
            CT = (APR2 * Pay) / (1 - Math.pow((1 + APR2), -tMonths));
            Payment.setText("$" + String.format("%.2f", CT));
        }
        else if(LeaseButton.isChecked()){
            MBar.setProgress(36);
            parseString = CarCost1.getText().toString();
            CT = Double.parseDouble(parseString)/3;
            parseString = Down1.getText().toString();
            DP = Double.parseDouble(parseString);
            parseString = APR1.getText().toString();
            APR2 = Double.parseDouble(parseString) / 12;
            Pay = CT - DP;
            tMonths = 36;
            CT = (APR2 * Pay) / (1 - Math.pow((1 + APR2), -tMonths));
            Payment.setText("$" + String.format("%.2f", CT));
        }

        }


    }


