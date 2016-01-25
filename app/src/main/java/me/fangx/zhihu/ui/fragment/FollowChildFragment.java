package me.fangx.zhihu.ui.fragment;

import android.view.View;
import android.widget.LinearLayout;

import butterknife.Bind;
import me.fangx.common.util.eventbus.EventCenter;
import me.fangx.zhihu.R;

/**
 * Created by fangxiao on 16/1/25.
 */
public class FollowChildFragment extends BaseFragment {

    @Bind(R.id.follow_child_content)
    LinearLayout follow_child_content;


    @Override
    protected void initViewsAndEvents() {
        showEmpty(getResources().getString(R.string.drawer_follow_empty), new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        }, R.drawable.img_empty_follow);

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.follow_child_layout;
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
        return follow_child_content;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

}
