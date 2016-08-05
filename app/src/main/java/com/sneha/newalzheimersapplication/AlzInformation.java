package com.sneha.newalzheimersapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class AlzInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alz_information);
    }
    //Displays text objects giving basic info about alzheimier's

    public void goHome(View view) {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }
}
