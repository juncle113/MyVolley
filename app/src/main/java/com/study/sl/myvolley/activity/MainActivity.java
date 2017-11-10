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
    private Button Button_gson;
    private Button Button_xml;
    private Button Button_image;
    private Button Button_imageLoader;
    private Button Button_networkImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        Button_string = findViewById(R.id.Button_string);
        Button_json = findViewById(R.id.Button_json);
        Button_gson = findViewById(R.id.Button_gson);
        Button_xml = findViewById(R.id.Button_xml);
        Button_image = findViewById(R.id.Button_image);
        Button_imageLoader = findViewById(R.id.Button_imageLoader);
        Button_networkImage = findViewById(R.id.Button_networkImage);

        Button_string.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StringActivity.class));
            }
        });

        Button_json.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, JsonActivity.class));
            }
        });

        Button_gson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GsonActivity.class));
            }
        });

        Button_xml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, XMLActivity.class));
            }
        });

        Button_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ImageActivity.class));
            }
        });

        Button_imageLoader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ImageLoaderActivity.class));
            }
        });

        Button_networkImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NetworkImageActivity.class));
            }
        });
    }
}
