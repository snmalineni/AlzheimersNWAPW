package com.sneha.newalzheimersapplication;


import android.content.Context;
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

import Source.Serialization;
import Source.cappedPhoto;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public boolean newPhoto = true;
    private int PICK_IMAGE_REQUEST = 1;
    SharedPreferences sh_Pref;
    Editor toEdit;
    String inputText,photoStr;
    cappedPhoto newElement;
    Serialization captionphotos;
    public static String fileName = "photocaption.ser";
    Context context = this;



    ArrayList<cappedPhoto> photoAr = new ArrayList(50);
       public int arIndex = 0;



        @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);



        }



    public void buttonClick(View v) {
        EditText nameText = (EditText) findViewById(R.id.nameText);
        //Finds current status of text field when done button clicked
        inputText = nameText.getText().toString();
        //Takes input from text field and puts it into variable inputText
        photoStr = uri.toString();
        newElement = new cappedPhoto(photoStr, inputText);
        photoAr.add(newElement);
        String file_name = "photocaptions";

        try
        {
            FileOutputStream fileOutputStream = context.openFileOutput(file_name, Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
            os.writeObject(photoAr);
            os.close();
            fileOutputStream.close();
            Toast.makeText(getApplicationContext() , "Photo and Caption are saved", Toast.LENGTH_LONG).show();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            Toast.makeText(getApplicationContext() , "Error: Photo and caption were not saved", Toast.LENGTH_LONG).show();
            System.out.println("Error");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            Toast.makeText(getApplicationContext() , "Error: Photo and caption were not saved", Toast.LENGTH_LONG).show();
            System.out.println("Error");
        }


        try
        {
            FileInputStream fileInputStream = context.openFileInput(file_name);
            ObjectInputStream is = new ObjectInputStream(fileInputStream);

            photoAr = (ArrayList<cappedPhoto>) is.readObject();
            is.close();
            fileInputStream.close();
            for(int i = 0; i < photoAr.size(); i++) {
                System.out.println(photoAr.get(i).getCap() + " " + photoAr.get(i).getUriString());
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }



        //photoAr.add(newElement);
        //Creates an instance of cappedPhoto in the array
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



