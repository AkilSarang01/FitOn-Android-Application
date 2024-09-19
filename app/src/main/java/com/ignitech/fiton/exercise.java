package com.ignitech.fiton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class exercise extends AppCompatActivity {

    CardView stg,yoga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        stg=findViewById(R.id.card1);
        yoga=findViewById(R.id.card2);

        stg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stg = new Intent(exercise.this,strenght.class);
                startActivity(stg);
            }
        });

        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent yoga = new Intent(exercise.this,yoga.class);
                startActivity(yoga);
            }
        });
    }
}