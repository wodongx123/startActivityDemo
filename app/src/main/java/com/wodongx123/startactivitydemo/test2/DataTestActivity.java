package com.wodongx123.startactivitydemo.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.wodongx123.startactivitydemo.R;

public class DataTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_test);

        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);

        tv1.setText("URI ：" + getIntent().getDataString());
        tv2.setText("MIMETYPE ：" + getIntent().getType());


    }
}