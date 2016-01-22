package me.fangx.common.ui.activity;

import android.support.v7.widget.Toolbar;

/**
 * Created by fangxiao on 16/1/13.
 */
public abstract class BaseToolBarActivity extends BaseAppCompatActivity {

    public abstract boolean providesActivityToolbar();


    public void setToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}
