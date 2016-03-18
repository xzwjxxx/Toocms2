package com.toocms.fresh.index.recharge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;
import com.toocms.fresh.index.promotion.PromotionAdapter;

import cn.zero.android.common.view.FButton;
import cn.zero.android.common.view.actionitembadge.ActionItemBadge;
import cn.zero.android.common.view.pulltorefresh.PullToRefreshBase;
import cn.zero.android.common.view.pulltorefresh.PullToRefreshListView;

/**
 * Created by Administrator on 2016/3/3.
 */
public class RechargeActiy extends BaseAty{


    @ViewInject(android.R.id.list)
    private GridView mGridView;

    @ViewInject(R.id.recharge_next)
    private FButton payNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar.setTitle("账户充值");

        payNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(PayActiy.class,null);

            }
        });

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.index_recharge_actiy;
    }

    @Override
    protected void initialized() {

    }

    @Override
    protected void requestData() {

        setRechargeMoney();

    }

    @Override
    public void onComplete(String requestUrl, ResponseInfo<String> responseInfo) {
        super.onComplete(requestUrl, responseInfo);

    }

    /**
     * 设置充值金额
     */
    private void setRechargeMoney(){

        mGridView.setAdapter(new MoneyAdapter());

    }

    class MoneyAdapter extends BaseAdapter{

        public MoneyAdapter(){


        }


        @Override
        public int getCount() {
            return 8;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView= LayoutInflater.from(RechargeActiy.this).inflate(R.layout.index_recharge_money_griditem,parent,false);

            return convertView;
        }
    }



}
