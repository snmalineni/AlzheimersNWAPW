package com.sneha.newalzheimersapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import 	android.content.Intent;


import java.util.ArrayList;

import Source.cappedPhoto;

public class Homepage extends AppCompatActivity {

    public static ArrayList<cappedPhoto> photoAr = new ArrayList(50);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }

    public void goInfo(View view) {
        Intent intent = new Intent(this, AlzInformation.class);
        startActivity(intent);
    } //when Alz Info button pressed, go to Alz Info page

    public void goHelp(View view) {
        Intent intent = new Intent(this, AlzHelp.class);
        startActivity(intent);
    } //when Emergency Help button pressed, go to Help page

    public void goTutorial(View view) {
        Intent intent = new Intent(this, Tutorial.class);
        startActivity(intent);
    } //when Tutorial button pressed, go to Tutorial page

    public void goLib(View view) {
        Intent intent = new Intent(this, Library.class);
        startActivity(intent);
    }

}