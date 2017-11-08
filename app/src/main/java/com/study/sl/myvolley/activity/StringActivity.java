package com.study.sl.myvolley.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.study.sl.myvolley.R;
import com.study.sl.myvolley.util.VolleyUtil;

public class StringActivity extends AppCompatActivity {

    private TextView TextView_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string);

        init();
    }

    private void init() {
        TextView_string = (TextView)findViewById(R.id.TextView_string);

        getDataByString();
    }

    private void getDataByString() {
        VolleyUtil.getDataByString(Request.Method.GET,
                "https://m.baidu.com/?from=844b&vit=fps",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        TextView_string.setText(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Tag", error.getMessage(), error);
                    }
                },
                "getBaidu");
    }
}
