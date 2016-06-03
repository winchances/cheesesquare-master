package com.example.daynews.news.view;

import com.example.daynews.bean.News;

import java.util.List;

/**
 * Created by wenc on 2016/5/31.
 */
public interface NewsListView {

    void showProgressBar();
    void hideProgressBar();

    void showLoadError(String message);
    void addNewsList(List<News.DataBean> list);
}
