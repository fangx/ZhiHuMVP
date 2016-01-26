package me.fangx.zhihu.view;

import java.util.List;

import me.fangx.zhihu.modle.bean.ArticleListBean;
import me.fangx.zhihu.modle.entity.ArticleListEntity;

/**
 * Created by fangxiao on 16/1/5.
 */
public interface HomeListView extends MvpView {

    void refresh(List<ArticleListBean> data);

    void loadMore(List<ArticleListBean> data);

}
