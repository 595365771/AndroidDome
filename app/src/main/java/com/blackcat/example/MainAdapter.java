package com.blackcat.example;

import android.view.ViewGroup;

import com.blackcat.example.base.baseadapter.BaseRecyclerViewAdapter;
import com.blackcat.example.base.baseadapter.BaseRecyclerViewHolder;
import com.blackcat.example.databinding.ItemMainBinding;

/**
 * Created by blackcat on 2018/10/9.15.25
 */

public class MainAdapter extends BaseRecyclerViewAdapter<MainBean>{


    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent,R.layout.item_main);
    }
    class ViewHolder extends BaseRecyclerViewHolder<MainBean,ItemMainBinding>{

        public ViewHolder(ViewGroup viewGroup, int layoutId) {
            super(viewGroup, layoutId);
        }

        @Override
        public void onBindViewHolder(MainBean mainBean, int position) {
            binding.setMainBean(mainBean);

        }
    }
}
