package com.toocms.config;

import android.os.CountDownTimer;
import android.widget.TextView;

import com.toocms.frame.tool.AppManager;

import cn.zero.android.common.util.PreferencesUtils;

/**
 * APP倒计时处理
 *
 * @author Zero
 * @date 2016/1/22 10:28
 */
public class AppCountdown extends CountDownTimer {

    private TextView textView;
    private static long surplusTime; // 剩余时间

    private static AppCountdown appCountdown;

    public static AppCountdown getInstance() {
        surplusTime = PreferencesUtils.getLong(AppManager.getInstance().getTopActivity(), "STOP_TIME") - System.currentTimeMillis();
        appCountdown = new AppCountdown();
        return appCountdown;
    }

    private AppCountdown() {
        super(surplusTime > 0 ? surplusTime : 59999, 1000);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        surplusTime = millisUntilFinished;
        textView.setText(millisUntilFinished / 1000 + "s后重新发送");
    }

    @Override
    public void onFinish() {
        textView.setText("重新获取");
        textView.setEnabled(true);
    }

    private void saveStopTime() {
        PreferencesUtils.putLong(AppManager.getInstance().getTopActivity(), "STOP_TIME", System.currentTimeMillis() + surplusTime);
    }

    public void play(TextView textView) {
        this.textView = textView;
        if (surplusTime > 0) {
            textView.setEnabled(false);
            start();
        } else {
            textView.setText("获取验证码");
            textView.setEnabled(true);
        }
    }

    public void stop() {
        saveStopTime();
        cancel();
    }

}
