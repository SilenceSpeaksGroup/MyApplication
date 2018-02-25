package com.example.silencespeaks.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mode3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mode3);
        Button adddBtn = (Button) findViewById(R.id.Back);
        adddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTomainJava();
            }
        });
        Button addBtn = (Button) findViewById(R.id.Done);
        addBtn.setOnClickListener(new View.OnClickListener() {
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
    private void goTomainJava() {
        Intent intent = new Intent(this, mainJava.class);
        startActivity(intent);
    }
}

