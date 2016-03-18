package com.toocms.fresh.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.toocms.frame.config.Config;
import com.toocms.frame.image.ImageLoader;
import com.toocms.frame.ui.BaseFragment;
import com.toocms.fresh.R;
import com.toocms.fresh.mine.address.AddressAty;
import com.toocms.fresh.mine.collection.MyCollectionActiy;
import com.toocms.fresh.mine.coupon.MyCouponAty;
import com.toocms.fresh.mine.feedback.FeedBackAty;
import com.toocms.fresh.mine.login.LoginActiy;
import com.toocms.fresh.mine.order.MyOrderAty;
import com.toocms.fresh.mine.setting.SettingAty;
import com.toocms.fresh.mine.usercenter.UserCenterActiy;
import com.toocms.fresh.mine.wallet.MyWalletAty;

import cn.zero.android.common.view.RoundedImageView;


public class MineFragment extends BaseFragment {


    public static final String MINE_KEY = "mine_fragmne";

    /**
     * 未登录状态
     *
     * @param savedInstanceState
     */
    @ViewInject(R.id.mine_head_normal)
    private TextView headNormal;
    @ViewInject(R.id.mine_head_layout)
    private RelativeLayout headlayout;
    @ViewInject(R.id.mine_head_image)
    private RoundedImageView headImage;
    @ViewInject(R.id.mine_nick_name)
    private TextView nickname;


    private ImageLoader imageLoader;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onResume() {
        super.onResume();
        if (Config.isLogin()) {
            headlayout.setVisibility(View.VISIBLE);
            imageLoader.disPlay(headImage,application.getUserInfo().get("head"),null);
            nickname.setText(application.getUserInfo().get("nickname"));
        }else {
            headlayout.setVisibility(View.GONE);
        }

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.mine_fragment;
    }

    @Override
    protected void initialized() {

        imageLoader = new ImageLoader(getContext(), R.drawable.mine_head_image_normal);

    }

    @Override
    protected void requestData() {


    }


    @Override
    public void onComplete(String requestUrl, ResponseInfo<String> responseInfo) {

        super.onComplete(requestUrl, responseInfo);

    }


    @Override
    @OnClick({R.id.mine_head_image,R.id.mine_head_normal, R.id.mine_setting, R.id.mine_daifukuan, R.id.mine_daijiedan, R.id.mine_daifahuo,
            R.id.mine_peisongzhong, R.id.mine_order, R.id.mine_wallet, R.id.mine_address,
            R.id.mine_collect, R.id.mine_coupon, R.id.mine_feedback})
    public void onClick(View v) {
        Bundle bundle = null;
        switch (v.getId()) {
            case R.id.mine_head_normal:
                startActivity(LoginActiy.class, null);
                break;
            case R.id.mine_head_image:
                startActivity(UserCenterActiy.class, null);
                break;
            case R.id.mine_setting:
                startActivity(SettingAty.class, null);
                break;
            case R.id.mine_daifukuan:
                bundle = new Bundle();
                bundle.putString(MINE_KEY, MyOrderAty.TAB_DAIFUKUAN);
                startActivity(MyOrderAty.class, bundle);
                break;
            case R.id.mine_daijiedan:
                bundle = new Bundle();
                bundle.putString(MINE_KEY, MyOrderAty.TAB_DAIJIEDAN);
                startActivity(MyOrderAty.class, bundle);
                break;
            case R.id.mine_daifahuo:
                bundle = new Bundle();
                bundle.putString(MINE_KEY, MyOrderAty.TAB_DAIFAHUO);
                startActivity(MyOrderAty.class, bundle);
                break;
            case R.id.mine_peisongzhong:
                bundle = new Bundle();
                bundle.putString(MINE_KEY, MyOrderAty.TAB_PEISONGZHONG);
                startActivity(MyOrderAty.class, bundle);
                break;
            case R.id.mine_order:
                startActivity(MyOrderAty.class, null);
                break;
            case R.id.mine_wallet:
                startActivity(MyWalletAty.class, null);
                break;
            case R.id.mine_address:
                startActivity(AddressAty.class, null);
                break;
            case R.id.mine_collect:
                startActivity(MyCollectionActiy.class, null);
                break;
            case R.id.mine_coupon:
                startActivity(MyCouponAty.class, null);
                break;
            case R.id.mine_feedback:
                startActivity(FeedBackAty.class, null);
                break;

        }

    }
}
