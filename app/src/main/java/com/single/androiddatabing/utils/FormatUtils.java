package com.single.androiddatabing.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xiangcheng on 18/12/28.
 */

public class FormatUtils {
    public static String formatTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
        return simpleDateFormat.format(date);
    }
}
