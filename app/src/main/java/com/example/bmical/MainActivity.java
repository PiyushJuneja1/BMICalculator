package com.example.bmical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtResult;
        EditText edtweight,edtheightFt,edtheightInch;
        Button btncal;
        LinearLayout LLmain;


        edtweight = findViewById(R.id.edtweight);
        edtheightFt = findViewById(R.id.edtheightFt);
        edtheightInch = findViewById(R.id.edtheightInch);
        txtResult = findViewById(R.id.txtresult);
        btncal = findViewById(R.id.btncal);
        LLmain = findViewById(R.id.LLmain);
        LLmain.setBackgroundColor(getColor(R.color.main));


        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int wt = Integer.parseInt(edtweight.getText().toString());
               int ft = Integer.parseInt(edtheightFt.getText().toString());
               int inch = Integer.parseInt(edtheightInch.getText().toString());
               int totalin = ft*12 + inch;
               double cm = totalin*2.53;
               double totalm =cm/100;
               double bmi = wt/(totalm*totalm);
               if(bmi>25){
                   txtResult.setText("Overweight");
                   LLmain.setBackgroundColor(getColor(R.color.OW));

               }else if(bmi<18){
                   txtResult.setText("Underweight");
                   LLmain.setBackgroundColor(getColor(R.color.UW));

               }else{
                   txtResult.setText("Healthy");
                   LLmain.setBackgroundColor(getColor(R.color.Healthy));

               }
            }
        });
    }
}