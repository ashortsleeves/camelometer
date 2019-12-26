package com.example.camelometer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AnimalSelectionActivity extends  AppCompatActivity{

    Intent animalToEstiamte;

    public void selectAnimal(View view) {
        String animalFromTag = view.getTag().toString();


        if (animalFromTag.equals("camel")){
            animalToEstiamte = new Intent(AnimalSelectionActivity.this,CamelActivity.class);
        } else if (animalFromTag.equals("goat")){
            animalToEstiamte = new Intent(AnimalSelectionActivity.this,GoatActivity.class);
        } else if (animalFromTag.equals("cattle")){
            animalToEstiamte = new Intent(AnimalSelectionActivity.this,CattleActivity.class);
        } else if (animalFromTag.equals("donkey")){
            animalToEstiamte = new Intent(AnimalSelectionActivity.this,DonkeyActivity.class);
        } else if (animalFromTag.equals("horse")){
            animalToEstiamte = new Intent(AnimalSelectionActivity.this,MainActivity.class);
        }

        Log.i("Animal Selection", animalFromTag);


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
