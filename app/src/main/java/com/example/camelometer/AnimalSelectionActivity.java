package com.example.camelometer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AnimalSelectionActivity extends  AppCompatActivity{

    Intent animalToEstiamte;

    public void selectAnimal(View view) {
        if (view.getTag().toString().equals("camel")){
            animalToEstiamte = new Intent(AnimalSelectionActivity.this,CamelActivity.class);

        }


        AnimalSelectionActivity.this.startActivity(animalToEstiamte);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_selection);


        //Hide the stupid bar on the top the shows the name of the app
        getSupportActionBar().hide();
    }
}
