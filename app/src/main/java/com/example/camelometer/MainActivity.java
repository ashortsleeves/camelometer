package com.example.camelometer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    public void calculateWeight(View view) {

        //Get the initial values as decimalNumbers
        EditText heightWithers = (EditText) findViewById(R.id.heightWithers);
        EditText chestGirth = (EditText) findViewById(R.id.chestGirth);
        EditText humpGirth = (EditText) findViewById(R.id.humpGirth);


        //Converts to String, then Converts to Double (HEIGHT WITHERS)
        String heightWithersString = heightWithers.getText().toString();
        Double heightWithersDouble = Double.parseDouble(heightWithersString);

        //Converts to String, then Converts to Double (CHEST GIRTH)
        String chestGirthString = chestGirth.getText().toString();
        Double chestGirthDouble = Double.parseDouble(chestGirthString);

        //Converts to String, then Converts to Double (HUMP GIRTH)
        String humpGirthString = humpGirth.getText().toString();
        Double humpGirthDouble = Double.parseDouble(humpGirthString);





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
        textViewToChange.setText(finalWeightString + "kg");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
