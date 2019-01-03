package com.single.androiddatabing.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by xiangcheng on 18/3/20.
 */

public abstract class BaseRecyclerViewBingAdapter<T, B extends ViewDataBinding> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    protected List<T> list;
    protected B dataBing;
    private int variableId;
    protected Context context;

    public BaseRecyclerViewBingAdapter(Context context, List<T> list, int variableId) {
        this.context = context;
        this.list = list;
        this.variableId = variableId;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //同样会根据布局生成一个相应的binding
        RecyclerView.ViewHolder viewHolder;
        dataBing = DataBindingUtil.inflate(
                LayoutInflater.from(context), getItemLayout(viewType), null, false);
        viewHolder = new BindingHolder<B>(dataBing.getRoot());
        ((BindingHolder) viewHolder).setBinding(dataBing);
        //这里getRoot会返回布局的根view
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        T t = list.get(position);
        ((BindingHolder) holder).getBinding().setVariable(variableId, t);
        ((BindingHolder) holder).getBinding().executePendingBindings();

        ((BindingHolder) holder).getBinding().getRoot().setOnClickListener(v -> {
            itemClick(t, position);
        });
        generateItem((B) ((BindingHolder) holder).getBinding(), t, position);
    }

    protected void generateItem(B dataBing, T t, int position) {

    }

    protected abstract int getItemLayout(int viewType);

    protected abstract void itemClick(T item, int position);

    public static class BindingHolder<B extends ViewDataBinding> extends RecyclerView.ViewHolder {

        //这里在holder里面，传入一个binding对象就ok了
        private B binding;

        public BindingHolder(View itemView) {
            super(itemView);
        }

        public B getBinding() {
            return binding;
        }

        public void setBinding(B binding) {
            this.binding = binding;
        }
    }

}
