package com.zhangqie.materialdesigndemo.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;
import com.zhangqie.materialdesigndemo.R;

import java.util.ArrayList;

/**
 * Created by zhangqie on 2017/8/19.
 */

public class CoordinatorLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinator_layout);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        StatusBarUtil.setTranslucent(CoordinatorLayoutActivity.this, StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA);
        getWindow().setNavigationBarColor(getResources().getColor(android.R.color.black));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
            }
        });
        initView();
    }
    private void initView(){
        CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mCollapsingToolbarLayout.setTitle("首页");
        //通过CollapsingToolbarLayout修改字体颜色
        //设置还没收缩时状态下字体颜色
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.BLACK);
        //设置收缩后Toolbar上字体的颜色
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.GREEN);
        bindData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapter adapater = new RecyclerAdapter(list);
        recyclerView.setAdapter(adapater);
        FloatingActionButton floatingActionButton= (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CoordinatorLayoutActivity.this,"切切歆语",Toast.LENGTH_LONG).show();
            }
        });
    }

    private ArrayList<String> list=null;

    private void bindData(){
        list=new ArrayList<>();
        for(int i=0;i<22;i++){
            list.add("Item"+(i+1));
        }
    }

    final class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

        private ArrayList<String> mArrayList;

        public RecyclerAdapter(ArrayList<String> arrayList) {
            mArrayList = arrayList;
            setHasStableIds(true);
        }

        @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            return new ViewHolder(v);
        }

        @Override public void onBindViewHolder(ViewHolder viewHolder, int position) {
            viewHolder.textView.setText(mArrayList.get(position));
        }

        @Override public long getItemId(int position) {
            return mArrayList.get(position).hashCode();
        }

        @Override public int getItemCount() {
            return mArrayList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView textView;

            public ViewHolder(View v) {
                super(v);
                textView = (TextView) v.findViewById(android.R.id.text1);
            }
        }
    }
}
