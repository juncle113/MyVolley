package com.study.sl.myvolley.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request.Method;
import com.android.volley.Response.Listener;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.study.sl.myvolley.R;
import com.study.sl.myvolley.util.VolleyUtil;

import org.json.JSONObject;


public class JsonActivity extends AppCompatActivity {

    private TextView TextView_json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        init();
    }

    private void init() {
        TextView_json = (TextView) findViewById(R.id.TextView_json);

        getDataByJson();
    }

    private void getDataByJson() {
        VolleyUtil.getDataByJson(Method.GET,
                "http://www.weather.com.cn/data/cityinfo/101010100.html",
                new Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        TextView_json.setText(response.toString());
                    }
                },
                new ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Tag", error.getMessage(), error);
                    }
                },
                "getWeather"
        );
    }
}
