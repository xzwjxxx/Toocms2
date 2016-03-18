package com.toocms.fresh.mine.setting;

import android.os.Bundle;
import android.view.View;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;
import com.toocms.view.LinearLayoutItem;

/**
 * Created by Administrator on 2016/3/7.
 */
public class AboutMeAty extends BaseAty {

    /**
     * 设置自定义View
     * @param savedInstanceState
     */
    @ViewInject(R.id.mine_about_me_grade)
    private LinearLayoutItem grade;
    @ViewInject(R.id.mine_about_me_protocol)
    private LinearLayoutItem protocol;
    @ViewInject(R.id.mine_about_me_version)
    private LinearLayoutItem version;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar.hide();
        setCustomView();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.mine_about_me;
    }

    @Override
    protected void initialized() {

    }

    @Override
    protected void requestData() {

    }

    @Override
    @OnClick({R.id.back,R.id.mine_about_me_grade,R.id.mine_about_me_protocol,R.id.mine_about_me_version})
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.back:
                this.finish();
                break;
            case R.id.mine_about_me_grade:
                break;
            case R.id.mine_about_me_protocol:
                break;
            case R.id.mine_about_me_version:
                break;

        }

    }

    /**
     * 设置数据
     */
   public void  setCustomView(){
       grade.setData("去评分","",R.drawable.mine_head_right);
       protocol.setData("用户使用协议","",R.drawable.mine_head_right);
       version.setData("当前版本","v1.1",R.drawable.mine_head_right);

    }



}
