package com.zhangqie.materialdesigndemo.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.zhangqie.materialdesigndemo.R;

import java.util.List;

/**
 * Created by zhangqie on 2016/6/19.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    List<String> list;

    public ItemAdapter(List<String> data){
        this.list=data;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tablayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        View view=holder.itemView;
        TextView textView= (TextView) view.findViewById(R.id.info_text);
        textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list==null && list.size()<0 ? 0 : list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View view){
            super(view);
        }
    }

}
