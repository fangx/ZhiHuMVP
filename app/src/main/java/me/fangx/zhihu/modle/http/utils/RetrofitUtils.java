package me.fangx.zhihu.modle.http.utils;

import android.content.Context;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by fangxiao on 16/1/5.
 */
public class RetrofitUtils {

    private static Retrofit singleton;

    public static <T> T createApi(Context context, Class<T> clazz) {
        if (singleton == null) {
            synchronized (RetrofitUtils.class) {
                if (singleton == null) {
                    Retrofit.Builder builder = new Retrofit.Builder();
                    builder.baseUrl("http://zhuanlan.zhihu.com/")
                            .addConverterFactory(GsonConverterFactory.create())//设置远程地址
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
                    singleton = builder.build();
                }
            }
        }
        return singleton.create(clazz);
    }

}
