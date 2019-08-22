package com.example.hzh.coolweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2019/8/22.
 */

public class HttpUtil {

    //GET请求
    public static void sendOkHttpRequest(String url,okhttp3.Callback callback ){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url( url ).build();
        client.newCall( request ).enqueue( callback );
    }
}
