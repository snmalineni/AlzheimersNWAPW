package com.sneha.newalzheimersapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import Source.cappedPhoto;


public class MainActivity extends AppCompatActivity {

    public boolean newPhoto = true;
    private int PICK_IMAGE_REQUEST = 1;

    cappedPhoto photoAr[] = new cappedPhoto[150];
    int arIndex = 0;

    @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

    public void buttonClick(View v) {
        EditText nameText = (EditText) findViewById(R.id.nameText);
        String inputText = nameText.getText().toString();
        //Takes input from text field and puts it into variable inputText
        String photoStr = uri.toString();
        photoAr[arIndex] = new cappedPhoto(photoStr, inputText);
        //Creates an instance of cappedPhoto in the array
        arIndex++;
        TextView tView = (TextView) findViewById(R.id.textView2);
        tView.setVisibility(View.VISIBLE);
    }

    public void onButtonClicked(View arg0) {
        EditText nameText = (EditText)findViewById(R.id.nameText);
        nameText.setText("", TextView.BufferType.EDITABLE);

        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setImageBitmap(null);
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
        //When upload photos button clicked goes into gallery and allows user to select
        TextView tView = (TextView) findViewById(R.id.textView2);
        tView.setVisibility(View.GONE);
    }

    Uri uri;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            uri = data.getData();


            try {
                Bitmap thumbnail = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                //Log.d(TAG, String.valueOf(bitmap));

                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                imageView.setImageBitmap(thumbnail);
                //Sets photo into imageView on screen
            } catch (Exception e) {
                e.printStackTrace();
                //Happens if photo is null
            }


        }
    }


}



