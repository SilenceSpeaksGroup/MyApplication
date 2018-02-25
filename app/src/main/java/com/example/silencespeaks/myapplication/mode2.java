package com.example.silencespeaks.myapplication;


        import android.app.Activity;
        import android.os.Bundle;
        import android.view.View.OnClickListener;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.speech.tts.TextToSpeech;
        import android.speech.tts.TextToSpeech.OnInitListener;
        import android.content.Intent;
        import java.util.Locale;
        import android.widget.Toast;
        import android.widget.ImageButton;

/**
 * This is demo code to accompany the Mobiletuts+ tutorial:
 * Android SDK: Using the Text To Speech Engine
 *
 * Sue Smith
 * November 2011
 */

public class mode2 extends Activity implements OnClickListener, OnInitListener {

    //TTS object
    private TextToSpeech myTTS;
    //status check code
    private int MY_DATA_CHECK_CODE = 0;

    //create the Activity
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //get a reference to the button element listed in the XML layout
        ImageButton speakButton = (ImageButton) findViewById(R.id.imageButton2);
        //listen for clicks
        speakButton.setOnClickListener(this);

        //check for TTS data
        Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);
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
    //respond to button clicks
    public void onClick(View v) {

        //get the text entered
        TextView enteredText = (TextView)findViewById(R.id.textView2);
        String words = enteredText.getText().toString();
        speakWords(words);
    }

    //speak the user text
    private void speakWords(String speech) {

        //speak straight away
        myTTS.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
    }

    //act on result of TTS data check
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                //the user has the necessary data - create the TTS
                myTTS = new TextToSpeech(this, this);
            }
            else {
                //no data - install it now
                Intent installTTSIntent = new Intent();
                installTTSIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installTTSIntent);
            }
        }
    }

    //setup TTS
    public void onInit(int initStatus) {

        //check for successful instantiation
        if (initStatus == TextToSpeech.SUCCESS) {
            if(myTTS.isLanguageAvailable(Locale.US)==TextToSpeech.LANG_AVAILABLE)
                myTTS.setLanguage(Locale.US);
        }
        else if (initStatus == TextToSpeech.ERROR) {
            Toast.makeText(this, "Sorry! Text To Speech failed...", Toast.LENGTH_LONG).show();
        }
    }
}