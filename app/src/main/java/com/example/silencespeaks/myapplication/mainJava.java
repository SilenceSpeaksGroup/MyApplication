package com.example.silencespeaks.myapplication;



        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;

public class mainJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addBtn = (Button) findViewById(R.id.btnEn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToinstructions();
            }
        });
    }
    private void goToinstructions() {
        Intent intent = new Intent(this, instruction.class);
        startActivity(intent);
    }
}

