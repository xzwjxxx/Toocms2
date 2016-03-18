package com.toocms.fresh.mine.order;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.toocms.frame.ui.BaseFragment;
import com.toocms.fresh.R;

import cn.zero.android.common.view.linearlistview.LinearListView;
import cn.zero.android.common.view.pulltorefresh.PullToRefreshListView;

public class OrderFragment extends BaseFragment {

    private static final String TAG = "TestFragment";
    private boolean isclick=false;

    static OrderFragment newInstance(String s) {
        OrderFragment newFragment = new OrderFragment();
        Bundle bundle = new Bundle();
        bundle.putString("hello", s);
        newFragment.setArguments(bundle);

        //bundle还可以在每个标签里传送数据
        return newFragment;
    }

    private View view;
    @ViewInject(android.R.id.list)
    private PullToRefreshListView refreshListView;
    private OrderAdapter orderAdapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListViewAdapter();

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.myorder_fragment;
    }

    @Override
    protected void initialized() {

    }

    @Override
    protected void requestData() {


    }

    /**
     * 设置适配器
     */
    private void setListViewAdapter() {

        orderAdapter = new OrderAdapter();
        refreshListView.setAdapter(orderAdapter);
        orderAdapter.notifyDataSetChanged();

    }


    private class OrderAdapter extends BaseAdapter {

        private ViewHolder viewHolder;

        public OrderAdapter() {

        }

        @Override
        public int getCount() {
            return 10;
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
                convertView = LayoutInflater.from(getContext()).inflate( R.layout.myorder_fragment_listitem,parent,false);
                ViewUtils.inject(viewHolder, convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            OrderDetailAdapter orderDetailAdapter = new OrderDetailAdapter();
                viewHolder.listView.setAdapter(orderDetailAdapter);
            viewHolder.ordernumber.setText("订单号：18393358049");

            MyClickListener myClickListener=new MyClickListener();
            viewHolder.refund.setOnClickListener(myClickListener);
            viewHolder.refund.setOnClickListener(myClickListener);

            return convertView;
        }

        private class ViewHolder {

            @ViewInject(R.id.linear_listview)
            public LinearListView listView;
            @ViewInject(R.id.myorder_order_number)
            public TextView ordernumber;
            @ViewInject(R.id.myorder_order_refund)
            public TextView refund;
            @ViewInject(R.id.myorder_order_payment)
            private TextView payment;

        }


        class MyClickListener implements View.OnClickListener{

            @Override
            public void onClick(View v) {

                v.setBackgroundResource(R.drawable.order_refund_bg);

            }
        }


        /**
         * 订单详情适配器
         */
        private class OrderDetailAdapter extends BaseAdapter {

            private ViewHolder viewHolder;
            @Override
            public int getCount() {
                return 2;
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
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.myorder_listitem_detail,parent,false);
                    ViewUtils.inject(viewHolder, convertView);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }
                return convertView;
            }
            private class ViewHolder {
                @ViewInject(R.id.myoder_detail_image)
                public ImageView imageView;

            }


        }
    }
}


