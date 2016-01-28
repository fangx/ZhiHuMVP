package me.fangx.zhihu.ui.activity;

import android.os.Bundle;
import android.view.View;

import me.fangx.common.ui.activity.BaseSwipeBackCompatActivity;
import me.fangx.common.util.eventbus.EventCenter;
import me.fangx.common.util.netstatus.NetUtils;
import me.fangx.zhihu.R;
import me.fangx.zhihu.ui.fragment.MyInfoFragment;

/**
 * Created by fangxiao on 16/1/27.
 */
public class MyActivity extends BaseSwipeBackCompatActivity {

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.my_layout;
    }

    @Override
    protected void initViewsAndEvents() {
        MyInfoFragment fragment = MyInfoFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.my_content_layout, fragment).commit();
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return false;
    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return false;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return null;
    }
}
