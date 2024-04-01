package com.example.polymath;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    EditText nameInput, emailInput;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nameInput.getText().length() < 1 || emailInput.getText().length() < 1) {
                    Snackbar.make(v, "Please enter name and email.", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (!emailInput.getText().toString().contains("@") || !emailInput.getText().toString().contains(".")) {
                    Snackbar.make(v, "Invalid Email.", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                String nameText = nameInput.getText().toString().trim();
                String emailText = emailInput.getText().toString().trim();

                // Pass input data to MainActivity
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("nameUser", nameText);
                intent.putExtra("emailUser", emailText);
                startActivity(intent);
            }
        });
    }
}