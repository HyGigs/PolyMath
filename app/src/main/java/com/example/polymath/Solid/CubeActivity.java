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

public class CubeActivity extends AppCompatActivity {

    LinearLayout backBtn;
    TextView resultOutput;
    EditText sideInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);

        backBtn = findViewById(R.id.backBtn);
        resultOutput = findViewById(R.id.resultOutput);
        sideInput = findViewById(R.id.sideInput);

        sideInput.addTextChangedListener(new TextWatcher() {
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
        String sideText = sideInput.getText().toString().trim();

        if (sideText.isEmpty()) {
            resultOutput.setText("");
            return;
        }

        double side = Double.parseDouble(sideText);
        double area = 6 * Math.pow(side, 2);

        boolean isSideInteger = !(sideText.contains("."));
        String formattedResult;
        if (isSideInteger) {
            formattedResult = String.valueOf((int) area);
        } else {
            formattedResult = String.valueOf(Math.round(area * 100) / 100.0);
        }

        resultOutput.setText(formattedResult);
    }
}
