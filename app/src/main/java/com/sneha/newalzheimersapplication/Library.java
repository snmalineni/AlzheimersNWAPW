package com.sneha.newalzheimersapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import Source.cappedPhoto;


public class Library extends AppCompatActivity {

    ArrayList<ImageView> librarylayout = new ArrayList<>();
    ArrayList<TextView> textlayouts = new ArrayList<>();
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);


        librarylayout.add((ImageView) findViewById(R.id.A1));
        librarylayout.add((ImageView) findViewById(R.id.A2));
        librarylayout.add((ImageView) findViewById(R.id.A3));
        librarylayout.add((ImageView) findViewById(R.id.B1));
        librarylayout.add((ImageView) findViewById(R.id.B2));
        librarylayout.add((ImageView) findViewById(R.id.B3));
        librarylayout.add((ImageView) findViewById(R.id.C1));
        librarylayout.add((ImageView) findViewById(R.id.C2));
        librarylayout.add((ImageView) findViewById(R.id.C3));
        librarylayout.add((ImageView) findViewById(R.id.D1));
        librarylayout.add((ImageView) findViewById(R.id.D2));
        librarylayout.add((ImageView) findViewById(R.id.D3));
        librarylayout.add((ImageView) findViewById(R.id.E1));
        librarylayout.add((ImageView) findViewById(R.id.E2));
        librarylayout.add((ImageView) findViewById(R.id.E3));

        textlayouts.add((TextView)findViewById(R.id.tA1));
        textlayouts.add((TextView)findViewById(R.id.tA2));
        textlayouts.add((TextView)findViewById(R.id.tA3));
        textlayouts.add((TextView)findViewById(R.id.tB1));
        textlayouts.add((TextView)findViewById(R.id.tB2));
        textlayouts.add((TextView)findViewById(R.id.tB3));
        textlayouts.add((TextView)findViewById(R.id.tC1));
        textlayouts.add((TextView)findViewById(R.id.tC2));
        textlayouts.add((TextView)findViewById(R.id.tC3));
        textlayouts.add((TextView)findViewById(R.id.tD1));
        textlayouts.add((TextView)findViewById(R.id.tD2));
        textlayouts.add((TextView)findViewById(R.id.tD3));
        textlayouts.add((TextView)findViewById(R.id.tE1));
        textlayouts.add((TextView)findViewById(R.id.tE2));
        textlayouts.add((TextView)findViewById(R.id.tE3));



    }

    protected void onResume(){
        super.onResume();
        //setContentView(R.layout.activity_library);
        String file_name = "photocaptions";
        String name = null;
        int iteration = 0;

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
        }


        for (cappedPhoto cP : Homepage.photoAr) {


            Uri imageUri = Uri.parse(cP.getUriString());
            String imageCaption = cP.getCap();
            ImageView imgView = (ImageView) (librarylayout.get(iteration));
            TextView txtView = (TextView) (textlayouts.get(iteration));

            try {


                Bitmap thumbnail2 = getThumbnail(imageUri,this);
                imgView.setImageBitmap(thumbnail2);
                txtView.setText(imageCaption);

            } catch (IOException e) {
                e.printStackTrace();
            }


            if (iteration <= 14) {
                iteration++;
            } else {
                Toast.makeText(getApplicationContext(), "Error: Ran out of storage", Toast.LENGTH_LONG).show();
            }



        }
    }



    public static Bitmap getThumbnail(Uri uri, AppCompatActivity context) throws FileNotFoundException, IOException
    {
        InputStream input = context.getContentResolver().openInputStream(uri);

        BitmapFactory.Options onlyBoundsOptions = new BitmapFactory.Options();
        onlyBoundsOptions.inJustDecodeBounds = true;
        //onlyBoundsOptions.inDither=true; //deprecated
        onlyBoundsOptions.inPreferredConfig=Bitmap.Config.ARGB_8888;//optional
        BitmapFactory.decodeStream(input, null, onlyBoundsOptions);
        input.close();
        if ((onlyBoundsOptions.outWidth == -1) || (onlyBoundsOptions.outHeight == -1))
            return null;

        int originalSize = (onlyBoundsOptions.outHeight > onlyBoundsOptions.outWidth) ? onlyBoundsOptions.outHeight : onlyBoundsOptions.outWidth;

        double ratio = (originalSize > 70) ? (originalSize / 250) : 1.0;

        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inSampleSize = getPowerOfTwoForSampleRatio(ratio);
        bitmapOptions.inDither=true;//optional
        bitmapOptions.inPreferredConfig=Bitmap.Config.ARGB_8888;//optional
        input = context.getContentResolver().openInputStream(uri);
        Bitmap bitmap = BitmapFactory.decodeStream(input, null, bitmapOptions);
        input.close();
        return bitmap;
    }

    private static int getPowerOfTwoForSampleRatio(double ratio){
        int k = Integer.highestOneBit((int)Math.floor(ratio));
        if(k==0) return 1;
        else return k;
    }


    public void toMain(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void goHome(View view) {
        Intent intent = new Intent(this, Homepage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void goGame(View view) {
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }

}
