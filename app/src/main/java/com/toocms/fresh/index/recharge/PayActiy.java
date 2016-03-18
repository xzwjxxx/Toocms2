package com.toocms.fresh.index.recharge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;
import com.toocms.view.LinearLayoutItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/3.
 */
public class PayActiy extends BaseAty implements View.OnClickListener {


    public static final int WEIXIN_POSTION=0;
    public static final int ZHIFUBAO_POSTION=1;
    public static final int YINLIAN_POSTION=2;
    public static int postion=0;
    /**
     * 支付方式选择
     * @param savedInstanceState
     */
    @ViewInject(R.id.pay_methods_group)
    private RadioGroup payMethods;

    private List<ImageView> imageViewList=new ArrayList<>();

    private boolean isSelected=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar.hide();
    }


    @Override
    protected int getLayoutResId() {
        return R.layout.index_recharge_pay_actiy;
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
    @OnClick(R.id.back)
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.back:
                this.finish();
                break;

        }

    }
}
