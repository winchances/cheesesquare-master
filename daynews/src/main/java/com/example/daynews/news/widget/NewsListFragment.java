package com.example.daynews.news.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daynews.R;
import com.example.daynews.bean.News;
import com.example.daynews.news.presenter.NewsPresenter;
import com.example.daynews.news.presenter.NewsPresenterImp;
import com.example.daynews.news.view.NewsListView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by wenc on 2016/5/31.
 */
public class NewsListFragment extends Fragment implements NewsListView, SwipeRefreshLayout.OnRefreshListener {

    private List<News.DataBean> list;
    private int type;
    RecyclerView recycle;
    SwipeRefreshLayout swipe;
    NewsPresenter presenter;
    int typee=0;



    public static NewsListFragment newInstance(int type) {

        NewsListFragment fragment = new NewsListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        fragment.setArguments(bundle);

        return fragment;
    }

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_newlist, container, false);

        presenter = new NewsPresenterImp(this,getActivity());
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle arguments = getArguments();
        if(arguments!=null){
            typee = arguments.getInt("type");
            Log.d("wen",typee+"typee");
        }
        recycle = (RecyclerView) view.findViewById(R.id.recycle);

        recycle.setHasFixedSize(true);
        recycle.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycle.setItemAnimator(new DefaultItemAnimator());

        swipe = (SwipeRefreshLayout) view.findViewById(R.id.swipe);

        swipe.setOnRefreshListener(this);

        onRefresh();

    }

    @Override
    public void showProgressBar() {
        swipe.setRefreshing(true);
    }

    @Override
    public void hideProgressBar() {
        swipe.setRefreshing(false);
    }

    @Override
    public void showLoadError(String message) {
        Snackbar.make(view,message,Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void addNewsList(List<News.DataBean> list) {
        recycle.setAdapter(new MyAdapter(list));
    }

    @Override
    public void onRefresh() {
        presenter.loadNews(typee,0);
    }

    class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        private List<News.DataBean > list;

        public MyAdapter(List<News.DataBean> list) {
            this.list = list;
        }

        @Override
        public int getItemViewType(int position) {

           int flag=-1;
         /*    News.DataBean dataBean = list.get(position);
            if(!dataBean.isHas_image()){
                flag=0;//无图片

            }else if(dataBean.getLarge_image_list()!=null){
                    flag=1;//大图片
            }else  if(dataBean.getImage_list()!=null){
                Log.d("wen","getItemViewType>>>dataBean.getImage_list()"+dataBean.getImage_list().size());
                    flag=2;//三张图片
            }else{
                flag=3;//左边图片
            }*/

            News.DataBean dataBean=  list.get(position);
            if(dataBean.getLarge_image_list()!=null&&dataBean.getLarge_image_list().size()!=0){
                flag=1;//大图片
            }else if(dataBean.getImage_list()!=null&&dataBean.getImage_list().size()==3){
                flag=2;//三张图片
            }else if(dataBean.getMiddle_image()!=null){
                flag=3;//左边图片
            }else {
                flag=0;
            }
            return flag;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            switch (viewType){
                case 0:
                     view=View.inflate(getActivity(),R.layout.newitem0,null);
                    Type0Holder viewHolder=new Type0Holder(view);
                    return  viewHolder;

                case 1:
                     view=View.inflate(getActivity(),R.layout.newitem1,null);
                    Type1Holder  viewHolder1=new Type1Holder(view);
                    return viewHolder1;

                 case 2:
                      view=View.inflate(getActivity(),R.layout.newitem2,null);
                     Type2Holder  viewHolder2=new Type2Holder(view);
                     return viewHolder2;

                 case 3:
                      view=View.inflate(getActivity(),R.layout.newitem3,null);
                     Type3Holder   viewHolder3=new Type3Holder(view);
                     return viewHolder3;



            }
           return  null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            News.DataBean bean = list.get(position);
           if(holder instanceof Type0Holder){
               ((Type0Holder) holder).textView.setText(bean.getTitle());
           }else if(holder instanceof  Type1Holder){
                    ((Type1Holder) holder).textView.setText(bean.getTitle());
               ImageLoader.getInstance().displayImage(bean.getLarge_image_list().get(0).getUrl(),((Type1Holder) holder).imageView);
           }else if( holder instanceof  Type2Holder){
               ((Type2Holder) holder).textView.setText(bean.getTitle());
               Log.d("wen",">>>>>>>>>>>>>"+bean.getImage_list().size()+"数量");
               if(bean.getImage_list().size()!=0){

               ImageLoader.getInstance().displayImage(bean.getImage_list().get(0).getUrl(),((Type2Holder) holder).imageView1);
               ImageLoader.getInstance().displayImage(bean.getImage_list().get(1).getUrl(),((Type2Holder) holder).imageView2);
               ImageLoader.getInstance().displayImage(bean.getImage_list().get(2).getUrl(),((Type2Holder) holder).imageView3);
               }
           }else if( holder instanceof  Type3Holder){
               ((Type3Holder) holder).textView.setText(bean.getTitle());
               ImageLoader.getInstance().displayImage(bean.getMiddle_image().getUrl(),((Type3Holder) holder).imageView);
           }

        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    class Type0Holder extends  RecyclerView.ViewHolder{

        public TextView textView;
        public Type0Holder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.item_tv);
        }
    }
    class Type1Holder extends  RecyclerView.ViewHolder{

        public TextView textView;
        public ImageView imageView;
        public Type1Holder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.item_tv);
            imageView= (ImageView) itemView.findViewById(R.id.item_iv);
        }
    }
    class Type2Holder extends  RecyclerView.ViewHolder{

        public TextView textView;
        public ImageView imageView1;
        public ImageView imageView2;
        public ImageView imageView3;
        public Type2Holder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.item_tv);
            imageView1= (ImageView) itemView.findViewById(R.id.item_iv1);
            imageView2= (ImageView) itemView.findViewById(R.id.item_iv2);
            imageView3= (ImageView) itemView.findViewById(R.id.item_iv3);
        }
    }

    class Type3Holder extends  RecyclerView.ViewHolder{

        public TextView textView;
        public ImageView imageView;

        public Type3Holder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.item_tv);
            imageView= (ImageView) itemView.findViewById(R.id.item_iv);
        }
    }
}
