package com.example.camelometer;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.HashMap;

public class CattleActivity  extends  AppCompatActivity{

    TextView heartGirthOnlyWarningTextView;
    TextView heartGirthTextView;
    TextView bodyLengthTextView;
    TextView finalWeightTextView;

    RadioButton domesticCattleRadioButton;
    RadioButton importCattleRadioButton;

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

                heartGirthDouble = Double.parseDouble(heartGirthString);

                int hearthGirthRoundedInt = (int) Math.rint(heartGirthDouble);

                if (hearthGirthRoundedInt < 66 || hearthGirthRoundedInt > 196) {

                    Toast.makeText(this, "Unable to calculate. Enter a body length and try again.", Toast.LENGTH_LONG).show();

                    bodyLengthTextView.setError("Required Field");

                } else {

                    String finalWeightString = findWeightFromChart(hearthGirthRoundedInt);

                    finalWeightTextView.setText(finalWeightString);

                    heartGirthOnlyWarningTextView.setVisibility(View.VISIBLE);
                }


            } else {

                heartGirthDouble = Double.parseDouble(heartGirthString);

                bodyLengthDouble = Double.parseDouble(bodyLengthString);

                double finalWeightDouble = (Math.pow(heartGirthDouble,2.0) * bodyLengthDouble) / 10840;

                displayFinalWeight(finalWeightDouble);



            }
        }

    }


    public String findWeightFromChart(int hearthGirthRoundedInt){

        HashMap<String, String> cattleWeightChart = new HashMap<String, String>();

        if (importCattleRadioButton.isChecked()) {

            cattleWeightChart.put("66","37");
            cattleWeightChart.put("67","37 – 38");
            cattleWeightChart.put("68","37 – 38");
            cattleWeightChart.put("69","38");
            cattleWeightChart.put("70","38 – 41");
            cattleWeightChart.put("71","38 – 41");
            cattleWeightChart.put("72","38 – 41");
            cattleWeightChart.put("73","38 – 41");
            cattleWeightChart.put("74","44");
            cattleWeightChart.put("75","44 – 46");
            cattleWeightChart.put("76","46");
            cattleWeightChart.put("77","46 – 49");
            cattleWeightChart.put("78","46 – 49");
            cattleWeightChart.put("79","49");
            cattleWeightChart.put("80","49 – 54");
            cattleWeightChart.put("81","54");
            cattleWeightChart.put("82","54 – 58");
            cattleWeightChart.put("83","54 – 58");
            cattleWeightChart.put("84","58");
            cattleWeightChart.put("85","58 – 63");
            cattleWeightChart.put("86","63");
            cattleWeightChart.put("87","63 – 67");
            cattleWeightChart.put("88","63 – 67");
            cattleWeightChart.put("89","67");
            cattleWeightChart.put("90","67 – 72");
            cattleWeightChart.put("91","72");
            cattleWeightChart.put("92","72 – 77");
            cattleWeightChart.put("93","72 – 77");
            cattleWeightChart.put("94","77");
            cattleWeightChart.put("95","77 – 82");
            cattleWeightChart.put("96","82");
            cattleWeightChart.put("97","82 – 87");
            cattleWeightChart.put("98","82 – 87");
            cattleWeightChart.put("99","87");
            cattleWeightChart.put("100","87 – 95");
            cattleWeightChart.put("101","87 – 95");
            cattleWeightChart.put("102","95");
            cattleWeightChart.put("103","95 – 102");
            cattleWeightChart.put("104","102");
            cattleWeightChart.put("105","102 – 109");
            cattleWeightChart.put("106","102 – 109");
            cattleWeightChart.put("107","109");
            cattleWeightChart.put("108","109 – 117");
            cattleWeightChart.put("109","117");
            cattleWeightChart.put("110","117 – 125");
            cattleWeightChart.put("111","117 – 125");
            cattleWeightChart.put("112","125");
            cattleWeightChart.put("113","125 – 134");
            cattleWeightChart.put("114","134");
            cattleWeightChart.put("115","134 – 143");
            cattleWeightChart.put("116","134 – 143");
            cattleWeightChart.put("117","143");
            cattleWeightChart.put("118","143 – 152");
            cattleWeightChart.put("119","152");
            cattleWeightChart.put("120","152 – 161");
            cattleWeightChart.put("121","152 – 161");
            cattleWeightChart.put("122","161");
            cattleWeightChart.put("123","161 – 170");
            cattleWeightChart.put("124","170");
            cattleWeightChart.put("125","170 – 179");
            cattleWeightChart.put("126","170 – 179");
            cattleWeightChart.put("127","179");
            cattleWeightChart.put("128","179 – 189");
            cattleWeightChart.put("129","179 – 189");
            cattleWeightChart.put("130","189");
            cattleWeightChart.put("131","189 – 197");
            cattleWeightChart.put("132","197");
            cattleWeightChart.put("133","197 – 207");
            cattleWeightChart.put("134","197 – 207");
            cattleWeightChart.put("135","207");
            cattleWeightChart.put("136","207 – 217");
            cattleWeightChart.put("137","217");
            cattleWeightChart.put("138","217 – 227");
            cattleWeightChart.put("139","217 – 227");
            cattleWeightChart.put("140","227");
            cattleWeightChart.put("141","227 – 239");
            cattleWeightChart.put("142","239");
            cattleWeightChart.put("143","239 – 251");
            cattleWeightChart.put("144","239 – 251");
            cattleWeightChart.put("145","251");
            cattleWeightChart.put("146","251 – 263");
            cattleWeightChart.put("147","263");
            cattleWeightChart.put("148","263 – 276");
            cattleWeightChart.put("149","263 – 276");
            cattleWeightChart.put("150","276");
            cattleWeightChart.put("151","276 – 289");
            cattleWeightChart.put("152","289");
            cattleWeightChart.put("153","289 – 303");
            cattleWeightChart.put("154","289 – 303");
            cattleWeightChart.put("155","303");
            cattleWeightChart.put("156","303 – 318");
            cattleWeightChart.put("157","318");
            cattleWeightChart.put("158","318 – 332");
            cattleWeightChart.put("159","318 – 332");
            cattleWeightChart.put("160","332");
            cattleWeightChart.put("161","332 – 348");
            cattleWeightChart.put("162","332 – 348");
            cattleWeightChart.put("163","348");
            cattleWeightChart.put("164","348 – 363");
            cattleWeightChart.put("165","363");
            cattleWeightChart.put("166","363 – 379");
            cattleWeightChart.put("167","363 – 379");
            cattleWeightChart.put("168","379");
            cattleWeightChart.put("169","379 – 395");
            cattleWeightChart.put("170","395");
            cattleWeightChart.put("171","395 – 412");
            cattleWeightChart.put("172","395 – 412");
            cattleWeightChart.put("173","412");
            cattleWeightChart.put("174","412 – 430");
            cattleWeightChart.put("175","430");
            cattleWeightChart.put("176","430 – 466");
            cattleWeightChart.put("177","430 – 466");
            cattleWeightChart.put("178","430 – 466");
            cattleWeightChart.put("179","430 – 466");
            cattleWeightChart.put("180","466");
            cattleWeightChart.put("181","463 – 485");
            cattleWeightChart.put("182","463 – 485");
            cattleWeightChart.put("183","485");
            cattleWeightChart.put("184","485 – 504");
            cattleWeightChart.put("185","504");
            cattleWeightChart.put("186","504 – 543");
            cattleWeightChart.put("187","504 – 543");
            cattleWeightChart.put("188","504 – 543");
            cattleWeightChart.put("189","504 – 543");
            cattleWeightChart.put("190","504 – 543");
            cattleWeightChart.put("191","543");
            cattleWeightChart.put("192","543 – 563");
            cattleWeightChart.put("193","563");
            cattleWeightChart.put("194","563 – 583");
            cattleWeightChart.put("195","563 – 583");
            cattleWeightChart.put("196","583");

        } else {

            cattleWeightChart.put("66","27");
            cattleWeightChart.put("67","27 – 30");
            cattleWeightChart.put("68","27 – 30");
            cattleWeightChart.put("69","30");
            cattleWeightChart.put("70","30 – 33");
            cattleWeightChart.put("71","33");
            cattleWeightChart.put("72","33 – 37");
            cattleWeightChart.put("73","33 – 37");
            cattleWeightChart.put("74","37");
            cattleWeightChart.put("75","37 – 40");
            cattleWeightChart.put("76","40");
            cattleWeightChart.put("77","40 – 44");
            cattleWeightChart.put("78","40 – 44");
            cattleWeightChart.put("79","44");
            cattleWeightChart.put("80","44 – 47");
            cattleWeightChart.put("81","47");
            cattleWeightChart.put("82","47 – 52");
            cattleWeightChart.put("83","47 – 52");
            cattleWeightChart.put("84","52");
            cattleWeightChart.put("85","52 – 57");
            cattleWeightChart.put("86","57");
            cattleWeightChart.put("87","57 – 62");
            cattleWeightChart.put("88","57 – 62");
            cattleWeightChart.put("89","62");
            cattleWeightChart.put("90","62 – 67");
            cattleWeightChart.put("91","67");
            cattleWeightChart.put("92","67 – 72");
            cattleWeightChart.put("93","67 – 72");
            cattleWeightChart.put("94","72");
            cattleWeightChart.put("95","72 – 78");
            cattleWeightChart.put("96","78");
            cattleWeightChart.put("97","78 – 84");
            cattleWeightChart.put("98","78 – 84");
            cattleWeightChart.put("99","84");
            cattleWeightChart.put("100","84 – 91");
            cattleWeightChart.put("101","84 – 91");
            cattleWeightChart.put("102","91");
            cattleWeightChart.put("103","91 – 97");
            cattleWeightChart.put("104","97");
            cattleWeightChart.put("105","97 – 103");
            cattleWeightChart.put("106","97 – 103");
            cattleWeightChart.put("107","103");
            cattleWeightChart.put("108","103 – 110");
            cattleWeightChart.put("109","110");
            cattleWeightChart.put("110","110 – 118");
            cattleWeightChart.put("111","110 – 118");
            cattleWeightChart.put("112","118");
            cattleWeightChart.put("113","118 – 125");
            cattleWeightChart.put("114","125");
            cattleWeightChart.put("115","125 – 134");
            cattleWeightChart.put("116","125 – 134");
            cattleWeightChart.put("117","134");
            cattleWeightChart.put("118","134 – 143");
            cattleWeightChart.put("119","143");
            cattleWeightChart.put("120","143 – 152");
            cattleWeightChart.put("121","143 – 152");
            cattleWeightChart.put("122","152");
            cattleWeightChart.put("123","152 – 160");
            cattleWeightChart.put("124","160");
            cattleWeightChart.put("125","160 – 170");
            cattleWeightChart.put("126","160 – 170");
            cattleWeightChart.put("127","170");
            cattleWeightChart.put("128","170 – 179");
            cattleWeightChart.put("129","170 – 179");
            cattleWeightChart.put("130","179");
            cattleWeightChart.put("131","179 – 189");
            cattleWeightChart.put("132","189");
            cattleWeightChart.put("133","189 – 200");
            cattleWeightChart.put("134","189 – 200");
            cattleWeightChart.put("135","200");
            cattleWeightChart.put("136","200 – 210");
            cattleWeightChart.put("137","210");
            cattleWeightChart.put("138","210 – 220");
            cattleWeightChart.put("139","210 – 220");
            cattleWeightChart.put("140","220");
            cattleWeightChart.put("141","220 – 234");
            cattleWeightChart.put("142","234");
            cattleWeightChart.put("143","234 – 246");
            cattleWeightChart.put("144","234 – 246");
            cattleWeightChart.put("145","246");
            cattleWeightChart.put("146","246 – 258");
            cattleWeightChart.put("147","258");
            cattleWeightChart.put("148","258 – 271");
            cattleWeightChart.put("149","258 – 271");
            cattleWeightChart.put("150","271");
            cattleWeightChart.put("151","271 – 284");
            cattleWeightChart.put("152","284");
            cattleWeightChart.put("153","284 – 312");
            cattleWeightChart.put("154","284 – 312");
            cattleWeightChart.put("155","284 – 312");
            cattleWeightChart.put("156","284 – 312");
            cattleWeightChart.put("157","312");
            cattleWeightChart.put("158","312 – 327");
            cattleWeightChart.put("159","312 – 327");
            cattleWeightChart.put("160","327");
            cattleWeightChart.put("161","327 – 341");
            cattleWeightChart.put("162","327 – 341");
            cattleWeightChart.put("163","341");
            cattleWeightChart.put("164","341 – 357");
            cattleWeightChart.put("165","357");
            cattleWeightChart.put("166","357 – 372");
            cattleWeightChart.put("167","357 – 372");
            cattleWeightChart.put("168","372");
            cattleWeightChart.put("169","372 – 389");
            cattleWeightChart.put("170","389");
            cattleWeightChart.put("171","389 – 405");
            cattleWeightChart.put("172","389 – 405");
            cattleWeightChart.put("173","405");
            cattleWeightChart.put("174","405 – 421");
            cattleWeightChart.put("175","421");
            cattleWeightChart.put("176","421 – 457");
            cattleWeightChart.put("177","421 – 457");
            cattleWeightChart.put("178","421 – 457");
            cattleWeightChart.put("179","421 – 457");
            cattleWeightChart.put("180","457");
            cattleWeightChart.put("181","457 – 476");
            cattleWeightChart.put("182","457 – 476");
            cattleWeightChart.put("183","476");
            cattleWeightChart.put("184","476 – 496");
            cattleWeightChart.put("185","496");
            cattleWeightChart.put("186","496 – 535");
            cattleWeightChart.put("187","496 – 535");
            cattleWeightChart.put("188","496 – 535");
            cattleWeightChart.put("189","496 – 535");
            cattleWeightChart.put("190","496 – 535");
            cattleWeightChart.put("191","535");
            cattleWeightChart.put("192","535 – 555");
            cattleWeightChart.put("193","555");
            cattleWeightChart.put("194","555 – 576");
            cattleWeightChart.put("195","555 – 576");
            cattleWeightChart.put("196","576");

        }


        String weightFromChartString = cattleWeightChart.get(Integer.toString(hearthGirthRoundedInt));

        weightFromChartString+= " kg";

        return weightFromChartString;

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
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cattle);

        //Initiate and hide warning text view
        heartGirthOnlyWarningTextView = (TextView) findViewById(R.id.heartGirthOnlyWarning);
        heartGirthOnlyWarningTextView.setVisibility(View.INVISIBLE);

        //Initiate Text Views
        heartGirthTextView = (TextView) findViewById(R.id.heartGirth);
        bodyLengthTextView = (TextView) findViewById(R.id.bodyLength);
        finalWeightTextView = (TextView) findViewById(R.id.finalWeight);

        //Initiate Radio Butotns
        domesticCattleRadioButton = findViewById(R.id.domesticCattleRadioButton);
        importCattleRadioButton = findViewById(R.id.importCattleRadioButton);


        //Hide the stupid bar on the top the shows the name of the app
        getSupportActionBar().hide();
    }
}
