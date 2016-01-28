package me.fangx.zhihu.ui.fragment;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import me.fangx.common.ui.activity.BaseAppCompatActivity;
import me.fangx.common.ui.activity.BaseToolBarActivity;
import me.fangx.common.util.eventbus.EventCenter;
import me.fangx.zhihu.R;
import me.fangx.zhihu.modle.bean.ArticleListBean;
import me.fangx.zhihu.utils.DummyContent;

/**
 * Shows the quote detail page.
 * <p/>
 * Created by Andreas Schrade on 14.12.2015.
 */
public class ArticleDetailFragment extends BaseFragment {

    public static final String ARG_ITEM_INFO = "item_info";
    private ArticleListBean articleListBean;

    @Bind(R.id.appbar)
    AppBarLayout appbar;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.author)
    TextView author;

    @Bind(R.id.tv_content)
    TextView tv_content;

    @Bind(R.id.backdrop)
    SimpleDraweeView backdropImg;

    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_article_detail;
    }

    @Override
    protected void initViewsAndEvents() {

        if (getArguments().containsKey(ARG_ITEM_INFO)) {
            articleListBean = getArguments().getParcelable(ARG_ITEM_INFO);
        }

        setHasOptionsMenu(true);


        if (!((BaseToolBarActivity) getActivity()).providesActivityToolbar()) {
            ((BaseToolBarActivity) getActivity()).setToolbar(toolbar);
        }

        if (articleListBean != null) {
            loadBackdrop();
            collapsingToolbar.setTitle(articleListBean.getTitle());
            author.setText(articleListBean.getAuthor().getName());
            tv_content.setText(articleListBean.getContent());
        }

        // AppBar的监听
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int maxScroll = appBarLayout.getTotalScrollRange();
                float percentage = (float) Math.abs(verticalOffset) / (float) maxScroll;
                toolbar.setBackgroundColor(Color.argb((int) (percentage * 255), 19, 121, 214));
            }
        });


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

    private void loadBackdrop() {
        if (!TextUtils.isEmpty(articleListBean.getTitleImage())) {
            backdropImg.setImageURI(Uri.parse(articleListBean.getTitleImage()));
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.sample_actions, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // your logic
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static ArticleDetailFragment newInstance(ArticleListBean articleListBean) {
        ArticleDetailFragment fragment = new ArticleDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ArticleDetailFragment.ARG_ITEM_INFO, articleListBean);
        fragment.setArguments(args);
        return fragment;
    }

    public ArticleDetailFragment() {
    }

}
