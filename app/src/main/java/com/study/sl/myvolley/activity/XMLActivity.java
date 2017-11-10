package com.study.sl.myvolley.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.study.sl.myvolley.R;
import com.study.sl.myvolley.util.VolleyUtil;

public class XMLActivity extends AppCompatActivity {

    private TextView TextView_xml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);

        init();
    }

    private void init() {
        TextView_xml = (TextView)findViewById(R.id.TextView_xml);

        getXML();
    }

    private void getXML() {
        VolleyUtil.getXML();
    }
}
