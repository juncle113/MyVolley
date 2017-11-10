package com.study.sl.myvolley.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.toolbox.NetworkImageView;
import com.study.sl.myvolley.R;
import com.study.sl.myvolley.util.VolleyUtil;

public class NetworkImageActivity extends AppCompatActivity {

    private NetworkImageView NetworkImageView_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_image);

        init();
    }

    private void init() {
        NetworkImageView_image = findViewById(R.id.NetworkImage_image);

        getImage();
    }

    private void getImage() {
        VolleyUtil.getImageByNetwork(NetworkImageView_image, "https://www.baidu.com/img/baidu_jgylogo3.gif", "getNetworkLogo");
    }
}
