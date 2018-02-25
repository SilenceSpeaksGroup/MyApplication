package com.example.silencespeaks.myapplication;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class EnglishModes extends AppCompatActivity {


    private Button mode1;
    private Button mode2;
    private Button mode3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modes);

        mode1 = findViewById(R.id.btnMode1);
        mode1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMode(new Intent(getBaseContext(), Results_activity.class));
            }
        });
        mode2 = findViewById(R.id.btnMode2);
        mode2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMode(new Intent(getBaseContext(), mode2.class));
            }
        });
        mode3 = findViewById(R.id.btnMode3);
        mode3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMode(new Intent(getBaseContext(), mode3.class));
            }
        });
    }

    private void goToMode(Intent i) {
        startActivity(i);
        this.finish();
    }
}

