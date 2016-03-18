package com.toocms.fresh.mine.regist;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;

/**
 * 注册第一步
 */
public class RegistFirstStepAty extends BaseAty {

    private TimeCount time;
    @ViewInject(R.id.mine_regist_getcode)
    private TextView tvGetCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar.hide();

        time = new TimeCount(60000, 1000);//构造CountDownTimer对象

    }




    @Override
    protected int getLayoutResId() {
        return R.layout.mine_regist_step1;
    }

    @Override
    protected void initialized() {

    }

    @Override
    protected void requestData() {

    }

    @Override
    @OnClick({R.id.back,R.id.next_step,R.id.mine_regist_getcode})
    public void onClick(View v) {

        int id=v.getId();
        if(id==R.id.back){
            this.finish();
        }else if(id==R.id.next_step){
            startActivity(RegistSecondStepAty.class,null);
        }else if(id==R.id.mine_regist_getcode){
            time.start();//开始计时
        }
    }


    /**
     * 获取验证码
     */
    private void getVerification(){

    }


    class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);//参数依次为总时长,和计时的时间间隔
        }

        @Override
        public void onFinish() {//计时完毕时触发
            tvGetCode.setText("重新验证");
            tvGetCode.setClickable(true);
        }

        @Override
        public void onTick(long millisUntilFinished) {//计时过程显示
            tvGetCode.setClickable(false);
            tvGetCode.setText(millisUntilFinished / 1000 + "秒");
        }

    }

}
