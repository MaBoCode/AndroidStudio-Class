package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button nbr_0, nbr_1, nbr_2, nbr_3, nbr_4, nbr_5, nbr_6, nbr_7, nbr_8, nbr_9;
    private Button op_add, op_sous, op_mult, op_div;
    private Button back, cancel, equals;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
