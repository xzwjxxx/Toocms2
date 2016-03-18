package com.toocms.fresh.index.message;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;

import java.util.Map;

import cn.zero.android.common.view.pulltorefresh.PullToRefreshListView;

/**
 * Created by Administrator on 2016/3/4.
 */
public class MessageDetailAty extends BaseAty {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActionBar.setTitle("我的消息");

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.index_message_detail_acty;
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
    public void onError(Map<String, String> error) {

        super.onError(error);
    }

    @Override
    @OnClick({})
    public void onClick(View v) {

        switch (v.getId()){



        }

    }


//    /**
//     * 设置适配器
//     */
//    private class MyAdapter extends BaseAdapter {
//
//        private ViewHolder viewHolder;
//        @Override
//        public int getCount() {
//            return 10;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return position;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//
//            if (convertView == null) {
//                viewHolder = new ViewHolder();
//                convertView = LayoutInflater.from(MessageDetailAty.this).inflate(R.layout.index_message_item,parent,false);
//                ViewUtils.inject(viewHolder, convertView);
//                convertView.setTag(viewHolder);
//            } else {
//                viewHolder = (ViewHolder) convertView.getTag();
//            }
//            return convertView;
//        }
//        private class ViewHolder {
//
//
//
//        }
//
//
//    }


}
