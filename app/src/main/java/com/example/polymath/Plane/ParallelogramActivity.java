package com.example.polymath.Plane;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout;

import com.example.polymath.R;

public class ParallelogramActivity extends AppCompatActivity {

    LinearLayout backBtn;
    TextView resultOutput;
    EditText baseInput, heightInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parallelogram);

        backBtn = findViewById(R.id.backBtn);
        resultOutput = findViewById(R.id.resultOutput);
        baseInput = findViewById(R.id.baseInput);
        heightInput = findViewById(R.id.heightInput);

        baseInput.addTextChangedListener(new TextWatcher() {
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
        String baseText = baseInput.getText().toString().trim();
        String heightText = heightInput.getText().toString().trim();

        if (baseText.isEmpty() || heightText.isEmpty()) {
            resultOutput.setText("");
            return;
        }

        double base = Double.parseDouble(baseText);
        double height = Double.parseDouble(heightText);

        double area = base * height;

        boolean isBaseInteger = !(baseText.contains("."));
        boolean isHeightInteger = !(heightText.contains("."));

        String formattedResult;
        if (isBaseInteger && isHeightInteger) {
            formattedResult = String.valueOf((int) area);
        } else {
            formattedResult = String.valueOf(Math.round(area * 100) / 100.0);
        }

        resultOutput.setText(formattedResult);
    }
}
