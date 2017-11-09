package com.study.sl.myvolley.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.study.sl.myvolley.R;
import com.study.sl.myvolley.util.VolleyUtil;

public class ImageActivity extends AppCompatActivity {

    private ImageView ImageView_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        init();
    }

    private void init() {
        ImageView_image = findViewById(R.id.ImageView_image);

        getImage();
    }

    private void getImage() {
        VolleyUtil.getImage("https://www.baidu.com/img/baidu_jgylogo3.gif",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        ImageView_image.setImageBitmap(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ImageView_image.setImageResource(R.drawable.ic_launcher_background);
                        Log.d("Tag", error.getMessage(), error);
                    }
                },
                "getLogo");
    }
}
