package com.example.polymath.Solid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.LinearLayout;


import com.example.polymath.R;

public class ConeActivity extends AppCompatActivity {

    LinearLayout backBtn;
    TextView resultOutput;
    EditText radiusInput, heightInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cone);

        backBtn = findViewById(R.id.backBtn);
        resultOutput = findViewById(R.id.resultOutput);
        radiusInput = findViewById(R.id.radiusInput);
        heightInput = findViewById(R.id.heightInput);

        radiusInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                calculateArea();
            }
        });

        heightInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                calculateArea();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void calculateArea() {
        String radiusText = radiusInput.getText().toString().trim();
        String heightText = heightInput.getText().toString().trim();

        if (radiusText.isEmpty() || heightText.isEmpty()) {
            resultOutput.setText("");
            return;
        }

        double radius = Double.parseDouble(radiusText);
        double height = Double.parseDouble(heightText);

        double slantHeight = Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
        double lateralSurfaceArea = Math.PI * radius * slantHeight;
        double baseArea = Math.PI * Math.pow(radius, 2);
        double totalSurfaceArea = lateralSurfaceArea + baseArea;

        resultOutput.setText(String.valueOf(Math.round(totalSurfaceArea * 10000) / 10000.0));
    }
}
