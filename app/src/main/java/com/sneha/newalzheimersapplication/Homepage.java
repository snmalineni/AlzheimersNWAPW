package com.sneha.newalzheimersapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import 	android.content.Intent;
import android.widget.Toast;


import java.util.ArrayList;

import Source.cappedPhoto;

public class Homepage extends AppCompatActivity {

    public static ArrayList<cappedPhoto> photoAr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }

    public void goInfo(View view) {
        Intent intent = new Intent(this, AlzInformation.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    } //when Alz Info button pressed, go to Alz Info page

    public void goHelp(View view) {
        Intent intent = new Intent(this, AlzHelp.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    } //when Emergency Help button pressed, go to Help page

    public void goTutorial(View view) {
        Intent intent = new Intent(this, Tutorial.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    } //when Tutorial button pressed, go to Tutorial page

    public void goLib(View view) {
        Intent intent = new Intent(this, Library.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    public void goUpload(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void goGame(View view) {
        if (Homepage.photoAr != null) {
            Intent intent = new Intent(this, Game.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext() , "Upload some images first!", Toast.LENGTH_LONG).show();
        }
    }
}
