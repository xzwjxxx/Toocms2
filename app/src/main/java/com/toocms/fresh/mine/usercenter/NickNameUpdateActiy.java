package com.toocms.fresh.mine.usercenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;

/**
 * Created by Administrator on 2016/3/4.
 */
public class NickNameUpdateActiy extends BaseAty {

    @ViewInject(R.id.mine_user_center_nickname_et)
    private EditText etNickName;

    private Intent intent;
    private String nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar.hide();

        getNickName();

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.mine_user_update_nickname;
    }

    @Override
    protected void initialized() {

    }

    @Override
    protected void requestData() {

    }

    @Override
    public void onComplete(String requestUrl, ResponseInfo<String> responseInfo) {
        super.onComplete(requestUrl, responseInfo);
    }


    @Override
    @OnClick({R.id.back,R.id.save_nickname})
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.back:
                this.finish();
                break;
            case R.id.save_nickname:
                saveNickName(etNickName.getText().toString());
                break;
        }

    }


    /**
     * 获取旧昵称，并修改
     */
    private void getNickName(){
        intent=this.getIntent();
        nickname=intent.getExtras().getString(UserCenterActiy.NICKNAME);
        etNickName.setText(""+nickname);
    }

    /**
     * 保存昵称
     */
    private void saveNickName(String nickname){
//
        intent.putExtra(UserCenterActiy.NICKNAME,nickname);
        this.setResult(RESULT_OK,intent);
        this.finish();

    }


}
