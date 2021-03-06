package com.sneha.newalzheimersapplication;

import android.content.Context;
import android.content.Intent;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
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
    private Button btnNextQuestion;
    private TextView myName;
    private Button btnStart;
    private String answer;
    private Context context = this;
    private ArrayList<cappedPhoto> photoArShuffled;
    private ArrayList<String> abcd;
    private int endGame = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        myName = (TextView) findViewById(R.id.myName);
        btnA = (Button) findViewById(R.id.A);
        btnB = (Button) findViewById(R.id.B);
        btnC = (Button) findViewById(R.id.C);
        btnD = (Button) findViewById(R.id.D);

        btnNextQuestion = (Button) findViewById(R.id.btnNext);

        btnStart = (Button) findViewById(R.id.btnStart);

        myName.setVisibility(View.GONE);
        btnA.setVisibility(View.GONE);
        btnB.setVisibility(View.GONE);
        btnC.setVisibility(View.GONE);
        btnD.setVisibility(View.GONE);
        btnNextQuestion.setVisibility(View.GONE);
    }

    public void startGame(View v){
        endGame = 0;
        String file_name = "photocaptions";
        String name = null;

        try {
            FileInputStream fileInputStream = context.openFileInput(file_name);
            File fileDir = new File(context.getFilesDir(), file_name);
            name = fileDir.getAbsolutePath();

            ObjectInputStream is = new ObjectInputStream(fileInputStream);

            Homepage.photoAr = (ArrayList<cappedPhoto>) is.readObject();
            is.close();
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } //fills homepage.photoAr with stored photos

        btnStart.setVisibility(View.GONE);
        myName.setVisibility(View.VISIBLE);
        btnA.setVisibility(View.VISIBLE);
        btnB.setVisibility(View.VISIBLE);
        btnC.setVisibility(View.VISIBLE);
        btnD.setVisibility(View.VISIBLE);
        btnNextQuestion.setVisibility(View.VISIBLE);

        Uri displayUri;
        abcd = new ArrayList<>();
        photoArShuffled = new ArrayList<>(Homepage.photoAr.size());

        for (int i=0; i<Homepage.photoAr.size(); i++) {
            photoArShuffled.add(Homepage.photoAr.get(i));
        }
        Collections.shuffle(photoArShuffled);
        //puts contents of photoAr into photoArShuffled in random order

        getNextQuestion();
    }

    public void getNextQuestion(){
        ImageView imgViewGame = (ImageView)findViewById(R.id.imgView);
        //Collections.shuffle(photoArShuffled);
        Uri displayUri;
        abcd = new ArrayList<>();

        if(endGame < photoArShuffled.size()) {
            Question q1 = new Question(photoArShuffled.get(endGame));
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

            btnA.setText(abcd.get(0));
            btnB.setText(abcd.get(1));
            btnC.setText(abcd.get(2));
            btnD.setText(abcd.get(3));

            InputStream inputPhotoAr;
            Bitmap game = null;
            try {
                inputPhotoAr = this.getContentResolver().openInputStream(displayUri);
                game = BitmapFactory.decodeStream(inputPhotoAr);
                game = Bitmap.createScaledBitmap(game, 275, 275, false);
            } catch (FileNotFoundException e2) {
                Toast.makeText(getApplicationContext(), "Error: Image Failed to Load", Toast.LENGTH_LONG).show();
            }
            imgViewGame.setImageBitmap(game);
            endGame++;
        } else {
            myName.setVisibility(View.GONE);
            btnA.setVisibility(View.GONE);
            btnB.setVisibility(View.GONE);
            btnC.setVisibility(View.GONE);
            btnD.setVisibility(View.GONE);
            btnNextQuestion.setVisibility(View.GONE);
            Button btnToHome = (Button) findViewById(R.id.btnToHome);
            Button btnStartAgain = (Button) findViewById(R.id.btnStartAgain);
            btnToHome.setVisibility(View.VISIBLE);
            btnStartAgain.setVisibility(View.VISIBLE);

            Toast.makeText(getApplicationContext(), "Good Job!", Toast.LENGTH_SHORT).show();
            imgViewGame.setImageBitmap(null);
        }
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
            Toast.makeText(getApplicationContext() , "Correct!", Toast.LENGTH_SHORT).show();
        }
        else {
            btnB.setBackgroundResource(R.drawable.red);
            Toast.makeText(getApplicationContext() , "Try Again!", Toast.LENGTH_SHORT).show();
        }
    }
    public void clickC(View view) {
        if (answer == btnC.getText()) {
            btnC.setBackgroundResource(R.drawable.green);
            Toast.makeText(getApplicationContext() , "Correct!", Toast.LENGTH_SHORT).show();
        }
        else {
            btnC.setBackgroundResource(R.drawable.red);
            Toast.makeText(getApplicationContext() , "Try Again!", Toast.LENGTH_SHORT).show();
        }
    }
    public void clickD(View view) {
        if (answer == btnD.getText()) {
            btnD.setBackgroundResource(R.drawable.green);
            Toast.makeText(getApplicationContext() , "Correct!", Toast.LENGTH_SHORT).show();
        }
        else {
            btnD.setBackgroundResource(R.drawable.red);
            Toast.makeText(getApplicationContext() , "Try Again!", Toast.LENGTH_SHORT).show();
        }
    }

    public void nextCardClicked(View v){
        btnA.setBackgroundResource(R.drawable.gray);
        btnB.setBackgroundResource(R.drawable.gray);
        btnC.setBackgroundResource(R.drawable.gray);
        btnD.setBackgroundResource(R.drawable.gray);
        getNextQuestion();
    }

    public void goHome(View view) {
        Intent intent = new Intent(this, Homepage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
