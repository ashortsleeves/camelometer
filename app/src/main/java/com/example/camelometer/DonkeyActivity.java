package com.example.camelometer;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class DonkeyActivity extends  AppCompatActivity{

    TextView heartGirthOnlyWarningTextView;
    TextView heartGirthTextView;
    TextView bodyLengthTextView;
    TextView finalWeightTextView;
    TextView under3YearsTextView;

    CheckBox under3YearsCheckbox;

    RadioButton maleDonkeyRadioButton;
    RadioButton femaleDonkeyRadioButton;

    String heartGirthString;
    String bodyLengthString;
    String sexOfDonkey;


    public void calculateWeight(View view){

        heartGirthOnlyWarningTextView.setVisibility(View.INVISIBLE);

        heartGirthString = heartGirthTextView.getText().toString();
        bodyLengthString = bodyLengthTextView.getText().toString();

        sexOfDonkey = "male";

        double finalWeight;

        double heartGirthDouble;
        double bodyLengthDouble;

        if (TextUtils.isEmpty(heartGirthString)){

            heartGirthTextView.setError("Required Field");

            Toast.makeText(this, "Heart Girth is Required to Estimate Weight.", Toast.LENGTH_SHORT).show();

        } else {

            heartGirthDouble = Double.parseDouble(heartGirthTextView.getText().toString());

            if (bodyLengthString.isEmpty()){

                Log.i("Info", "Calculate with heart girth only");

                if (maleDonkeyRadioButton.isChecked()){
                    //Male donkey weight = 0.018576 X (heart girth)^1.84107
                    finalWeight = (double) 0.018576 * Math.pow(heartGirthDouble,1.84107);


                } else {
                    //Female donkey weight = 0.031255 X (hearth girth)^1.72888
                    finalWeight = (double) 0.031255 * Math.pow(heartGirthDouble, 1.72888);

                }


            } else {

                bodyLengthDouble = Double.parseDouble(bodyLengthTextView.getText().toString());

                if (under3YearsCheckbox.isChecked()){

                    //(Heart Girth)^2 X Body Length/10,000

                    finalWeight = Math.pow(heartGirthDouble,2) * bodyLengthDouble/10000;

                } else {

                    //(Heart Girth)^2 X Body Length/9,199.6

                    finalWeight = Math.pow(heartGirthDouble,2) * bodyLengthDouble/9199.6;
                }

            }

            displayFinalWeight(finalWeight);

        }

    }





    public void toggleDonkeyAge(View view){

        if (under3YearsCheckbox.isChecked()){
            under3YearsCheckbox.setChecked(false);
        } else {
            under3YearsCheckbox.setChecked(true);
        }
    }


    public void displayFinalWeight(Double finalWeightDouble) {

        DecimalFormat numberFormat = new DecimalFormat("#.00");

        String finalWeightString = numberFormat.format(finalWeightDouble);

        finalWeightString+= " kg";

        finalWeightTextView.setText(finalWeightString);

        heartGirthTextView.setError(null);
        bodyLengthTextView.setError(null);


    }



    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donkey);

        heartGirthOnlyWarningTextView = findViewById(R.id.heartGirthOnlyWarning);
        heartGirthOnlyWarningTextView.setVisibility(View.INVISIBLE);
        heartGirthTextView = findViewById(R.id.heartGirth);
        bodyLengthTextView = findViewById(R.id.bodyLength);
        finalWeightTextView = findViewById(R.id.finalWeight);
        under3YearsTextView = findViewById(R.id.under3Years);

        under3YearsCheckbox = findViewById(R.id.under3YearsCheckBox);

        maleDonkeyRadioButton = findViewById(R.id.maleDonkeyRadioButton);
        femaleDonkeyRadioButton = findViewById(R.id.femaleDonkeyRadioButton);


        //Hide the stupid bar on the top the shows the name of the app
        getSupportActionBar().hide();
    }
}
