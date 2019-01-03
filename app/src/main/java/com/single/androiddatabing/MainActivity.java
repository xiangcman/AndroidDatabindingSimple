package com.single.androiddatabing;

import android.databinding.DataBindingUtil;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.util.TypedValue;

import com.single.androiddatabing.adapter.BaseRecyclerViewBingAdapter;
import com.single.androiddatabing.bean.KewenItem;
import com.single.androiddatabing.databinding.ActivityRecyclerviewBinding;
import com.single.androiddatabing.databinding.KewenSelectItemBinding;
import com.single.androiddatabing.utils.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRecyclerviewBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_recyclerview);
        int space = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
        viewDataBinding.recycler.addItemDecoration(new SpaceItemDecoration(new Rect(space, space, space, space)));
        viewDataBinding.recycler.setLayoutManager(new GridLayoutManager(this, 2));
        List<KewenItem> sessions = new ArrayList<>();
        sessions.add(new KewenItem("五十音"));
        sessions.add(new KewenItem("初级上册"));
        sessions.add(new KewenItem("初级下册"));
        sessions.add(new KewenItem("中级上册"));
        viewDataBinding.recycler.setAdapter(new BaseRecyclerViewBingAdapter<KewenItem, KewenSelectItemBinding>(this, sessions, BR.kewenItem) {

            @Override
            protected int getItemLayout(int viewType) {
                return R.layout.kewen_select_item;
            }

            @Override
            protected void itemClick(KewenItem item, int position) {

            }
        });
    }
}
