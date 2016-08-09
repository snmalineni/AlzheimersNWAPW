package com.sneha.newalzheimersapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    private ImageView imgView = (ImageView) findViewById(R.id.imgView);
    private TextView myName = (TextView) findViewById(R.id.myName);
    private Button btnA = (Button) findViewById(R.id.A);
    private Button btnB = (Button) findViewById(R.id.B);
    private Button btnC = (Button) findViewById(R.id.C);
    private Button btnD = (Button) findViewById(R.id.D);
    private Button btnStart = (Button) findViewById(R.id.btnStart);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        myName.setVisibility(View.GONE);
        btnA.setVisibility(View.GONE);
        btnB.setVisibility(View.GONE);
        btnC.setVisibility(View.GONE);
        btnD.setVisibility(View.GONE);
    }


    public void startGame(View view){
        btnStart.setVisibility(View.GONE);

        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.activity_game);
        remoteViews.setTextViewText(R.id.A, "Set button text here");
    }
}
