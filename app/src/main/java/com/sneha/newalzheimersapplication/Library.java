package com.sneha.newalzheimersapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;


public class Library extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        int numPhotos = 1;
        int numRows = numPhotos/3;
        if (numPhotos%3!=0) numRows++;
        TableRow tRow[] = new TableRow[numRows];
        TableLayout tLayout = (TableLayout) findViewById(R.id.tLayout);
        for (int k = 0; k < numRows; k++) {
            TableRow currentRow = tRow[k];
            tLayout.addView(currentRow);
            for (int i = 0; i < 3; i++) {
                ImageView image = new ImageView(Library.this);
                currentRow.addView(image);
                image.getLayoutParams().height = RelativeLayout.LayoutParams.WRAP_CONTENT;
            }
        }
    }
    public void toMain(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
