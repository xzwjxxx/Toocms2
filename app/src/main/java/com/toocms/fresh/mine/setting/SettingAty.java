package com.toocms.fresh.mine.setting;

import android.os.Bundle;
import android.view.View;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.toocms.frame.config.Config;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;
import com.toocms.view.LinearLayoutItem;

/**
 * Created by Administrator on 2016/3/7.
 */
public class SettingAty extends BaseAty {

    /**
     * 自定义控件
     * @param savedInstanceState
     */
    @ViewInject(R.id.mine_setting_clear_buffer)
    private LinearLayoutItem clearBuffer;
    @ViewInject(R.id.mine_setting_user_help)
    private LinearLayoutItem userHelp;
    @ViewInject(R.id.mine_setting_about_me)
    private LinearLayoutItem aboutMe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar.hide();

        setCustomData();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.mine_setting;
    }

    @Override
    protected void initialized() {

    }

    @Override
    protected void requestData() {

    }


    @Override
    @OnClick({R.id.mine_setting_connection_me,R.id.back,R.id.mine_setting_clear_buffer,
            R.id.mine_setting_user_help,R.id.mine_setting_about_me,R.id.fbtn_login_out})
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.back:
                this.finish();
                break;
            case R.id.mine_setting_connection_me:
                break;
            case R.id.mine_setting_clear_buffer:
                break;
            case R.id.mine_setting_user_help:
                break;
            case R.id.mine_setting_about_me:
                startActivity(AboutMeAty.class,null);
                break;
            case R.id.fbtn_login_out:
                Config.setLoginState(false);
                this.finish();
                break;

        }

    }

    /**
     * 设置自定义控件数据
     */
   private void setCustomData(){

       this.clearBuffer.setData("清除缓存","",R.drawable.mine_head_right);
       this.userHelp.setData("使用帮助","",R.drawable.mine_head_right);
       this.aboutMe.setData("关于我们","",R.drawable.mine_head_right);

    }
}
