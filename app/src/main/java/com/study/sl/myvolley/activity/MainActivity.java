package com.study.sl.myvolley.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.study.sl.myvolley.R;

public class MainActivity extends AppCompatActivity {

    private Button Button_string;
    private Button Button_json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        Button_string = (Button) findViewById(R.id.Button_string);
        Button_json = (Button) findViewById(R.id.Button_json);

        Button_string.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StringActivity.class));
            }
        });

        Button_json.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
