package com.single.androiddatabing.bean;

import com.single.androiddatabing.R;

/**
 * Created by xiangcheng on 18/6/30.
 */

public class KewenItem {
    public int drawable = R.drawable.jiaming_back;
    public String text;

    public boolean rigth;

    public int textColor = R.color.dark_black_text;

    public KewenItem(String text) {
        this.text = text;
    }

    public KewenItem(String text, boolean right) {
        this.text = text;
        this.rigth = right;
    }
}
