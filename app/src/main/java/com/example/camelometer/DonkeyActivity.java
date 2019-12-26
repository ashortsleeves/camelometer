package com.example.camelometer;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.Spinner;
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

    Spinner sexOfDonkeySpinner;
    CheckBox under3YearsCheckbox;


    String heartGirthString;
    String bodyLengthString;


    public void calculateWeight(View view){

        heartGirthOnlyWarningTextView.setVisibility(View.INVISIBLE);

        heartGirthString = heartGirthTextView.getText().toString();
        bodyLengthString = bodyLengthTextView.getText().toString();

        double heartGirthDouble;
        double bodyLengthDouble;

        if (TextUtils.isEmpty(heartGirthString)){

            heartGirthTextView.setError("Required Field");

            Toast.makeText(this, "Heart Girth is Required to Estimate Weight.", Toast.LENGTH_SHORT).show();

        } else {

            if (bodyLengthString.isEmpty()){

                Log.i("Info", "Calculate with heart girth only");

                Log.i("Info", sexOfDonkeySpinner.getSelectedItem();



            } else {

                Log.i("Info", "Calculate with heart girth AND body length");

            }


        }

    }





    public void toggleDonkeyAge(View view){

        if (under3YearsCheckbox.isChecked()){
            under3YearsCheckbox.setChecked(false);
        } else {
            under3YearsCheckbox.setChecked(true);
        }
    }

    public void expandSpinner(View view){

        sexOfDonkeySpinner.performClick();

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
        heartGirthTextView = findViewById(R.id.heartGirth);
        bodyLengthTextView = findViewById(R.id.bodyLength);
        finalWeightTextView = findViewById(R.id.finalWeight);
        under3YearsTextView = findViewById(R.id.under3Years);

        sexOfDonkeySpinner = findViewById(R.id.sexOfDonkeySpinner);
        under3YearsCheckbox = findViewById(R.id.under3YearsCheckBox);


        //Hide the stupid bar on the top the shows the name of the app
        getSupportActionBar().hide();
    }
}
