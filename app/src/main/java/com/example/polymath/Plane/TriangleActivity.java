package com.example.polymath.Plane;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.polymath.R;

public class TriangleActivity extends AppCompatActivity {

    LinearLayout backBtn;
    TextView resultOutput;
    EditText baseInput, heightInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

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

        double area = 0.5 * base * height;

        boolean hasDecimal = (area - Math.floor(area)) > 0;

        String formattedResult;
        if (hasDecimal) {
            formattedResult = String.valueOf(area);
        } else {
            formattedResult = String.valueOf((int) area);
        }

        resultOutput.setText(formattedResult);
    }
}
