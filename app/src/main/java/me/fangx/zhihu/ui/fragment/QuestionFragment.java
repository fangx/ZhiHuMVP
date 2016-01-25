package me.fangx.zhihu.ui.fragment;

import android.os.Bundle;
import android.view.View;

import me.fangx.common.ui.fragment.BaseLazyFragment;
import me.fangx.common.util.eventbus.EventCenter;

/**
 * Created by fangxiao on 15/12/28.
 */
public class QuestionFragment extends BaseFragment {
    @Override
    protected void initViewsAndEvents() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return 0;
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
