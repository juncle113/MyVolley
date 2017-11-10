package com.study.sl.myvolley.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.study.sl.myvolley.R;
import com.study.sl.myvolley.util.VolleyUtil;

public class ImageLoaderActivity extends AppCompatActivity {

    private ImageView ImageView_imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader);

        init();
    }

    private void init() {
        ImageView_imageLoader = findViewById(R.id.ImageView_imageLoader);
        getImageByLoader();
    }

    private void getImageByLoader() {
        VolleyUtil.getImageByLoader(ImageView_imageLoader,
                "https://www.baidu.com/img/baidu_jgylogo3.gif",
                "getLogo");
    }
}
