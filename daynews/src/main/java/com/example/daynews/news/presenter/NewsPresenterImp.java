package com.example.daynews.news.presenter;

import android.content.Context;

import com.example.daynews.bean.News;
import com.example.daynews.news.model.NewsModel;
import com.example.daynews.news.model.NewsModelImp;
import com.example.daynews.news.view.NewsListView;

import java.util.List;

/**
 * Created by wenc on 2016/5/31.
 */
public class NewsPresenterImp implements NewsPresenter {


    public static final int NEWS_TYPE_RECOMMEND = 0;
    public static final int NEWS_TYPE_HOTSPOT = 1;
    public static final int NEWS_TYPE_TECH = 2;
    public static final int NEWS_TYPE_BEJING = 3;
    public static final int NEWS_TYPE_SOCIETY = 4;
    public static final int NEWS_TYPE_AMUSE = 5;
    public static final int NEWS_TYPE_CAR = 6;
    public static final int NEWS_TYPE_PHYSICAL = 7;
    public static final int NEWS_TYPE_WAR = 8;
    public static final int NEWS_TYPE_FINANCE = 9;
    public static final int NEWS_TYPE_CONSTEL =10;
    public static final int NEWS_TYPE_FUNNY = 11;
    public static final int NEWS_TYPE_GAME = 12;

    NewsListView view;
    NewsModel model;
    Context context;


    public NewsPresenterImp(NewsListView view,Context context) {
        this.view = view;
        model=new NewsModelImp();
        this.context=context;
    }

    @Override
    public void loadNews(int type, int page) {

        view.showProgressBar();
        String uri = getUri(type);
        model.loadData(context, uri, new NewsModel.onLoadDataListener() {
            @Override
            public void onLoadSuccess(List<News.DataBean> list) {
                view.addNewsList(list);
                view.hideProgressBar();
            }

            @Override
            public void onFailure(String msg, Exception e) {
                view.hideProgressBar();
                view.showLoadError(msg);
            }
        });

    }

    private  String getUri(int type){

        String uri="";
        switch (type){
            case NEWS_TYPE_RECOMMEND:
                uri="http://ic.snssdk.com/2/article/v14/stream/?detail=1&image=1&count=20&min_behot_time=1455594227&iid=3641392726&device_id=10789635067&ac=wifi&channel=dearclick31&aid=13&app_name=news_article&version_code=330&device_platform=android&device_type=Coolpad%208297&os_api=17&os_version=4.2.2&uuid=863777029390464&openudid=17de2106c58527f4";
                break;
             case NEWS_TYPE_HOTSPOT:
                uri="http://ic.snssdk.com/2/article/v14/stream/?detail=1&image=1&count=20&min_behot_time=1455594227&iid=3641392726&device_id=10789635067&ac=wifi&channel=dearclick31&aid=13&app_name=news_article&version_code=330&device_platform=android&device_type=Coolpad%208297&os_api=17&os_version=4.2.2&uuid=863777029390464&openudid=17de2106c58527f4";
                break;
             case NEWS_TYPE_TECH:
                uri="http://ic.snssdk.com/2/article/v14/stream/?detail=1&image=1&count=20&min_behot_time=1455594227&iid=3641392726&device_id=10789635067&ac=wifi&channel=dearclick31&aid=13&app_name=news_article&version_code=330&device_platform=android&device_type=Coolpad%208297&os_api=17&os_version=4.2.2&uuid=863777029390464&openudid=17de2106c58527f4";
                break;
             case NEWS_TYPE_BEJING:
                uri="http://ic.snssdk.com/2/article/v14/stream/?detail=1&image=1&count=20&min_behot_time=1455594227&iid=3641392726&device_id=10789635067&ac=wifi&channel=dearclick31&aid=13&app_name=news_article&version_code=330&device_platform=android&device_type=Coolpad%208297&os_api=17&os_version=4.2.2&uuid=863777029390464&openudid=17de2106c58527f4";
                break;
             case NEWS_TYPE_SOCIETY:
                uri="http://ic.snssdk.com/2/article/v14/stream/?detail=1&image=1&count=20&min_behot_time=1455594227&iid=3641392726&device_id=10789635067&ac=wifi&channel=dearclick31&aid=13&app_name=news_article&version_code=330&device_platform=android&device_type=Coolpad%208297&os_api=17&os_version=4.2.2&uuid=863777029390464&openudid=17de2106c58527f4";
                break;
             case NEWS_TYPE_AMUSE:
                uri="http://ic.snssdk.com/2/article/v14/stream/?detail=1&image=1&count=20&min_behot_time=1455594227&iid=3641392726&device_id=10789635067&ac=wifi&channel=dearclick31&aid=13&app_name=news_article&version_code=330&device_platform=android&device_type=Coolpad%208297&os_api=17&os_version=4.2.2&uuid=863777029390464&openudid=17de2106c58527f4";
                break;
             case NEWS_TYPE_CAR:
                uri="http://ic.snssdk.com/2/article/v14/stream/?detail=1&image=1&count=20&min_behot_time=1455594227&iid=3641392726&device_id=10789635067&ac=wifi&channel=dearclick31&aid=13&app_name=news_article&version_code=330&device_platform=android&device_type=Coolpad%208297&os_api=17&os_version=4.2.2&uuid=863777029390464&openudid=17de2106c58527f4";
                break;
             case NEWS_TYPE_PHYSICAL:
                uri="http://ic.snssdk.com/2/article/v14/stream/?detail=1&image=1&count=20&min_behot_time=1455594227&iid=3641392726&device_id=10789635067&ac=wifi&channel=dearclick31&aid=13&app_name=news_article&version_code=330&device_platform=android&device_type=Coolpad%208297&os_api=17&os_version=4.2.2&uuid=863777029390464&openudid=17de2106c58527f4";
                break;
             case NEWS_TYPE_WAR:
                uri="http://ic.snssdk.com/2/article/v14/stream/?detail=1&image=1&count=20&min_behot_time=1455594227&iid=3641392726&device_id=10789635067&ac=wifi&channel=dearclick31&aid=13&app_name=news_article&version_code=330&device_platform=android&device_type=Coolpad%208297&os_api=17&os_version=4.2.2&uuid=863777029390464&openudid=17de2106c58527f4";
                break;

            case NEWS_TYPE_FINANCE:
                uri="http://ic.snssdk.com/2/article/v14/stream/?detail=1&image=1&count=20&min_behot_time=1455594227&iid=3641392726&device_id=10789635067&ac=wifi&channel=dearclick31&aid=13&app_name=news_article&version_code=330&device_platform=android&device_type=Coolpad%208297&os_api=17&os_version=4.2.2&uuid=863777029390464&openudid=17de2106c58527f4";
                break;

             case NEWS_TYPE_CONSTEL:
                uri="http://ic.snssdk.com/2/article/v14/stream/?detail=1&image=1&count=20&min_behot_time=1455594227&iid=3641392726&device_id=10789635067&ac=wifi&channel=dearclick31&aid=13&app_name=news_article&version_code=330&device_platform=android&device_type=Coolpad%208297&os_api=17&os_version=4.2.2&uuid=863777029390464&openudid=17de2106c58527f4";
                break;
             case NEWS_TYPE_FUNNY:
                uri="http://ic.snssdk.com/2/article/v14/stream/?detail=1&image=1&count=20&min_behot_time=1455594227&iid=3641392726&device_id=10789635067&ac=wifi&channel=dearclick31&aid=13&app_name=news_article&version_code=330&device_platform=android&device_type=Coolpad%208297&os_api=17&os_version=4.2.2&uuid=863777029390464&openudid=17de2106c58527f4";
                break;
             case NEWS_TYPE_GAME:
                uri="http://ic.snssdk.com/2/article/v14/stream/?detail=1&image=1&count=20&min_behot_time=1455594227&iid=3641392726&device_id=10789635067&ac=wifi&channel=dearclick31&aid=13&app_name=news_article&version_code=330&device_platform=android&device_type=Coolpad%208297&os_api=17&os_version=4.2.2&uuid=863777029390464&openudid=17de2106c58527f4";
                break;

        }


        return uri;
    }
}
