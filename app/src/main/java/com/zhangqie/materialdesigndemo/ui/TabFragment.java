package com.zhangqie.materialdesigndemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhangqie.materialdesigndemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangqie on 2016/6/19.
 */

public class TabFragment extends Fragment {


    public static Fragment newInstance() {
        TabFragment fragment = new TabFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //需要利用实现了嵌套滚动机制的控件，才能出现AppBarLayout往上推的效果
        View rootView = inflater.inflate(R.layout.tablayout_fragment, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);    //若用其他风格显示---需定义LinearLayoutManager显示类型
        recyclerView.setAdapter(new ItemAdapter(initDate()));
        return rootView;
    }
    private  List<String>  initDate(){
        List<String> list=new ArrayList<>();
        for (int i = 0; i <15 ; i++) {
            list.add("我是卡片"+(i+1));
        }
        return list;
    }


}
