package com.example.daynews.news.model;

import android.content.Context;

import com.example.daynews.bean.News;

import java.util.List;

/**
 * Created by wenc on 2016/5/30.
 */
public interface NewsModel {
    void loadData(Context context,String uri, onLoadDataListener listener);

    interface onLoadDataListener{
        void onLoadSuccess(List<News.DataBean> list);
        void onFailure(String msg, Exception e);
    }
}
