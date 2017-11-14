package com.study.sl.myvolley.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.study.sl.myvolley.R;
import com.study.sl.myvolley.util.VolleyUtil;
import com.study.sl.myvolley.util.Weather;
import com.study.sl.myvolley.util.WeatherInfo;

public class GsonActivity extends AppCompatActivity {

    private TextView TextView_gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

        init();
    }

    private void init() {
        TextView_gson = findViewById(R.id.TextView_gson);
        getGson();
    }

    private void getGson() {
        VolleyUtil.getGson("http://www.weather.com.cn/data/sk/101010100.html",
                Weather.class,
                new Response.Listener<Weather>() {
                    @Override
                    public void onResponse(Weather weather) {
                        WeatherInfo weatherInfo = weather.getWeatherinfo();
                        String text = "城市：" + weatherInfo.getCity() + "\n"
                                + "温度：" + weatherInfo.getTemp() + "\n"
                                + "时间：" + weatherInfo.getTime();
                        TextView_gson.setText(text);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", error.getMessage(), error);
                    }
                },
                "getWeatherInfo");
    }
}
