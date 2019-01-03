package com.single.androiddatabing.utils;

import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;

import com.single.androiddatabing.bean.KewenItem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xiangcheng on 19/1/3.
 */

public class ViewUtils {
    @BindingAdapter({"loadHighLight"})
    public static void loadLight(TextView textView, String text) {
        textView.setText(highlightMoney(text, text.substring(0, 2)));
    }

    public static SpannableStringBuilder highlightMoney(String text, String target) {
        SpannableStringBuilder spannable = new SpannableStringBuilder(text);
        CharacterStyle span = null;
        //用他们的小写来做判断
        if (!TextUtils.isEmpty(target)) {
            Pattern p = Pattern.compile(target.toLowerCase());
            Matcher m = p.matcher(text.toLowerCase());
            while (m.find()) {
                span = new ForegroundColorSpan(Color.parseColor("#FF801A"));// 需要重复！
                spannable.setSpan(span, m.start(), m.end(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                StyleSpan styleSpan_B = new StyleSpan(Typeface.BOLD);
                spannable.setSpan(styleSpan_B, m.start(), m.end(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
            return spannable;
        } else {
            return new SpannableStringBuilder(text);
        }
    }

    @BindingAdapter({"zhongri"})
    public static void loadZhongriTextColor(TextView textView, KewenItem kewenItem) {
        textView.setTextColor(textView.getContext().getResources().getColor(kewenItem.textColor));
        textView.setBackground(textView.getContext().getResources().getDrawable(kewenItem.drawable));
        textView.setText(kewenItem.text);
    }
}
