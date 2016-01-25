package me.fangx.zhihu.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.Bind;
import me.fangx.common.util.eventbus.EventCenter;
import me.fangx.zhihu.R;
import me.fangx.zhihu.adapter.FollowPagerAdapter;

/**
 * Created by fangxiao on 15/12/28.
 * <p/>
 * 关注
 */
public class FollowFragment extends BaseFragment {

    @Bind(R.id.follow_content)
    LinearLayout follow_content;
    @Bind(R.id.follow_pager_tabs)
    TabLayout follow_pager_tabs;
    @Bind(R.id.follow_pager)
    ViewPager follow_pager;

    @Override
    protected void initViewsAndEvents() {

        follow_pager.setOffscreenPageLimit(FollowPagerAdapter.PAGE_COUNT);
        FollowPagerAdapter adapter = new FollowPagerAdapter(getSupportFragmentManager());
        follow_pager.setAdapter(adapter);
        follow_pager_tabs.setupWithViewPager(follow_pager);

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.follow_layout;
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
        return follow_content;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

}
