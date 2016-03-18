package com.toocms.fresh.mine.coupon;

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

import cn.zero.android.common.view.pulltorefresh.PullToRefreshListView;

/**
 * Created by Administrator on 2016/3/7.
 */
public class MyCouponAty extends BaseAty {


    @ViewInject(android.R.id.list)
    private PullToRefreshListView mListview;
    private MyCouponAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar.setTitle("我的优惠券");

        myAdapter = new MyCouponAdapter();
        mListview.setAdapter(myAdapter);

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.mine_mycoupon_actiy;
    }

    @Override
    protected void initialized() {

    }

    @Override
    protected void requestData() {

    }


    /**
     * 订单详情适配器
     */
    class MyCouponAdapter extends BaseAdapter {

        private ViewHolder viewHolder;

        public MyCouponAdapter() {


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
                convertView = LayoutInflater.from(MyCouponAty.this).inflate(R.layout.mine_mycoupon_listitem, parent, false);
                ViewUtils.inject(viewHolder, convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            return convertView;
        }

        public class ViewHolder {


        }


    }


}
