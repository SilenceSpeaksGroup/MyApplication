package com.example.silencespeaks.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.view.View;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.speech.tts.TextToSpeech.OnInitListener;

import java.util.Locale;
import com.example.silencespeaks.myapplication.R;
import com.example.silencespeaks.myapplication.Results_activity;


public class MainActivity extends AppCompatActivity {
    private static final int CAMERA_PIC_REQUEST = ' ';

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton activateCameraBtn = (ImageButton) findViewById(R.id.Button01);
        activateCameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                (new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent myIntent = new Intent(MainActivity.this, Results_activity.class);
                        startActivityForResult(myIntent, 0);
                    }


                }, 5000);

                startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
                Button adddBtn = (Button) findViewById(R.id.Back);
                adddBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        goToEnglishModes();
                    }
                });
            }
        });
    }
    private void goToEnglishModes() {
        Intent intent = new Intent(this, EnglishModes.class);
        startActivity(intent);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_PIC_REQUEST) {
            if (data.getExtras() != null) {
                Bitmap image = (Bitmap) data.getExtras().get("data");
                ImageView imageview = (ImageView) findViewById(R.id.imageView5); //sets imageview as the bitmap
                imageview.setImageBitmap(image);
//            (new Handler()).postDelayed(this::MainActivity.finish(), 5000);
//                (new Handler()).postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        Intent myIntent = new Intent(MainActivity.this, Results_activity.class);
//                        startActivityForResult(myIntent, 0);
//                    }
//
//
//                }, 5000);
                Intent myIntent = new Intent(this, Results_activity.class);
                startActivityForResult(myIntent, 0);
            }
        }
    }

}




