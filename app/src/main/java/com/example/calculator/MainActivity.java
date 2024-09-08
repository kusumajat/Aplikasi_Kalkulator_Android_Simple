package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd, buttonSub, buttonMul, buttonDiv;
    EditText editTextN1, editTextN2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.btnAdd);
        buttonSub = findViewById(R.id.btnSub);
        buttonMul = findViewById(R.id.btnMul);
        buttonDiv = findViewById(R.id.btnDiv);
        editTextN1 = findViewById(R.id.Num1);
        editTextN2 = findViewById(R.id.Num2);
        textView = findViewById(R.id.hasil);

        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
    }

    public int getIntFromEditText(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Masukkan Angka", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            return Integer.parseInt(editText.getText().toString());
        }
    }

    @Override
    public void onClick(View view) {
        int num1 = getIntFromEditText(editTextN1);
        int num2 = getIntFromEditText(editTextN2);
        int result = 0;
        boolean validOperation = true;

        if (view.getId() == R.id.btnAdd) {
            result = num1 + num2;
        } else if (view.getId() == R.id.btnSub) {
            result = num1 - num2;
        } else if (view.getId() == R.id.btnMul) {
            result = num1 * num2;
        } else if (view.getId() == R.id.btnDiv) {
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                Toast.makeText(this, "Tidak terdefinisi", Toast.LENGTH_SHORT).show();
                validOperation = false;
            }
        }

        if (validOperation) {
            textView.setText(String.valueOf(result));
        }
    }
}