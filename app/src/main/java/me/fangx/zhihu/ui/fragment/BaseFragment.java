package me.fangx.zhihu.ui.fragment;

import android.view.View;

import me.fangx.common.ui.fragment.BaseLazyFragment;
import me.fangx.zhihu.view.MvpView;


/**
 * The base class for all fragment classes.
 * <p/>
 * Created by Andreas Schrade on 14.12.2015.
 */
public abstract class BaseFragment extends BaseLazyFragment implements MvpView {

    private static final String TAG = "BaseFragment";

    @Override
    public void showLoading(String msg) {
          toggleShowLoading(true,msg);
    }

    @Override
    public void hideLoading() {
        toggleShowLoading(false,"");
    }

    @Override
    public void showError(String msg, View.OnClickListener onClickListener) {

    }

    @Override
    public void showEmpty(String msg, View.OnClickListener onClickListener) {
        toggleShowEmpty(true, msg, onClickListener);
    }

    @Override
    public void showEmpty(String msg, View.OnClickListener onClickListener, int imageId) {
        toggleShowEmpty(true, msg, onClickListener, imageId);
    }

    @Override
    public void showNetError(View.OnClickListener onClickListener) {

    }

}
