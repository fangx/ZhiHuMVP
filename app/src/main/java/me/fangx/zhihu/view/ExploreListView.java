package me.fangx.zhihu.view;

import java.util.List;

import me.fangx.zhihu.modle.bean.ArticleListBean;

/**
 * Created by fangxiao on 16/1/28.
 */
public interface ExploreListView extends MvpView {

    void refresh(List<ArticleListBean> data);

    void loadMore(List<ArticleListBean> data);

}