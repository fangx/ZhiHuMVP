package me.fangx.zhihu.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.Bind;
import me.fangx.common.util.eventbus.EventCenter;
import me.fangx.zhihu.R;
import me.fangx.zhihu.adapter.ExplorePagerAdapter;

/**
 * Created by fangxiao on 16/1/25.
 */
public class ExploreChildFragment extends BaseFragment {

    @Bind(R.id.explore_child_content)
    LinearLayout explore_child_content;

    //页面标识
    private String tag = "";

    @Override
    protected void initViewsAndEvents() {
        Bundle bundle = getArguments();
        tag = bundle.getString(ExplorePagerAdapter.EXPLORE_TAG);
        showEmpty("暂无" + tag, new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.explore_child_layout;
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
        return explore_child_content;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

}
