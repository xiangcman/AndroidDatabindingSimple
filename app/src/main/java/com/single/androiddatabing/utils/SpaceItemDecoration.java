package com.single.androiddatabing.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by xiangcheng on 18/5/24.
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private Rect space;

    public SpaceItemDecoration(Rect outRect) {
        this.space = outRect;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(space);
    }
}
