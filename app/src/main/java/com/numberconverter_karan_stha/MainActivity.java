package com.numberconverter_karan_stha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText etNumber;
    private Button btnConvert;
    private TextView tvOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        btnConvert = findViewById(R.id.btnConvert);
        tvOut = findViewById(R.id.tvOut);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validate())
                {



                }

            }
        });

    }

    private boolean validate() {
        boolean flag = true;
        Pattern p = Pattern.compile("[-+]?[0-9]");
        Matcher m1 = p.matcher(etNumber.getText().toString());

        //Validating for Empty Text
        if (TextUtils.isEmpty(etNumber.getText().toString())) {
            etNumber.setError("Enter Height");
            etNumber.requestFocus();
            flag = false;
        }
        else if (!m1.find())    //validating for number only
        {
            Toast.makeText(getApplicationContext(), "Enter a valid number", Toast.LENGTH_LONG).show();
            etNumber.setError("Enter Valid Height Number");
            etNumber.requestFocus();
            flag = false;
        }
        return flag;
    }

}
