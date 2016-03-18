package com.toocms.fresh.mine.wallet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;
import com.toocms.fresh.index.recharge.RechargeActiy;
import com.toocms.view.DrawableLeftCenterTextView;

/**
 * Created by Administrator on 2016/3/7.
 */
public class MyWalletAty extends BaseAty {


    @ViewInject(android.R.id.list)
    private ListView listview;
    private MyAdapter myAdapter;

    /**
     * 充值
     * @param savedInstanceState
     */
    @ViewInject(R.id.mine_wallet_recharge)
    private DrawableLeftCenterTextView recharge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar.setTitle("我的钱包");

        myAdapter=new MyAdapter();
        listview.setAdapter(myAdapter);

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.mine_mywallet;
    }

    @Override
    protected void initialized() {

    }

    @Override
    protected void requestData() {

    }

    @Override
    @OnClick({R.id.mine_wallet_recharge})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_wallet_recharge:
                startActivity(RechargeActiy.class,null);
                break;

        }

    }


    /**
     * 订单详情适配器
     */
    class MyAdapter extends BaseAdapter {

        private ViewHolder viewHolder;

        public MyAdapter(){



        }

        @Override
        public int getCount() {
            return 12;
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

            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = LayoutInflater.from(MyWalletAty.this).inflate(R.layout.mywallet_listitem,parent,false);
                ViewUtils.inject(viewHolder, convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            return convertView;
        }
        private class ViewHolder {


        }


    }


}
