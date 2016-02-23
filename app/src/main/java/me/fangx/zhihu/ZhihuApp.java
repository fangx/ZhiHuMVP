package me.fangx.zhihu;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import me.fangx.common.util.log.LogUtil;

/**
 * Created by fangxiao on 16/1/12.
 */
public class ZhihuApp extends Application {
    public static String cacheDir = "";

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this.getApplicationContext());
        /**
         * 如果存在SD卡则将缓存写入SD卡,否则写入手机内存
         */
        try {
            if (getApplicationContext().getExternalCacheDir() != null && ExistSDCard()) {
                cacheDir = getApplicationContext().getExternalCacheDir().toString();
                LogUtil.d("sd卡", cacheDir);
            } else {
                cacheDir = getApplicationContext().getCacheDir().toString();
            }
        } catch (Exception e) {
            cacheDir = getApplicationContext().getCacheDir().toString();
        }
    }

    private boolean ExistSDCard() {
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }


}
