package com.example.daynews.news.model;

import android.content.Context;

import com.example.daynews.utils.HttpUtils;

/**
 * Created by wenc on 2016/5/30.
 */
public class NewsModelImp implements NewsModel {
    @Override
    public void loadData(Context context,String uri, onLoadDataListener listener) {
        HttpUtils utils=new HttpUtils(context);
        utils.getData(uri,listener);
    }
}
