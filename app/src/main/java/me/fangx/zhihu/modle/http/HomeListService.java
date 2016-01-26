package me.fangx.zhihu.modle.http;

import java.util.List;

import me.fangx.zhihu.modle.bean.ArticleListBean;
import me.fangx.zhihu.modle.entity.ArticleListEntity;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by fangxiao on 16/1/8.
 */
public interface HomeListService {

    public static final String KEY_LIMIT = "limit";
    public static final String KEY_OFFSET = "offset";

    @GET("/api/columns/{id}/posts")
    Observable<List<ArticleListBean>> getHomeArticleList(@Path("id") String id, @Query(KEY_LIMIT) int limit, @Query(KEY_OFFSET) int offset);


//    @GET("api/3/news/before/{date}")
//    Observable<ArticleListEntity> getHomeArticleList(@Path("date") String date);

}
