package com.sneha.newalzheimersapplication;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import Source.Question;
import Source.cappedPhoto;

public class Game extends AppCompatActivity {

    private ImageView imgView = (ImageView) findViewById(R.id.imgView);
    private TextView myName = (TextView) findViewById(R.id.myName);
    private Button btnA = (Button) findViewById(R.id.A);
    private Button btnB = (Button) findViewById(R.id.B);
    private Button btnC = (Button) findViewById(R.id.C);
    private Button btnD = (Button) findViewById(R.id.D);
    private Button btnStart = (Button) findViewById(R.id.btnStart);
    private Question q1;
    private String answer;

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

        Uri displayUri;
        ArrayList<String> abcd = new ArrayList<>();

        ArrayList<cappedPhoto> arList = new ArrayList<>();
        for (int i=0; i<Homepage.photoAr.size(); i++) arList.set(i, Homepage.photoAr.get(i));
        Collections.shuffle(arList);

        q1 = new Question(arList.get(0));

        displayUri = q1.getimgUri();
        answer = q1.getans();

        abcd.add(q1.getopta());
        abcd.add(q1.getoptb());
        abcd.add(q1.getoptc());
        abcd.add(q1.getans());

        Collections.shuffle(abcd);

        String ans[] = new String[4];
        for (int i=0; i<4; i++) ans[i] = abcd.get(i);

        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.activity_game);
        remoteViews.setTextViewText(R.id.A, ans[0]);
        remoteViews.setTextViewText(R.id.B, ans[1]);
        remoteViews.setTextViewText(R.id.C, ans[2]);
        remoteViews.setTextViewText(R.id.D, ans[3]);
    }

    public void clickA(View view) {
        if (answer == btnA.getText()) {
            btnA.setBackgroundResource(R.drawable.green);
            //Toast.makeText();
        }
        else {
            btnA.setBackgroundResource(R.drawable.red);
        }
    }
    public void clickB(View view) {
        if (answer == btnB.getText()) {
            btnB.setBackgroundResource(R.drawable.green);
            //Toast.makeText();
        }
        else {
            btnB.setBackgroundResource(R.drawable.red);
        }
    }
    public void clickC(View view) {
        if (answer == btnC.getText()) {
            btnC.setBackgroundResource(R.drawable.green);
            //Toast.makeText();
        }
        else {
            btnC.setBackgroundResource(R.drawable.red);
        }
    }
    public void clickD(View view) {
        if (answer == btnD.getText()) {
            btnD.setBackgroundResource(R.drawable.green);
            //Toast.makeText();
        }
        else {
            btnD.setBackgroundResource(R.drawable.red);
        }
    }

}
