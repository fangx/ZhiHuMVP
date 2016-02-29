package me.fangx.zhihu.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;

import com.melnykov.fab.FloatingActionButton;

import me.fangx.zhihu.ui.fragment.ExploreChildFragment;

/**
 * Created by fangxiao on 16/1/25.
 */
public class ExplorePagerAdapter extends FragmentStatePagerAdapter {

    public static final int PAGE_COUNT = 3;

    public static final String[] EX_TITLES = {"推荐", "热门", "收藏"};

    public static final String EXPLORE_TAG = "explore_tag";

    private FloatingActionButton explore_fab;

    public ExplorePagerAdapter(FragmentManager fm ,FloatingActionButton explore_fab) {
        super(fm);
        this.explore_fab = explore_fab;
    }

    @Override
    public Fragment getItem(int i) {
        Bundle bundle = new Bundle();
        ExploreChildFragment newFragment = new ExploreChildFragment();
        newFragment.setExplore_fab(explore_fab);
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


    public ExploreChildFragment getFB(int position) {
        if (getItem(position) != null) {
            return (ExploreChildFragment) getItem(position);
        } else {
            return null;
        }
    }

}
