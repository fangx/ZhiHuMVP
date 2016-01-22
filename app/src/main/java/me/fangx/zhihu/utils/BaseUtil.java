package me.fangx.zhihu.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import me.fangx.zhihu.R;

/**
 * Created by fangxiao on 15/12/28.
 */
public class BaseUtil {
    //一天的秒数
    public static final long ONE_DAY_TIME = 24 * 60 * 60;
    /**
     * 获取屏幕分辨率
     *
     * @param context
     * @return
     */
    public static int getWidth(Activity context) {
        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;
        return screenWidth;
    }

    public static int getHeight(Activity context) {
        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenHeigt = dm.heightPixels;
        return screenHeigt;
    }

    /**
     * 判断链表是否为空
     *
     * @param list
     * @return true:为Null或者size为0
     */
    public static boolean isEmpty(List<?> list) {
        return list == null || list.size() == 0;
    }


    /**
     * 判断链表第某个位置是否为空
     *
     * @param list
     * @param index
     * @return true:为Null或者size为0
     */
    public static boolean isEmpty(List<?> list, int index) {
        return list == null || list.size() == 0 || list.size() <= index;
    }



    /**
     * 获取年月日时间
     */
    public static String getNYYMMDD() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String yymmddString = sdf.format(new Date());
        return yymmddString;
    }


    /**
     * 获取年月日时间
     */
    public static String getNYYMMDD(int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        long now = date.getTime();
        long next = now + day * ONE_DAY_TIME * 1000;
        String yymmddString = sdf.format(next);
        return yymmddString;
    }

    //分享
    public static void share(Context context, String questionTitle, String questionUrl) {
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        //noinspection deprecation
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        share.putExtra(Intent.EXTRA_TEXT, questionTitle + " " + questionUrl + " 分享自知乎网");
        context.startActivity(Intent.createChooser(share, context.getString(R.string.share_to)));
    }
}
