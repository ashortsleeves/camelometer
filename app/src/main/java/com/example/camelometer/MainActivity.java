package com.example.camelometer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public void continueWithLanguage(View view) {
        String languageToUse = view.getTag().toString();



        if (languageToUse.equals("english")){
            Log.i("Info", "User chose ENGLISH");
            Log.i("TODO", "Store language selection while app is running");
        } else {
            Log.i("Info", "user chose ARABIC");
            Log.i("TODO", "Store language selection while app is running");
        }


        Intent animalSelectionPage = new Intent(MainActivity.this, CamelActivity.class);
        MainActivity.this.startActivity(animalSelectionPage);




    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
    }
}
