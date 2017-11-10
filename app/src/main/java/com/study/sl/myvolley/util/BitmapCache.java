package com.study.sl.myvolley.util;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader.ImageCache;

/**
 * Created by SUNLI on 2017/11/9.
 */

public class BitmapCache implements ImageCache {

    private LruCache<String, Bitmap> cache;

    public BitmapCache() {
        int maxSize = 10 * 1024 * 1024;
        cache = new LruCache<String, Bitmap>(maxSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }
        };
    }

    @Override
    public Bitmap getBitmap(String url) {
        return cache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        cache.put(url, bitmap);
    }
}
