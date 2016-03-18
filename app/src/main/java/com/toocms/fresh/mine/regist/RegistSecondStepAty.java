package com.toocms.fresh.mine.regist;

import android.os.Bundle;
import android.view.View;

import com.lidroid.xutils.view.annotation.event.OnClick;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;
import com.toocms.fresh.mine.usercenter.UserCenterActiy;

/**
 * 注册第一步
 */
public class RegistSecondStepAty extends BaseAty {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar.hide();

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.mine_regist_step2;
    }

    @Override
    protected void initialized() {

    }

    @Override
    protected void requestData() {

    }

    @Override
    @OnClick({R.id.back,R.id.next_step})
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.back:
                this.finish();
                break;
            case R.id.next_step:
                startActivity(UserCenterActiy.class,null);
                break;

        }

    }
}
