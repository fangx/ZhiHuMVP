package me.fangx.zhihu.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import me.fangx.common.util.eventbus.EventCenter;
import me.fangx.common.widget.loading.ProgressView;
import me.fangx.haorefresh.HaoRecyclerView;
import me.fangx.haorefresh.LoadMoreListener;
import me.fangx.zhihu.R;
import me.fangx.zhihu.adapter.ExploreListAdapter;
import me.fangx.zhihu.modle.bean.ArticleListBean;
import me.fangx.zhihu.presenter.ExplorePresenter;
import me.fangx.zhihu.utils.BaseUtil;
import me.fangx.zhihu.view.ExploreListView;

/**
 * Created by fangxiao on 16/1/25.
 */
public class ExploreChildFragment extends BaseFragment implements ExploreListView {

    @Bind(R.id.explore_child_content)
    FrameLayout explore_child_content;
    @Bind(R.id.explore_swiperefresh)
    SwipeRefreshLayout explore_swiperefresh;
    @Bind(R.id.explore_recycleview)
    HaoRecyclerView explore_recycleview;



    //页面标识
    private String tag = "";

    private ExplorePresenter explorePresenter;
    private ExploreListAdapter exploreListAdapter;
    private ArrayList<ArticleListBean> listData = new ArrayList<>();
    private int page = 1;
    private FloatingActionButton explore_fab;

    public FloatingActionButton getExplore_fab() {
        return explore_fab;
    }

    public void setExplore_fab(FloatingActionButton explore_fab) {
        this.explore_fab = explore_fab;
    }

    @Override
    protected void initViewsAndEvents() {
//        Bundle bundle = getArguments();
//        tag = bundle.getString(ExplorePagerAdapter.EXPLORE_TAG);
//        showEmpty("暂无" + tag, new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        exploreListAdapter = new ExploreListAdapter(mContext, listData);
        explore_recycleview.setAdapter(exploreListAdapter);
        explore_swiperefresh.setColorSchemeResources(R.color.textBlueDark, R.color.textBlueDark, R.color.textBlueDark,
                R.color.textBlueDark);

        explore_swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 1;
                explorePresenter.loadList(page);
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        explore_recycleview.setLayoutManager(layoutManager);

        if(explore_fab != null){
            explore_fab.attachToRecyclerView(explore_recycleview);
        }

        //设置自定义加载中和到底了效果
        ProgressView progressView = new ProgressView(mContext);
        progressView.setIndicatorId(ProgressView.BallPulse);
        progressView.setIndicatorColor(0xff69b3e0);
        explore_recycleview.setFootLoadingView(progressView);

        TextView textView = new TextView(mContext);
        textView.setText("已经到底啦~");
        explore_recycleview.setFootEndView(textView);

        explore_recycleview.setLoadMoreListener(new LoadMoreListener() {
            @Override
            public void onLoadMore() {
                page++;
                explorePresenter.loadList(page);
            }
        });


        explorePresenter = new ExplorePresenter(mContext);
        explorePresenter.attachView(this);
        //初次加载
        page = 1;
        explorePresenter.loadList(page);
        showLoading("加载中...");

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.explore_child_layout;
    }


    @Override
    public void refresh(List<ArticleListBean> data) {
        //注意此处
        hideLoading();
        explore_recycleview.refreshComplete();
        explore_recycleview.loadMoreComplete();
        explore_swiperefresh.setRefreshing(false);
        listData.clear();
        listData.addAll(data);
        exploreListAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadMore(List<ArticleListBean> data) {
        if (BaseUtil.isEmpty(data)) {
            explore_recycleview.loadMoreEnd();
        } else {
            listData.addAll(data);
            exploreListAdapter.notifyDataSetChanged();
            explore_recycleview.loadMoreComplete();
        }
    }

    @Override
    protected void onFirstUserVisible() {

    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    protected void onUserInvisible() {

    }

    @Override
    protected View getLoadingTargetView() {
        return explore_swiperefresh;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

}
