package com.example.camelometer;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class GoatActivity extends  AppCompatActivity{

    TextView heartGirthOnlyWarningTextView;
    TextView heartGirthTextView;
    TextView bodyLengthTextView;
    TextView finalWeightTextView;


    String heartGirthString;
    String bodyLengthString;


    public void calculateWeight(View view) {
        heartGirthOnlyWarningTextView.setVisibility(View.INVISIBLE);

        heartGirthString = heartGirthTextView.getText().toString();
        bodyLengthString = bodyLengthTextView.getText().toString();

        double heartGirthDouble;
        double bodyLengthDouble;

        if (TextUtils.isEmpty(heartGirthString)){

            heartGirthTextView.setError("Required Field");

            Toast.makeText(this, "Heart Girth is Required to Estimate.", Toast.LENGTH_SHORT).show();

        } else {

            if (TextUtils.isEmpty(bodyLengthString)){

                Log.i("Info", "Look up goat size in table");

                heartGirthOnlyWarningTextView.setVisibility(View.VISIBLE);

                heartGirthDouble = Double.parseDouble(heartGirthString);

                Double finalWeightDouble = findWeightFromChart(heartGirthDouble);

                displayFinalWeight(finalWeightDouble);

            } else {

                heartGirthDouble = Double.parseDouble(heartGirthString);

                bodyLengthDouble = Double.parseDouble(bodyLengthString);

                double finalWeightDouble = (Math.pow(heartGirthDouble,2.0) * bodyLengthDouble) / 10815;

                displayFinalWeight(finalWeightDouble);



            }
        }

    }


    public double findWeightFromChart(Double heartGirthDouble){
        double finalWeightDouble = 0.0;

        //TODO need to somehow reference the chart, the challenge is that we have some gaps to factor in
        // according to the chart goes like this:
        // ....................
        // 25cm = 2kg
        // 28cm = 2.5kg
        // ...etc
        // ....................
        // So what do we do if an goat measures 26cm or 27cm?
        // Maybe we can just calculate the weight or maybe we can return a range


        return finalWeightDouble;
    }


    public void displayFinalWeight(Double finalWeightDouble) {

        DecimalFormat numberFormat = new DecimalFormat("#.00");

        String finalWeightString = numberFormat.format(finalWeightDouble);

        finalWeightString+= " kg";

        finalWeightTextView.setText(finalWeightString);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goat);

        //Initiate and hide warning text view
        heartGirthOnlyWarningTextView = (TextView) findViewById(R.id.heartGirthOnlyWarning);
        heartGirthOnlyWarningTextView.setVisibility(View.INVISIBLE);

        //Initiate Text Views
        heartGirthTextView = (TextView) findViewById(R.id.heartGirth);
        bodyLengthTextView = (TextView) findViewById(R.id.bodyLength);
        finalWeightTextView = (TextView) findViewById(R.id.finalWeight);


        //Hide the stupid bar on the top the shows the name of the app
        //getSupportActionBar().hide();
    }
}
