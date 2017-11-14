package com.study.sl.myvolley.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.study.sl.myvolley.R;
import com.study.sl.myvolley.util.VolleyUtil;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class XMLActivity extends AppCompatActivity {

    private TextView TextView_xml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);

        init();
    }

    private void init() {
        TextView_xml = findViewById(R.id.TextView_xml);

        getXML();
    }

    private void getXML() {
        VolleyUtil.getXML("http://flash.weather.com.cn/wmaps/xml/china.xml",
                new Response.Listener<XmlPullParser>() {
                    @Override
                    public void onResponse(XmlPullParser response) {
                        try {
                            int eventType = response.getEventType();
                            while (eventType != XmlPullParser.END_DOCUMENT) {
                                switch (eventType) {
                                    case XmlPullParser.START_TAG:
                                        String nodeName = response.getName();
                                        if ("city".equals(nodeName)) {
                                            String pName = response.getAttributeValue(0);
                                            TextView_xml.setText("pName is " + pName);
                                        }
                                        break;
                                }
                                eventType = response.next();
                            }
                        } catch (XmlPullParserException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", error.getMessage(), error);
                    }
                },
                "getWeather");
    }
}
