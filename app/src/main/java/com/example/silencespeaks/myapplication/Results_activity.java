package com.example.silencespeaks.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.speech.tts.TextToSpeech.OnInitListener;

import java.util.Locale;

public class Results_activity extends AppCompatActivity implements OnClickListener, OnInitListener {

private TextToSpeech myTTS;
private  int MY_DATA_CHECK_CODE=0;

    @Override
    public void onClick(View view) {
        EditText enterText = (EditText) findViewById(R.id.textView);
        String words= enterText.getText().toString();
        speakWords(words);

    }
    private void speakWords(String speech){
        myTTS.speak(speech,TextToSpeech.QUEUE_FLUSH,null);
    }
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ImageButton speakButton = (ImageButton) findViewById(R.id.imageButton3);
       speakButton.setOnClickListener(this);

       Intent checkTTSIntent = new Intent();
       checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
       startActivityForResult(checkTTSIntent,MY_DATA_CHECK_CODE);
        Button adddBtn = (Button) findViewById(R.id.Back);
        adddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToEnglishModes();
            }
        });
    }
    private void goToEnglishModes() {
        Intent intent = new Intent(this, EnglishModes.class);
        startActivity(intent);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == MY_DATA_CHECK_CODE){
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                myTTS = new TextToSpeech(this, this);

            }
            else{
                Intent installTTSIntent = new Intent();
                installTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
                startActivity(installTTSIntent);
            }
        }
    }

    public void onInit(int initStatus){
        if (initStatus == TextToSpeech.SUCCESS){
            if (myTTS.isLanguageAvailable(Locale.US) == TextToSpeech.LANG_AVAILABLE);
            myTTS.setLanguage(Locale.US);
        }else if (initStatus == TextToSpeech.ERROR){
            Toast.makeText(this, "Sorry! Text To Speech failed" , Toast.LENGTH_LONG).show();
        }
    }

}