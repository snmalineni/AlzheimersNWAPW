package com.sneha.newalzheimersapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Homepage extends AppCompatActivity {

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
}
