package me.fangx.zhihu.ui.activity;

import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.drawee.view.DraweeView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import butterknife.Bind;
import me.fangx.common.ui.activity.BaseAppCompatActivity;
import me.fangx.common.util.eventbus.EventCenter;
import me.fangx.common.util.log.LogUtil;
import me.fangx.common.util.netstatus.NetUtils;
import me.fangx.zhihu.R;
import me.fangx.zhihu.adapter.NavDrawerListAdapter;
import me.fangx.zhihu.modle.bean.NavDrawerItem;
import me.fangx.zhihu.ui.fragment.CollectFragment;
import me.fangx.zhihu.ui.fragment.DraftFragment;
import me.fangx.zhihu.ui.fragment.ExploreFragment;
import me.fangx.zhihu.ui.fragment.FollowFragment;
import me.fangx.zhihu.ui.fragment.HomeListFragment;
import me.fangx.zhihu.ui.fragment.QuestionFragment;
import me.fangx.zhihu.utils.BaseUtil;
import me.fangx.zhihu.utils.NightModeHelper;

/**
 * Created by fangxiao on 15/12/01.
 */
public class HomeActivity extends BaseAppCompatActivity {

    private ListView mDrawerMenu;
    private String[] mNavMenuTitles;
    private TypedArray mNavMenuIconsTypeArray;
    private TypedArray mNavMenuIconTintTypeArray;
    private ArrayList<NavDrawerItem> mNavDrawerItems;
    private NavDrawerListAdapter mAdapter;
    private Toolbar actionBarToolbar;
    private DrawerLayout drawerLayout;
    private int position;

    @Bind(R.id.home_layout)
    FrameLayout home_layout;
    @Bind(R.id.nv_drawer_layout)
    LinearLayout nv_drawer_layout;
    @Bind(R.id.tv_change_theme)
    TextView tv_change_theme;
    @Bind(R.id.tv_setting)
    TextView tv_setting;
    @Bind(R.id.user_img)
    SimpleDraweeView user_img;


    //日夜模式切换
    private NightModeHelper nightModeHelper;


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_home;
    }

    @Override
    protected void initViewsAndEvents() {
        init();
        setupToolbar();
        setUpDrawer();
    }


    private void init() {
        nightModeHelper = new NightModeHelper(this);
        user_img.setImageURI(Uri.parse("http://fxblog.oss-cn-beijing.aliyuncs.com/avatar_img.png"));

        nv_drawer_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        tv_change_theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTheme(home_layout);
            }
        });

        tv_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    private void setupToolbar() {
        final ActionBar ab = getActionBarToolbar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    protected ActionBar getActionBarToolbar() {
        if (actionBarToolbar == null) {
            actionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
            if (actionBarToolbar != null) {
                setSupportActionBar(actionBarToolbar);
            }
        }
        return getSupportActionBar();
    }

    private void setUpDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout == null) {
            // current activity does not have a drawer.
            return;
        }
        mDrawerMenu = (ListView) findViewById(R.id.left_menu);
        mNavMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
        // nav drawer icons from resources
        mNavMenuIconsTypeArray = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);
        mNavMenuIconTintTypeArray = getResources()
                .obtainTypedArray(R.array.nav_drawer_tint);
        mNavDrawerItems = new ArrayList<NavDrawerItem>();
        for (int i = 0; i < mNavMenuTitles.length; i++) {
            mNavDrawerItems.add(new NavDrawerItem(mNavMenuTitles[i], mNavMenuIconsTypeArray
                    .getResourceId(i, -1), mNavMenuIconTintTypeArray.getResourceId(i, -1)));
        }
        mNavMenuIconsTypeArray.recycle();
        // setting the nav drawer list adapter
        mAdapter = new NavDrawerListAdapter(this,
                mNavDrawerItems);
        mDrawerMenu.setAdapter(mAdapter);
        mDrawerMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (!BaseUtil.isEmpty(mNavDrawerItems, i)) {
                    NavDrawerItem navDrawerItem = mNavDrawerItems.get(i);
                    if (navDrawerItem != null) {
                        selectItem(i, navDrawerItem.getTitle());
                    }
                }
            }
        });


        selectItem(0, mNavDrawerItems.get(0).getTitle());
    }


    protected void openDrawer() {
        if (drawerLayout == null)
            return;
        drawerLayout.openDrawer(GravityCompat.START);
    }

    protected void closeDrawer() {
        if (drawerLayout == null)
            return;
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                openDrawer();
                return true;
            case R.id.action_share:
                BaseUtil.share(this, "分享项目地址", "https://github.com/fangx/ZhiHuMVP");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

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
        return TransitionMode.FADE;
    }

    /**
     * 左侧drawer选择事件
     *
     * @param position
     * @param title
     */
    public void selectItem(int position, String title) {
        Fragment fragment = null;
        this.position = position;
        switch (position) {
            case 0:
                //首页
                fragment = new HomeListFragment();
                break;
            case 1:
                //发现
                fragment = new ExploreFragment();
                break;
            case 2:
                //关注
                fragment = new FollowFragment();
                break;
            case 3:
                //收藏
                fragment = new CollectFragment();
                break;
            case 4:
                //草稿
                fragment = new DraftFragment();
                break;
            case 5:
                //提问
                fragment = new QuestionFragment();
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content, fragment).commit();
            setTitle(title);
            closeDrawer();
        } else {
            LogUtil.e("HomeActivity", "Error in creating fragment");
        }
    }


    /**
     * 主题切换
     *
     * @param view
     */
    private void changeTheme(final View view) {

        nightModeHelper.toggle();

//        //我们先取这个根布局的 bitmap缓存 这个实际上跟截屏是差不多的一个东西。
//        view.setDrawingCacheEnabled(true);
//        view.buildDrawingCache(true);
//        final Bitmap localBitmap = Bitmap.createBitmap(view.getDrawingCache());
//        view.setDrawingCacheEnabled(false);
//
//        mengban_view.setVisibility(View.VISIBLE);
////        //我们new出来的这个蒙版view --mengbanview 就把他放到跟布局view里面 并且让他充满 同时这个view的background就是截屏前我们的那个截图bitmap
////        final View mengbanView = new View(getApplicationContext());
////        mengbanView.setBackgroundDrawable(new BitmapDrawable(getResources(), localBitmap));
////        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
////        ((FrameLayout) view).addView(mengbanView, params);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            mengban_view.setBackground(new BitmapDrawable(getResources(), localBitmap));
//        } else {
//            mengban_view.setBackgroundDrawable(new BitmapDrawable(getResources(), localBitmap));
//        }
//
//        mengban_view.animate().alpha(0).setDuration(400).setListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animator) {
//                nightModeHelper.toggle();
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animator) {
//                mengban_view.setVisibility(View.GONE);
//                localBitmap.recycle();
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animator) {
//
//            }
//        }).start();


    }

    @Override
    public void onBackPressed() {

        if (position != 0) {
            selectItem(0, mNavDrawerItems.get(0).getTitle());
        } else {
            super.onBackPressed();
        }

    }
}
