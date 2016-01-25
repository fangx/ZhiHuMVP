package me.fangx.zhihu.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import me.fangx.zhihu.ui.fragment.ExploreChildFragment;

/**
 * Created by fangxiao on 16/1/25.
 */
public class ExplorePagerAdapter extends FragmentStatePagerAdapter {

    public static final int PAGE_COUNT = 4;

    public static final String[] EX_TITLES = {"热门推荐", "热门收藏", "本月热榜", "今日推荐"};

    public static final String EXPLORE_TAG = "explore_tag";

    public ExplorePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Bundle bundle = new Bundle();
        Fragment newFragment = new ExploreChildFragment();
        bundle.putString(EXPLORE_TAG, EX_TITLES[i]);
        newFragment.setArguments(bundle);
        return newFragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return EX_TITLES[position];
    }
}
