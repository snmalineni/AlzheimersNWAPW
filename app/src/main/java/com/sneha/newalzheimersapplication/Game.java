package com.sneha.newalzheimersapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
    private TextView myName;
    private Button btnStart;
    private String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        myName = (TextView) findViewById(R.id.myName);
        btnA = (Button) findViewById(R.id.A);
        btnB = (Button) findViewById(R.id.B);
        btnC = (Button) findViewById(R.id.C);
        btnD = (Button) findViewById(R.id.D);
        btnStart = (Button) findViewById(R.id.btnStart);

        myName.setVisibility(View.GONE);
        btnA.setVisibility(View.GONE);
        btnB.setVisibility(View.GONE);
        btnC.setVisibility(View.GONE);
        btnD.setVisibility(View.GONE);
    }


    public void startGame(View v){
        btnStart.setVisibility(View.GONE);
        myName.setVisibility(View.VISIBLE);
        btnA.setVisibility(View.VISIBLE);
        btnB.setVisibility(View.VISIBLE);
        btnC.setVisibility(View.VISIBLE);
        btnD.setVisibility(View.VISIBLE);

        Uri displayUri;
        ArrayList<String> abcd = new ArrayList<>(4);
        ArrayList<cappedPhoto> photoArShuffled = new ArrayList<>(Homepage.photoAr.size());

        for (int i=0; i<Homepage.photoAr.size(); i++) photoArShuffled.add(i, Homepage.photoAr.get(i));
        Collections.shuffle(photoArShuffled);
        //puts contents of photoAr into photoArShuffled in random order

        System.out.println("------reg list------"); //DELETE
        for (int j=0; j<Homepage.photoAr.size(); j++) System.out.println(Homepage.photoAr.get(j).getCap()); //DELETE
        System.out.println("------shuffled list------"); //DELETE
        for (int j=0; j<4; j++) System.out.println(photoArShuffled.get(j).getCap()); //DELETE

        Question q1 = new Question(photoArShuffled.get(0));
        //declares a question with a random cappedPhoto

        displayUri = q1.getimgUri();
        answer = q1.getans();
        //sets image URI to random cappedPhoto's URI; records correct answer

        abcd.add(q1.getopta());
        abcd.add(q1.getoptb());
        abcd.add(q1.getoptc());
        abcd.add(q1.getans());
        //adds three random strings and one correct string to abcd

        Collections.shuffle(abcd);
        //shuffles abcd

        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.activity_game);
        remoteViews.setTextViewText(R.id.A, abcd.get(0));
        remoteViews.setTextViewText(R.id.B, abcd.get(1));
        remoteViews.setTextViewText(R.id.C, abcd.get(2));
        remoteViews.setTextViewText(R.id.D, abcd.get(3));

        try {
            Bitmap thumbnail2 = Library.getThumbnail(displayUri,this);
            imgView.setImageBitmap(thumbnail2);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //sets imageview to image URI and text on answer buttons to 4 answers in random order
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
