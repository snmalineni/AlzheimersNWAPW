package com.sneha.newalzheimersapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;

public class Game extends AppCompatActivity {

    private ImageView imgView = (ImageView) findViewById(R.id.imgView);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //grab the layout, then set the text of the Button called R.id.Counter:
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.activity_game);
        remoteViews.setTextViewText(R.id.A, "Set button text here");
    }

}
