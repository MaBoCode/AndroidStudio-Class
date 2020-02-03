package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button sendButton, resetButton;
    private EditText weightInput, heightInput;
    private CheckBox comment;
    private RadioGroup radioGroup;
    private TextView result;

    private final String initText = "Cliquez sur \"Calculer l'IMC\"";

    private View.OnClickListener sendListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Float height = Float.valueOf(heightInput.getText().toString());
            Float weight = Float.valueOf(weightInput.getText().toString());

            if (height < 0 || weight < 0) {
                Toast.makeText(MainActivity.this, "Poids et taille sont > 0.", Toast.LENGTH_SHORT).show();
            } else {
                if (radioGroup.getCheckedRadioButtonId() == R.id.centimeterRadioInput) height = height / 100;

                float IMC = weight / (height * height);

                String resultText = "IMC: " + IMC + ".";

                if (comment.isChecked()) resultText += " " + commentIMC(IMC) + ".";

                result.setText(resultText);
            }
        }
    };

    private View.OnClickListener resetListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            weightInput.getText().clear();
            heightInput.getText().clear();
            result.setText(initText);
        }
    };

    private View.OnClickListener checkedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (((CheckBox) v).isChecked()) {
                result.setText(initText);
            }
        }
    };

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            result.setText(initText);
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = (Button) findViewById(R.id.calculateButton);
        resetButton = (Button) findViewById(R.id.resetButton);

        weightInput = (EditText) findViewById(R.id.weightInput);
        heightInput = (EditText) findViewById(R.id.heightInput);

        comment = (CheckBox) findViewById(R.id.commentaryCheckBox);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        result = (TextView) findViewById(R.id.resultText);

        sendButton.setOnClickListener(sendListener);
        resetButton.setOnClickListener(resetListener);
        comment.setOnClickListener(checkedListener);

        weightInput.addTextChangedListener(textWatcher);
        heightInput.addTextChangedListener(textWatcher);
    }

    public String commentIMC(float IMC) {
        if (IMC < 16.5) {
            return "Famine";
        } else if (IMC >= 16.5 && IMC < 18.5) {
            return  "Maigreur";
        } else if (IMC >= 18.5 && IMC < 25) {
            return "Corpulence normale";
        } else if (IMC >= 25 && IMC < 30) {
            return "Surpoids";
        } else if (IMC >= 30 && IMC < 35) {
            return "Obésité modérée";
        } else if (IMC >= 35 && IMC < 40) {
            return "Obésité sévère";
        } else {
            return "Obésité morbide ou massive";
        }
    }
}
