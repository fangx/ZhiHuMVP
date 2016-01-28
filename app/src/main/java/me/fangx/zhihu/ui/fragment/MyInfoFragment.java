package me.fangx.zhihu.ui.fragment;

import android.view.View;

import me.fangx.common.util.eventbus.EventCenter;
import me.fangx.zhihu.R;

/**
 * Created by fangxiao on 16/1/27.
 */
public class MyInfoFragment extends BaseFragment {

    public static MyInfoFragment newInstance() {
        MyInfoFragment fragment = new MyInfoFragment();
        return fragment;
    }

    public MyInfoFragment() {
    }

    @Override
    protected void initViewsAndEvents() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.my_info_layout;
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
        return null;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }
}
