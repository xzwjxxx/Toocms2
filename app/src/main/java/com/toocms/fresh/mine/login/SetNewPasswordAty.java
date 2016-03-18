package com.toocms.fresh.mine.login;

import android.os.Bundle;
import android.view.View;

import com.lidroid.xutils.view.annotation.event.OnClick;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;

/**
 * 注册第一步
 */
public class SetNewPasswordAty extends BaseAty {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar.hide();

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.mine_set_newpassword;
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

        int id=v.getId();
        if(id==R.id.back){
            this.finish();
        }else if(id==R.id.next_step){


        }
    }
}
