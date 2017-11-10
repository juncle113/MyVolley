package com.study.sl.myvolley.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.study.sl.myvolley.R;
import com.study.sl.myvolley.util.VolleyUtil;

public class GsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

        init();
    }

    private void init() {
        getGson();
    }

    private void getGson() {
        VolleyUtil.getGson();
    }
}
