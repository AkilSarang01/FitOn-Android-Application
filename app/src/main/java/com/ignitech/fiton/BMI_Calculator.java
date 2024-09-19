package com.ignitech.fiton;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class BMI_Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);
        Spinner sp1;
        final EditText e1 = (EditText) findViewById(R.id.et1);
        final EditText e2 = (EditText) findViewById(R.id.et2);
        final TextView tv4 = (TextView) findViewById(R.id.tv4);

        findViewById(R.id.ib1).setOnClickListener(new View.OnClickListener() {

            // Logic for validation, input can't be empty
            @Override
            public void onClick(View v) {

                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();

                if (TextUtils.isEmpty(str1)) {
                    e1.setError("Please enter your weight");
                    e1.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(str2)) {
                    e2.setError("Please enter your height");
                    e2.requestFocus();
                    return;
                }

//Get the user values from the widget reference
                float weight = Float.parseFloat(str1);
                float height = Float.parseFloat(str2) / 100;

//Calculate BMI value
                float bmiValue = calculateBMI(weight, height);

//Define the meaning of the bmi value
                String bmiInterpretation = interpretBMI(bmiValue);

                tv4.setText(bmiValue + "-" + bmiInterpretation);

            }
        });
        //get the spinner from the xml.
        Spinner dropdown = findViewById(R.id.sp1);
        //create a list of items for the spinner.
        String[] items = new String[]{"18-24", "25-40", "41-60"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
    }

    //Calculate BMI
    private float calculateBMI(float weight, float height) {
        return (float) (weight / (height * height));
    }

    // Interpret what BMI means
    private String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Severely Underweight Go And Eat Something Man!!!";
        } else if (bmiValue >16 && bmiValue < 18.5) {
            Intent abc = new Intent(BMI_Calculator.this, Under_Weight.class);
            startActivity(abc);
            return "Underweight";
        } else if (bmiValue > 18.5 && bmiValue < 25.0) {
            Intent abc = new Intent(BMI_Calculator.this,normal_wg.class);
            startActivity(abc);
            return "Normalweight";
        } else if (bmiValue > 25.0) {
            Intent abc = new Intent(BMI_Calculator.this,Over_Weight.class);
            startActivity(abc);
            return "Overweight";
        }
        return null;
    }
}