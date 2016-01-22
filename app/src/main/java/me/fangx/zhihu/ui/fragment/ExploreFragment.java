package me.fangx.zhihu.ui.fragment;

import android.view.View;
import android.widget.LinearLayout;

import butterknife.Bind;
import me.fangx.common.ui.fragment.BaseLazyFragment;
import me.fangx.common.util.eventbus.EventCenter;
import me.fangx.zhihu.R;

/**
 * Created by fangxiao on 15/12/28.
 * <p/>
 * 发现
 */
public class ExploreFragment extends BaseFragment {

    @Bind(R.id.explore_content)
    LinearLayout explore_content;


    @Override
    protected void initViewsAndEvents() {
        showEmpty("暂无发现", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
