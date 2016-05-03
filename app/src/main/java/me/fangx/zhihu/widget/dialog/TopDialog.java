package me.fangx.zhihu.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;

import me.fangx.zhihu.R;
import me.fangx.zhihu.widget.dialog.BaseDialog;

/**
 * Created by fangxiao on 16/3/11.
 */
public class TopDialog extends BaseDialog {


    /**
     * method execute order:
     * show:constrouctor---show---oncreate---onStart---onAttachToWindow
     * dismiss:dismiss---onDetachedFromWindow---onStop
     *
     * @param context
     */
    public TopDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stage_dialog_layout);
        init();
    }


    private void init() {

        Window window = this.getWindow();
        window.setGravity(Gravity.CENTER); // 此处可以设置dialog显示的位置
        window.setWindowAnimations(R.style.stagedialogstyle); // 添加动画

    }


}
