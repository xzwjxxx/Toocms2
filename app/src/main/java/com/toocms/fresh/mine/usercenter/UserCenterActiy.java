package com.toocms.fresh.mine.usercenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.toocms.frame.image.ImageLoader;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;
import com.toocms.fresh.mine.login.SetNewPasswordAty;
import com.toocms.fresh.mine.regist.RegistFirstStepAty;

import cn.zero.android.common.view.RoundedImageView;

/**
 * Created by Administrator on 2016/3/4.
 */
public class UserCenterActiy extends BaseAty {

    public static final String NICKNAME="nickname";
    private static final int KEY=110;
    private ImageLoader imageLoader;

    @ViewInject(R.id.mine_head)
    private RoundedImageView headImage;
    @ViewInject(R.id.mine_user_center_nickname)
    private TextView tvNickName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar.hide();

        imageLoader.disPlay(headImage,application.getUserInfo().get("head"));

    }


    @Override
    protected void onResume() {
        super.onResume();
        tvNickName.setText(application.getUserInfo().get("nickname"));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (resultCode) { //resultCode为回传的标记，我在B中回传的是RESULT_OK
            case RESULT_OK:
                Bundle b=data.getExtras(); //data为B中回传的Intent
                String str=data.getStringExtra(NICKNAME);//str即为回传的值
                tvNickName.setText(str);
                break;
            default:
                break;
        }

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.mine_user_center;
    }

    @Override
    protected void initialized() {

        imageLoader=new ImageLoader(this,R.drawable.mine_head_image_normal);

    }

    @Override
    protected void requestData() {

    }

    @Override
    public void onComplete(String requestUrl, ResponseInfo<String> responseInfo) {
        super.onComplete(requestUrl, responseInfo);
    }


    @Override
    @OnClick({R.id.back,R.id.mine_user_center_nickname_layout})
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.back:
                this.finish();
                break;
            case R.id.mine_user_center_nickname_layout:

                Intent intent=new Intent(this,NickNameUpdateActiy.class);
                Bundle bundle=new Bundle();
                bundle.putString(NICKNAME,""+tvNickName.getText().toString());
                intent.putExtras(bundle);
                startActivityForResult(intent,KEY);
                break;
        }

    }
}
