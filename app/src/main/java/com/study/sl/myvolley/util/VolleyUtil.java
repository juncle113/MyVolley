package com.study.sl.myvolley.util;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.study.sl.myvolley.R;
import com.study.sl.myvolley.application.MyApplication;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by SUNLI on 2017/11/8.
 */

public class VolleyUtil {
    public static void getString(int method, String url, Listener listener, ErrorListener errorListener, String tag) {
        StringRequest request = new StringRequest(method, url, listener, errorListener);
        request.setTag(tag);
        MyApplication.getRequestQueue().add(request);
    }

    public static void getJson(int method, String url, Listener listener, ErrorListener errorListener, String tag) {
        JsonObjectRequest request = new JsonObjectRequest(method, url, listener, errorListener);
        request.setTag(tag);
        MyApplication.getRequestQueue().add(request);
    }

    public static void getImage(String url, Listener listener, ErrorListener errorListener, String tag) {
        ImageRequest request = new ImageRequest(url, listener, 0, 0, ScaleType.CENTER_INSIDE, Bitmap.Config.RGB_565, errorListener);
        request.setTag(tag);
        MyApplication.getRequestQueue().add(request);
    }

    public static void getImageByLoader(ImageView imageView, String url, String tag) {
        ImageLoader imageLoader = new ImageLoader(MyApplication.getRequestQueue(), new BitmapCache());
        ImageListener imageListener = ImageLoader.getImageListener(imageView, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background);
        imageLoader.get(url, imageListener);
    }

    public static void getImageByNetwork(NetworkImageView imageView, String url, String tag) {
        ImageLoader imageLoader = new ImageLoader(MyApplication.getRequestQueue(), new BitmapCache());
        imageView.setDefaultImageResId(R.drawable.ic_launcher_background);
        imageView.setErrorImageResId(R.drawable.ic_launcher_background);
        imageView.setImageUrl(url, imageLoader);
    }

    public static void getXML() {
        XMLRequest xmlRequest = new XMLRequest(
                "http://flash.weather.com.cn/wmaps/xml/china.xml",
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
                                            Log.d("TAG", "pName is " + pName);
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
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });
        MyApplication.getRequestQueue().add(xmlRequest);
    }
}
