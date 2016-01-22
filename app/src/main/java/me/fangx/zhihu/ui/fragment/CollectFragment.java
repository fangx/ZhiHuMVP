package me.fangx.zhihu.ui.fragment;

import android.view.View;
import android.widget.LinearLayout;

import butterknife.Bind;
import me.fangx.common.ui.fragment.BaseLazyFragment;
import me.fangx.common.util.eventbus.EventCenter;
import me.fangx.zhihu.R;

/**
 * Created by fangxiao on 15/12/28.
 *
 * 收藏
 *
 */
public class CollectFragment extends BaseFragment {

    @Bind(R.id.collect_content)
    LinearLayout collect_content;


    @Override
    protected void initViewsAndEvents() {

        showEmpty(getResources().getString(R.string.drawer_collect_empty), new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        }, R.drawable.img_empty_collection);

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.collect_layout;
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
        return collect_content;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }


}
