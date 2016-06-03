package com.example.daynews.utils;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.daynews.bean.News;
import com.example.daynews.news.model.NewsModel;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by wenc on 2016/5/30.
 */
public class HttpUtils {
    RequestQueue queue;

    public HttpUtils(Context context) {
        queue = Volley.newRequestQueue(context);
    }

    public void getData(String uri, final NewsModel.onLoadDataListener listener) {

        StringRequest stringRequest = new StringRequest(uri,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Gson gons=new Gson();
                        News news=  gons.fromJson(response, News.class);
                        //listener.onLoadSuccess();
                        List<News.DataBean> data = news.getData();
                        listener.onLoadSuccess(data);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
                listener.onFailure( error.getMessage(),error);
            }
        });
        queue.add(stringRequest);
    }

}
