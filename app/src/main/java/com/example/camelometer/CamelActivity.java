package com.example.camelometer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CamelActivity extends  AppCompatActivity{

    public void calculateWeight(View view) {

        //Get the initial values as decimalNumbers
        EditText heightWithers = (EditText) findViewById(R.id.heightWithers);
        EditText chestGirth = (EditText) findViewById(R.id.chestGirth);
        EditText humpGirth = (EditText) findViewById(R.id.humpGirth);


        //Converts to String, then Converts to Double (HEIGHT WITHERS)
        String heightWithersString = heightWithers.getText().toString();
        Double heightWithersDouble = 0.0;

        //Converts to String, then Converts to Double (CHEST GIRTH)
        String chestGirthString = chestGirth.getText().toString();
        Double chestGirthDouble = 0.0;

        //Converts to String, then Converts to Double (HUMP GIRTH)
        String humpGirthString = humpGirth.getText().toString();
        Double humpGirthDouble = 0.0;


        //Make sure all fields filled before calculating
        boolean canCalculate = true;

        if (TextUtils.isEmpty(heightWithersString)) {
            canCalculate = false;
            heightWithers.setError(getString(R.string.requiredField));
            //Toast withersEmptyToast = Toast.makeText(this,"Add Height Withers",Toast.LENGTH_SHORT);
            //withersEmptyToast.show();
        } else {
            Log.i("Heads Up", "Has a value");
            heightWithersDouble = Double.parseDouble(heightWithersString);
        }

        if (TextUtils.isEmpty(chestGirthString)) {
            canCalculate = false;
            chestGirth.setError(getString(R.string.requiredField));
            //Toast chestEmptyToast = Toast.makeText(this,"Add Chest Girth",Toast.LENGTH_SHORT);
            //chestEmptyToast.show();
        } else {
            Log.i("Heads Up", "Has a value");
            heightWithersDouble = Double.parseDouble(chestGirthString);
        }

        if (TextUtils.isEmpty(humpGirthString)) {
            canCalculate = false;
            humpGirth.setError(getString(R.string.requiredField));
            //Toast humpEmptyToast = Toast.makeText(this,"Add Hump Girth",Toast.LENGTH_SHORT);
            //humpEmptyToast.show();
        } else {
            Log.i("Heads Up", "Has a value");
            heightWithersDouble = Double.parseDouble(humpGirthString);
        }


        if (canCalculate) {
            // Add All Animal Dimensions
            Double finalWeightDouble = (heightWithersDouble + chestGirthDouble + humpGirthDouble);

            //Animal dimension to the power of 3.17
            Double finalWeightDoublePow = Math.pow(finalWeightDouble, 3.17);

            //product of FinalWeightDoublePow and 6.46 X 10 to the -7
            Double finalWeightDoublePowWow = finalWeightDoublePow * 0.000000646;

            //round to two decimal places
            DecimalFormat numberFormat = new DecimalFormat("#.00");

            //Convert number back to String
            String finalWeightString = numberFormat.format(finalWeightDoublePowWow);

            //Log number in Log Cat
            Log.i( "Entered Value", numberFormat.format(finalWeightDoublePowWow));

            //Change the value of the finalWeight TextView to the final number
            final TextView textViewToChange = (TextView) findViewById(R.id.finalWeight);
            textViewToChange.setText(finalWeightString + " " + getString(R.string.kilogram));
        } else {

            Log.i("Heads Up", "Could not calculate");
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camel);


        //Hide the stupid bar on the top the shows the name of the app
        getSupportActionBar().hide();
    }
}
