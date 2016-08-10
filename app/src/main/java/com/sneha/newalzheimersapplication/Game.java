package com.sneha.newalzheimersapplication;

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

    private ImageView imgView;
    private Button btnA;
    private Button btnB;
    private Button btnC;
    private Button btnD;
    private Button btnStart;
    private String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView myName = (TextView) findViewById(R.id.myName);
        btnA = (Button) findViewById(R.id.A);
        btnB = (Button) findViewById(R.id.B);
        btnC = (Button) findViewById(R.id.C);
        btnD = (Button) findViewById(R.id.D);

        myName.setVisibility(View.GONE);
        btnA.setVisibility(View.GONE);
        btnB.setVisibility(View.GONE);
        btnC.setVisibility(View.GONE);
        btnD.setVisibility(View.GONE);
    }


    public void startGame(View v){
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setVisibility(View.GONE);
        Uri displayUri;

        ArrayList<String> abcd = new ArrayList<>(Homepage.photoAr.size());

        ArrayList<cappedPhoto> arList = new ArrayList<>();
        for (int i=0; i<Homepage.photoAr.size(); i++) arList.add(i, Homepage.photoAr.get(i));
        Collections.shuffle(arList);

        System.out.println("------reg list------");
        for (int j=0; j<4; j++) System.out.println(Homepage.photoAr.get(j).getCap());

        System.out.println("------shuffled list------");
        for (int j=0; j<4; j++) System.out.println(arList.get(j).getCap());

        Question q1 = new Question(arList.get(0));

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
        imgView.setImageURI(displayUri);
    }

    public void clickA(View view) {
        if (answer == btnA.getText()) {
            btnA.setBackgroundResource(R.drawable.green);
            Toast.makeText(getApplicationContext() , "Correct!", Toast.LENGTH_SHORT).show();
        }
        else {
            btnA.setBackgroundResource(R.drawable.red);
            Toast.makeText(getApplicationContext() , "Try Again!", Toast.LENGTH_SHORT).show();
        }
    }
    public void clickB(View view) {
        if (answer == btnB.getText()) {
            btnB.setBackgroundResource(R.drawable.green);
            Toast.makeText(getApplicationContext() , "Correct!", Toast.LENGTH_SHORT).show();        }
        else {
            btnB.setBackgroundResource(R.drawable.red);
            Toast.makeText(getApplicationContext() , "Try Again!", Toast.LENGTH_SHORT).show();
        }
    }
    public void clickC(View view) {
        if (answer == btnC.getText()) {
            btnC.setBackgroundResource(R.drawable.green);
            Toast.makeText(getApplicationContext() , "Correct!", Toast.LENGTH_SHORT).show();        }
        else {
            btnC.setBackgroundResource(R.drawable.red);
            Toast.makeText(getApplicationContext() , "Try Again!", Toast.LENGTH_SHORT).show();
        }
    }
    public void clickD(View view) {
        if (answer == btnD.getText()) {
            btnD.setBackgroundResource(R.drawable.green);
            Toast.makeText(getApplicationContext() , "Correct!", Toast.LENGTH_SHORT).show();        }
        else {
            btnD.setBackgroundResource(R.drawable.red);
            Toast.makeText(getApplicationContext() , "Try Again!", Toast.LENGTH_SHORT).show();
        }
    }

}
