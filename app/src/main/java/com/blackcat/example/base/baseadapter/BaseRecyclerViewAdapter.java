package com.blackcat.example.base.baseadapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.blackcat.example.utils.PerfectClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BlackCat on 2018/10/10.
 */
public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewHolder> {

    protected List<T> data = new ArrayList<>();
    protected OnItemClickListener<T> listener;
    protected OnItemLongClickListener<T> onItemLongClickListener;

    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder holder, final int position) {
        holder.onBaseBindViewHolder(data.get(position), position);

        holder.itemView.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                if (listener!=null){
                    listener.onClick(data.get(position), position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        if (data == null)
            return 10;
        else
            return data.size();
    }

    public void addAll(List<T> data) {
        this.data.addAll(data);
    }
    public void add(T object) {
        data.add(object);
    }
    public void setData(List<T> data) {
        this.data = data;
    }

    public void clear() {
        data.clear();
    }

    public void remove(T object) {
        data.remove(object);
    }

    public void remove(int position) {
        data.remove(position);
    }

    public void removeAll(List<T> data) {
        this.data.retainAll(data);
    }

    public void setOnItemClickListener(OnItemClickListener<T> listener) {
        this.listener = listener;
    }


    public List<T> getData() {
        return data;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener<T> onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }
}
