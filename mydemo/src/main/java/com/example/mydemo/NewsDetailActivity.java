package com.example.mydemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import org.sufficientlysecure.htmltextview.HtmlTextView;

/**
 * Created by wenc on 2016/5/30.
 */
public class NewsDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*
        setContentView(R.layout.activity_news_detail);

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("你好");*/


        setContentView(R.layout.activity_news_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ProgressBar mProgressBar = (ProgressBar) findViewById(R.id.progress);
        HtmlTextView mTVNewsContent = (HtmlTextView) findViewById(R.id.htNewsContent);
        mProgressBar.setVisibility(View.GONE);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("你好");

        mTVNewsContent.setHtmlFromRawResource(this,R.raw.hzjl,new HtmlTextView.LocalImageGetter());


    }
}
