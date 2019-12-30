package com.example.camelometer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.HashMap;

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

            //Toast.makeText(this, "Heart Girth is Required to Estimate.", Toast.LENGTH_SHORT).show();

        } else {

            if (TextUtils.isEmpty(bodyLengthString)){

                Log.i("Info", "Look up goat size in table");

                heartGirthDouble = Double.parseDouble(heartGirthString);

                int hearthGirthRoundedInt = (int) Math.rint(heartGirthDouble);

                if (hearthGirthRoundedInt < 25 || hearthGirthRoundedInt > 107) {

                    //Toast.makeText(this, "Unable to calculate. Enter a body length and try again.", Toast.LENGTH_LONG).show();

                    bodyLengthTextView.setError(getString(R.string.requiredField));

                } else {

                    String finalWeightString = findWeightFromChart(hearthGirthRoundedInt);

                    finalWeightTextView.setText(finalWeightString);

                    heartGirthOnlyWarningTextView.setVisibility(View.VISIBLE);
                }


            } else {

                heartGirthDouble = Double.parseDouble(heartGirthString);

                bodyLengthDouble = Double.parseDouble(bodyLengthString);

                double finalWeightDouble = (Math.pow(heartGirthDouble,2.0) * bodyLengthDouble) / 10815;

                displayFinalWeight(finalWeightDouble);



            }
        }

    }


    public String findWeightFromChart(int hearthGirthRoundedInt){

        HashMap<String, String> goatWeightChart = new HashMap<String, String>();


        goatWeightChart.put("25","2.0");
        goatWeightChart.put("26","2.0 – 2.5");
        goatWeightChart.put("27","2.0 – 2.5");
        goatWeightChart.put("28","2.5");
        goatWeightChart.put("29","2.5 – 3.0");
        goatWeightChart.put("30","3.0");
        goatWeightChart.put("31","3.0 – 4.0");
        goatWeightChart.put("32","3.0 – 4.0");
        goatWeightChart.put("33","4.0");
        goatWeightChart.put("34","4.0 – 5.0");
        goatWeightChart.put("35","4.0 – 5.0");
        goatWeightChart.put("36","5.0");
        goatWeightChart.put("37","5.0 – 6.0");
        goatWeightChart.put("38","6.0");
        goatWeightChart.put("39","6.0 – 7.5");
        goatWeightChart.put("40","6.0 – 7.5");
        goatWeightChart.put("41","7.5 – 11.5");
        goatWeightChart.put("42","7.5 – 11.5");
        goatWeightChart.put("43","9.5");
        goatWeightChart.put("44","9.5 – 11.5");
        goatWeightChart.put("45","9.5 – 11.5");
        goatWeightChart.put("46","11.5");
        goatWeightChart.put("47","11.5 – 13.5");
        goatWeightChart.put("48","13.5");
        goatWeightChart.put("49","13.5 – 15.5");
        goatWeightChart.put("50","13.5 – 15.5");
        goatWeightChart.put("51","15.5");
        goatWeightChart.put("52","15.5 – 17.5");
        goatWeightChart.put("53","17.5");
        goatWeightChart.put("54","17.5 – 19.5");
        goatWeightChart.put("55","17.5 – 19.5");
        goatWeightChart.put("56","19.5");
        goatWeightChart.put("57","19.5 – 22.5");
        goatWeightChart.put("58","22.5");
        goatWeightChart.put("59","22.5 – 25.0");
        goatWeightChart.put("60","22.5 – 25.0");
        goatWeightChart.put("61","25.0");
        goatWeightChart.put("62","25.0 – 28.5");
        goatWeightChart.put("63","28.5");
        goatWeightChart.put("64","28.5 – 31.5");
        goatWeightChart.put("65","28.5 – 31.5");
        goatWeightChart.put("66","31.5");
        goatWeightChart.put("67","31.5 – 34.5");
        goatWeightChart.put("68","34.5");
        goatWeightChart.put("69","34.5 – 37.5");
        goatWeightChart.put("70","34.5 – 37.5");
        goatWeightChart.put("71","37.5");
        goatWeightChart.put("72","37.5 – 40.5");
        goatWeightChart.put("73","40.5");
        goatWeightChart.put("74","40.5 – 43.5");
        goatWeightChart.put("75","40.5 – 43.5");
        goatWeightChart.put("76","43.5");
        goatWeightChart.put("77","43.5 – 46.5");
        goatWeightChart.put("78","43.5 – 46.5");
        goatWeightChart.put("79","46.5");
        goatWeightChart.put("80","46.5 – 50.5");
        goatWeightChart.put("81","50.5");
        goatWeightChart.put("82","50.5 – 55");
        goatWeightChart.put("83","50.5 – 55");
        goatWeightChart.put("84","55.0");
        goatWeightChart.put("85","55.0 – 60.0");
        goatWeightChart.put("86","60.0");
        goatWeightChart.put("87","60.0 – 65.0");
        goatWeightChart.put("88","60.0 – 65.0");
        goatWeightChart.put("89","65.0");
        goatWeightChart.put("90","65.0 – 70.0");
        goatWeightChart.put("91","70.0");
        goatWeightChart.put("92","70.0 – 75.0");
        goatWeightChart.put("93","70.0 – 75.0");
        goatWeightChart.put("94","75.0");
        goatWeightChart.put("95","75.0 – 80.0");
        goatWeightChart.put("96","80.0");
        goatWeightChart.put("97","80.0 – 85.0");
        goatWeightChart.put("98","80.0 – 85.0");
        goatWeightChart.put("99","85.0");
        goatWeightChart.put("100","85.0 – 90.0");
        goatWeightChart.put("101","85.0 – 90.0");
        goatWeightChart.put("102","90.0");
        goatWeightChart.put("103","90.0 – 95.0");
        goatWeightChart.put("104","95.0");
        goatWeightChart.put("105","95.0 – 100.0");
        goatWeightChart.put("106","95.0 – 100.0");
        goatWeightChart.put("107","100.0");


        String weightFromChartString = goatWeightChart.get(Integer.toString(hearthGirthRoundedInt));

        weightFromChartString+= " " + getString(R.string.kilogram);

        return weightFromChartString;

    }


    public void displayFinalWeight(Double finalWeightDouble) {

        DecimalFormat numberFormat = new DecimalFormat("#.00");

        String finalWeightString = numberFormat.format(finalWeightDouble);

        finalWeightString+= " " + getString(R.string.kilogram);

        finalWeightTextView.setText(finalWeightString);

        heartGirthTextView.setError(null);
        bodyLengthTextView.setError(null);


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
        getSupportActionBar().hide();
    }
}
