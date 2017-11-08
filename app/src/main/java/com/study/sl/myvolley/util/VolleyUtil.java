package com.study.sl.myvolley.util;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.study.sl.myvolley.application.MyApplication;

/**
 * Created by SUNLI on 2017/11/8.
 */

public class VolleyUtil {
    public static void getDataByString(int method, String url, Listener listener, ErrorListener errorListener, String tag) {
        StringRequest request = new StringRequest(method, url, listener, errorListener);
        request.setTag(tag);
        MyApplication.getRequestQueue().add(request);
    }

    public static void getDataByJson(int method, String url, Listener listener, ErrorListener errorListener, String tag) {
        JsonObjectRequest request = new JsonObjectRequest(method, url, listener, errorListener);
        request.setTag(tag);
        MyApplication.getRequestQueue().add(request);
    }
}
