package me.fangx.zhihu.modle.http;

import me.fangx.zhihu.modle.entity.ArticleListEntity;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by fangxiao on 16/1/8.
 */
public interface HomeListService {
    @GET("api/3/news/before/{date}")
    Observable<ArticleListEntity> getHomeArticleList(@Path("date") String date);
}
