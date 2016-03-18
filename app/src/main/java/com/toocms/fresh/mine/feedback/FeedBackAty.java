package com.toocms.fresh.mine.feedback;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;
import com.toocms.fresh.mine.order.MyOrderFragmentPagerAdapter;
import com.toocms.fresh.mine.order.OrderFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/3/8.
 */
public class FeedBackAty extends BaseAty {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar.hide();

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.mine_feedback_acty;
    }

    @Override
    protected void initialized() {

    }

    @Override
    protected void requestData() {

    }

    @Override
    @OnClick({R.id.back,R.id.mine_feedback_submit})
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.back:
                this.finish();
                break;
            case R.id.mine_feedback_submit:
                showToast("提交反馈");
                break;

        }

    }

}
