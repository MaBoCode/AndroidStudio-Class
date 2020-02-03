package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button sendButton, quitButton, nextActivityButton;
    private EditText textInput;

    View.OnClickListener sendButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popUp("Valeur = " + getTextValue());
        }
    };

    View.OnClickListener nextActivityOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), NextActivity.class);

            Bundle bundle = new Bundle();

            bundle.putString("value", getTextValue());

            intent.putExtra("extra", bundle);

            startActivity(intent);
        }
    };

    View.OnClickListener quitOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.sendButton = (Button) findViewById(R.id.sendButton);
        this.quitButton = (Button) findViewById(R.id.quitButton);
        this.nextActivityButton = (Button) findViewById(R.id.nextActivityButton);
        this.textInput = findViewById(R.id.textInput);

        this.sendButton.setOnClickListener(sendButtonOnClickListener);
        this.nextActivityButton.setOnClickListener(nextActivityOnClickListener);
        this.quitButton.setOnClickListener(quitOnClickListener);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences = getSharedPreferences("cache", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("value", getTextValue());
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences("cache", Context.MODE_PRIVATE);
        setTextValue(sharedPreferences.getString("value",""));
    }

    public String getTextValue() {
        return textInput.getText().toString();
    }

    public void setTextValue(String value) {
        textInput.setText(value);
    }

    public void popUp(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
