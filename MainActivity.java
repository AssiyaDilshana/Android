package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4,
            button5, button6, button7, button8, button9,
            buttonC, buttonDot, buttonAdd, buttonSub,
            buttonMul, buttonDiv, buttonEql;

    EditText result;

    float mValueOne, mValueTwo;
    boolean addition, subtract, multiplication, division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind Views
        result = findViewById(R.id.edt1);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonDot = findViewById(R.id.buttonDot);
        buttonC = findViewById(R.id.buttonC);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSub = findViewById(R.id.buttonSub);
        buttonMul = findViewById(R.id.buttonMul);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonEql = findViewById(R.id.buttonEql);

        // Number Buttons
        View.OnClickListener numberClickListener = v -> {
            Button b = (Button) v;
            result.append(b.getText());
        };

        button0.setOnClickListener(numberClickListener);
        button1.setOnClickListener(numberClickListener);
        button2.setOnClickListener(numberClickListener);
        button3.setOnClickListener(numberClickListener);
        button4.setOnClickListener(numberClickListener);
        button5.setOnClickListener(numberClickListener);
        button6.setOnClickListener(numberClickListener);
        button7.setOnClickListener(numberClickListener);
        button8.setOnClickListener(numberClickListener);
        button9.setOnClickListener(numberClickListener);
        buttonDot.setOnClickListener(numberClickListener);

        // Clear Button
        buttonC.setOnClickListener(v -> result.setText(""));

        // Add
        buttonAdd.setOnClickListener(v -> {
            if (!result.getText().toString().isEmpty()) {
                mValueOne = Float.parseFloat(result.getText().toString());
                addition = true;
                result.setText("");
            }
        });

        // Subtract
        buttonSub.setOnClickListener(v -> {
            if (!result.getText().toString().isEmpty()) {
                mValueOne = Float.parseFloat(result.getText().toString());
                subtract = true;
                result.setText("");
            }
        });

        // Multiply
        buttonMul.setOnClickListener(v -> {
            if (!result.getText().toString().isEmpty()) {
                mValueOne = Float.parseFloat(result.getText().toString());
                multiplication = true;
                result.setText("");
            }
        });

        // Divide
        buttonDiv.setOnClickListener(v -> {
            if (!result.getText().toString().isEmpty()) {
                mValueOne = Float.parseFloat(result.getText().toString());
                division = true;
                result.setText("");
            }
        });

        // Equals
        buttonEql.setOnClickListener(v -> {
            if (!result.getText().toString().isEmpty()) {
                mValueTwo = Float.parseFloat(result.getText().toString());

                if (addition) {
                    result.setText(String.valueOf(mValueOne + mValueTwo));
                    addition = false;
                } else if (subtract) {
                    result.setText(String.valueOf(mValueOne - mValueTwo));
                    subtract = false;
                } else if (multiplication) {
                    result.setText(String.valueOf(mValueOne * mValueTwo));
                    multiplication = false;
                } else if (division) {
                    if (mValueTwo != 0) {
                        result.setText(String.valueOf(mValueOne / mValueTwo));
                    } else {
                        result.setText("Error");
                    }
                    division = false;
                }
            }
        });
    }
}
