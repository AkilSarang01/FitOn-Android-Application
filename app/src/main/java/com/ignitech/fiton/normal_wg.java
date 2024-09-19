package com.ignitech.fiton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class normal_wg extends AppCompatActivity {

    ImageView veg,nonveg;
    Button exc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_wg);
        veg=findViewById(R.id.veg);
        nonveg=findViewById(R.id.nonveg);
        exc=findViewById(R.id.exc);

        veg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent veg = new Intent(normal_wg.this,normal_wg.class);
                startActivity(veg);
                finish();
            }
        });
        nonveg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nonveg = new Intent(normal_wg.this,nonveg_normal_weight.class);
                startActivity(nonveg);
                finish();
            }
        });
        exc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exc = new Intent(normal_wg.this,exercise.class);
                startActivity(exc);
            }
        });

    }
}