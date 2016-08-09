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

import Source.cappedPhoto;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class MainActivity extends AppCompatActivity {
    private int PICK_IMAGE_REQUEST = 1;

    private Context context = this;
    private Uri selectedImageURI;


    cappedPhoto photoAr[] = new cappedPhoto[50];
    private Object myClassConstant;





    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void buttonDone(View v) {

        String inputText, photoStr;
        cappedPhoto newElement;

        EditText nameText = (EditText) findViewById(R.id.nameText);
        inputText = nameText.getText().toString();

        if(selectedImageURI != null) {
            photoStr = selectedImageURI.toString();
            //gets caption and uri
            newElement = new cappedPhoto(photoStr, inputText);
            Homepage.photoAr.add(newElement);
        }
        String file_name = "photocaptions";
        String name = null;
        int iteration = 0;

        try
        {
            FileOutputStream fileOutputStream = context.openFileOutput(file_name, Context.MODE_PRIVATE);
            File fileDir = new File(context.getFilesDir(), file_name);
            String name1 = fileDir.getAbsolutePath();
            //System.out.println("-------OUTPUT-------");
            //System.out.println(name1);

            ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
            os.writeObject(Homepage.photoAr);
            os.close();
            fileOutputStream.close();
            Toast.makeText(getApplicationContext() , "Photo and Name are saved", Toast.LENGTH_LONG).show();
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


    }



        /*try
        {
            FileInputStream fileInputStream = context.openFileInput(file_name);
            ObjectInputStream is = new ObjectInputStream(fileInputStream);

            Homepage.photoAr = (ArrayList<cappedPhoto>) is.readObject();
            is.close();
            fileInputStream.close();
            for (cappedPhoto cappedPhoto : Homepage.photoAr)
            {
                System.out.print(cappedPhoto.getCap() + " " + cappedPhoto.getUriString());
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }*/




    public void buttonSelect(View arg0) {
        EditText nameText = (EditText)findViewById(R.id.nameText);
        nameText.setText("", TextView.BufferType.EDITABLE);




        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setImageBitmap(null);

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
        //When upload photos button clicked goes into gallery and allows user to select
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

             selectedImageURI = data.getData();


            try {
                Bitmap thumbnail = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageURI);
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

    public void goHome(View view) {
        Intent intent = new Intent(this, Homepage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void goLib(View view) {
        Intent intent = new Intent(this, Library.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}



