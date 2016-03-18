package com.toocms.fresh.mine.login;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.toocms.frame.config.Config;
import com.toocms.frame.tool.Commonly;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;
import com.toocms.fresh.mine.regist.RegistFirstStepAty;
import com.toocms.fresh.recycleview.RecycleViewAty;
import com.toocms.interfaces.Login;
import com.toocms.dialog.UITableActiy;

import java.util.Map;

import cn.zero.android.common.util.JSONUtils;

/**
 * Created by Administrator on 2016/3/4.
 */
public class LoginActiy extends BaseAty {

    private Login login;

    /**
     * 注册
     * @param savedInstanceState
     */
    @ViewInject(R.id.mine_regist_tv)
    private TextView registTv;

    /**
     * 登录信息
     * @param savedInstanceState
     */
    @ViewInject(R.id.login_username)
    private EditText etUserName;
    @ViewInject(R.id.login_password)
    private EditText etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar.hide();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.mine_login;
    }

    @Override
    protected void initialized() {

        this.login=new Login();
    }

    @Override
    protected void requestData() {

    }

    @Override
    public void onComplete(String requestUrl, ResponseInfo<String> responseInfo) {

//        Log.i("MYLOG：","登陆返回值："+responseInfo.result);

        if(requestUrl.contains("Login/login")){
            showToast(JSONUtils.parseKeyAndValueToMap(responseInfo.result).get("message"));
            Config.setLoginState(true);
            application.setUserInfo(JSONUtils.parseDataToMap(responseInfo.result));
            this.finish();

        }
        super.onComplete(requestUrl, responseInfo);
    }

    @Override
    public void onError(Map<String, String> error) {

        super.onError(error);
    }

    @Override
    @OnClick({R.id.back,R.id.mine_regist_tv,R.id.mine_forget_password,R.id.mine_login,R.id.mine_qqLogin,R.id.mine_weixinLogin})
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.back:
                this.finish();
                break;
            case R.id.mine_regist_tv:
                startActivity(RegistFirstStepAty.class,null);
                break;
            case R.id.mine_forget_password:
                startActivity(SetNewPasswordAty.class,null);
                break;
            case R.id.mine_login:
                showProgressDialog();
                login.login(Commonly.getViewText(etUserName),Commonly.getViewText(etPassword),this);
                break;
            case R.id.mine_qqLogin:
                startActivity(UITableActiy.class,null);
                break;
            case R.id.mine_weixinLogin:
                startActivity(RecycleViewAty.class,null);
                break;
        }

    }
}
