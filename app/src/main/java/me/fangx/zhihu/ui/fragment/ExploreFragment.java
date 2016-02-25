package me.fangx.zhihu.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.melnykov.fab.FloatingActionButton;

import butterknife.Bind;
import me.fangx.common.ui.fragment.BaseLazyFragment;
import me.fangx.common.util.eventbus.EventCenter;
import me.fangx.zhihu.R;
import me.fangx.zhihu.adapter.ExplorePagerAdapter;

/**
 * Created by fangxiao on 15/12/28.
 * <p/>
 * 发现
 */
public class ExploreFragment extends BaseFragment {

    @Bind(R.id.explore_content)
    LinearLayout explore_content;
    @Bind(R.id.explore_pager_tabs)
    TabLayout explore_pager_tabs;
    @Bind(R.id.explore_pager)
    ViewPager explore_pager;
    @Bind(R.id.explore_fab)
    FloatingActionButton explore_fab;
    @Override
    protected void initViewsAndEvents() {
        explore_pager.setOffscreenPageLimit(ExplorePagerAdapter.PAGE_COUNT);
        final ExplorePagerAdapter adapter = new ExplorePagerAdapter(getSupportFragmentManager(),explore_fab);
        explore_pager.setAdapter(adapter);
        explore_pager_tabs.setupWithViewPager(explore_pager);
        explore_pager_tabs.setTabMode(TabLayout.MODE_FIXED);
        explore_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                explore_fab.show();
//                ExploreChildFragment exploreChildFragment =  adapter.getFB(position);
//                if(exploreChildFragment != null && exploreChildFragment.getExplore_recycleview() != null){
//                    explore_fab.attachToRecyclerView(exploreChildFragment.getExplore_recycleview());
//                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.explore_layout;
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
        return explore_content;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

}
