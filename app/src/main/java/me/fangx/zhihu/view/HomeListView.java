package me.fangx.zhihu.view;

import me.fangx.zhihu.modle.entity.ArticleListEntity;

/**
 * Created by fangxiao on 16/1/5.
 */
public interface HomeListView extends MvpView {

    void refresh(ArticleListEntity data);

    void loadMore(ArticleListEntity data);

}
