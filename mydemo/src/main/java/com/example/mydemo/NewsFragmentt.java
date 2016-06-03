package com.example.mydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenc on 2016/5/28.
 */
public class NewsFragmentt extends Fragment {
    View view;
    List<String> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.item,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        list = new ArrayList<>();
        for (int i=0;i<100;i++){
            list.add("张三"+i);
        }
      RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.rv);
       // lv.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list));
        recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));

      //  recyclerView.addItemDecoration( new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.addItemDecoration( new DividerItemDecoration(getActivity(), LinearLayoutManager.HORIZONTAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        final MyAdapter adapter;
        recyclerView.setAdapter(adapter=new MyAdapter());

        adapter.setOnItemClickListener(new onItemClickListener() {
            @Override
            public void onItemClickListener(View view, int positon) {
                Snackbar.make(getActivity().findViewById(R.id.appBar),list.get(positon), Snackbar.LENGTH_SHORT).show();
               // Snackbar.make(view,list.get(positon),Snackbar.LENGTH_SHORT).show();
              //  adapter.delItem(positon);
             // getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,new NewsDetailFragment()).commit();
                Intent intent =new Intent(getActivity(),NewsDetailActivity.class);
                startActivity(intent);
            }

            @Override
            public void onItemLongClickListener(View view, int positon) {
                    adapter.addItem(positon,"先添加"+positon);

            }
        });

    }

    class MyAdapter extends  RecyclerView.Adapter<MyAdapter.MyHolder>{

        public void addItem(int postion, String objects){
            list.add(postion,objects);
            notifyItemInserted(postion);

        }

        public void delItem(int postion){
            list.remove(postion);
            notifyItemRemoved(postion);
        }

        private  onItemClickListener onItemClickListener;

        public void setOnItemClickListener(com.example.mydemo.onItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }


        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            MyHolder holder=new MyHolder(LayoutInflater.from(getActivity()).inflate(android.R.layout.simple_list_item_1,parent,false));

            return holder;
        }

        @Override
        public void onBindViewHolder(final MyHolder holder, final  int position) {
            String s = list.get(position);
            Log.d("wen",""+s);
            holder.textView.setText(s);
            if(onItemClickListener!=null){
                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position1 = holder.getLayoutPosition();
                        Log.d("wen","holder.getLayoutPosition()"+position1);
                        Log.d("wen","position"+position);
                        onItemClickListener.onItemClickListener(holder.textView,position);
                    }
                });

                holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        int pos = holder.getLayoutPosition();
                        onItemClickListener.onItemLongClickListener(holder.textView,pos);
                        return true;
                    }
                });
            }

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class  MyHolder extends RecyclerView.ViewHolder{
            TextView textView;

            public MyHolder(View itemView) {
                super(itemView);
                textView= (TextView) itemView.findViewById(android.R.id.text1);
            }
        }
    }
}

interface  onItemClickListener{
    void onItemClickListener(View view,int positon);
    void onItemLongClickListener(View view,int positon);
}