package me.fangx.zhihu.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import me.fangx.common.ui.fragment.BaseLazyFragment;
import me.fangx.common.util.log.LogUtil;
import me.fangx.zhihu.modle.manager.DataManager;
import me.fangx.zhihu.view.MvpView;


/**
 * The base class for all fragment classes.
 * <p/>
 * Created by Andreas Schrade on 14.12.2015.
 */
public abstract class BaseFragment extends BaseLazyFragment implements MvpView {

    private static final String TAG = "BaseFragment";

//    /**
//     * Inflates the layout and binds the view via ButterKnife.
//     *
//     * @param inflater  the inflater
//     * @param container the layout container
//     * @param layout    the layout resource
//     * @return the inflated view
//     */
//    public View inflateAndBind(LayoutInflater inflater, ViewGroup container, int layout) {
//        View view = inflater.inflate(layout, container, false);
//        ButterKnife.bind(this,view);
//        LogUtil.d(TAG, ">>> view inflated");
//        return view;
//    }


    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

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
