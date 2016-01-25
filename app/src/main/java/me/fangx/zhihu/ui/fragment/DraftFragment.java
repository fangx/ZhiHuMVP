package me.fangx.zhihu.ui.fragment;

import android.view.View;
import android.widget.LinearLayout;

import butterknife.Bind;
import me.fangx.common.util.eventbus.EventCenter;
import me.fangx.zhihu.R;

/**
 * Created by fangxiao on 15/12/28.
 * <p/>
 * 草稿
 */
public class DraftFragment extends BaseFragment {

    @Bind(R.id.draft_content)
    LinearLayout draft_content;

    @Override
    protected void initViewsAndEvents() {
        showEmpty(getResources().getString(R.string.drawer_draft_empty), new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        }, R.drawable.img_empty_draft);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.draft_layout;
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
        return draft_content;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

}
