package com.example.camelometer;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CattleActivity  extends  AppCompatActivity{

    TextView heartGirthOnlyWarningTextView;
    TextView heartGirthTextView;
    TextView bodyLengthTextView;
    TextView finalWeightTextView;
    CheckBox domesticCheckBox;
    CheckBox importCheckBox;

    String heartGirthString;
    String bodyLengthString;


    public void checkBoxToggle(View view){

        String tag = view.getTag().toString();

        if (tag.equals("import")) {
            domesticCheckBox.setChecked(false);
        }
        if (tag.equals("domestic")){
            importCheckBox.setChecked(false);
        }
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

        //Initiate checkBoxes
        domesticCheckBox = (CheckBox) findViewById(R.id.domesticCheckBox);
        domesticCheckBox.setChecked(false);
        importCheckBox = (CheckBox) findViewById(R.id.domesticCheckBox);
        importCheckBox.setChecked(false);

        //Hide the stupid bar on the top the shows the name of the app
        getSupportActionBar().hide();
    }
}
