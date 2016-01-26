package me.fangx.zhihu.presenter;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import me.fangx.zhihu.modle.http.HomeListService;
import me.fangx.zhihu.modle.http.utils.RetrofitUtils;
import me.fangx.zhihu.modle.bean.ArticleListBean;
import me.fangx.zhihu.modle.entity.ArticleListEntity;
import me.fangx.zhihu.utils.BaseUtil;
import me.fangx.zhihu.view.HomeListView;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by fangxiao on 16/1/5.
 */
public class HomePresenter extends BasePresenter<HomeListView> {

    private static final String tag = "growthhacker";

    public static final int LIMIT = 10;

    private HomeListService homeListService;
    private Subscription mSubscription;

    public HomePresenter(Context context) {
        homeListService = RetrofitUtils.createApi(context, HomeListService.class);
    }

    @Override
    public void attachView(HomeListView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSubscription != null) mSubscription.unsubscribe();
    }


    public void loadList(final int page) {
        checkViewAttached();

        String date = BaseUtil.getNYYMMDD(1 - page);

        int offset = (page - 1) * LIMIT;

        mSubscription = homeListService.getHomeArticleList(tag, LIMIT, offset)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<ArticleListBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showError(e.getMessage(), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        });
                    }

                    @Override
                    public void onNext(List<ArticleListBean> articleListBeanList) {
                        for (ArticleListBean articleListBean : articleListBeanList) {
                            articleListBean.setSummary(BaseUtil.delHTMLTag(articleListBean.getSummary()));
                            articleListBean.setContent(BaseUtil.delHTMLTag(articleListBean.getContent()));
                        }
                        if (page == 1) {
                            getMvpView().refresh(articleListBeanList);
                        } else {
                            getMvpView().loadMore(articleListBeanList);
                        }
                    }
                });

    }


    //数据缓存
    private void saveDataToDBorSP(ArticleListEntity articleListEntity) {

    }


}
