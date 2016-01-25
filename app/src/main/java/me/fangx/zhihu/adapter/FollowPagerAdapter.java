package me.fangx.zhihu.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import me.fangx.zhihu.ui.fragment.FollowChildFragment;

/**
 * Created by fangxiao on 16/1/25.
 */
public class FollowPagerAdapter extends FragmentStatePagerAdapter {

    public static final int PAGE_COUNT = 4;

    public static final String[] FOLLOW_TITLES = {"关注的问题", "关注的收藏", "关注的话题", "关注的专栏"};

    public static final String FOLLOW_TAG = "follow_tag";

    public FollowPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Bundle bundle = new Bundle();
        Fragment newFragment = new FollowChildFragment();
        bundle.putString(FOLLOW_TAG, FOLLOW_TITLES[i]);
        newFragment.setArguments(bundle);
        return newFragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return FOLLOW_TITLES[position];
    }
}