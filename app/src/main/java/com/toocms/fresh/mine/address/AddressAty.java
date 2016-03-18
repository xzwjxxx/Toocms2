package com.toocms.fresh.mine.address;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.lidroid.xutils.view.annotation.event.OnItemClick;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;

import java.util.ArrayList;
import java.util.List;

import cn.zero.android.common.swipemenulistview.SwipeMenu;
import cn.zero.android.common.swipemenulistview.SwipeMenuCreator;
import cn.zero.android.common.swipemenulistview.SwipeMenuItem;
import cn.zero.android.common.swipemenulistview.SwipeMenuListView;
import cn.zero.android.common.view.pulltorefresh.PullToRefreshSwipeMenuListView;

/**
 * Created by Administrator on 2016/3/8.
 */
public class AddressAty extends BaseAty implements SwipeMenuCreator, SwipeMenuListView.OnMenuItemClickListener{

    public static String ADDRESSINFO_KEY="address_key";

    @ViewInject(android.R.id.list)
    private PullToRefreshSwipeMenuListView listView;
    private MyAdapter adapter;

    /**
     * 地址数据
     * @param savedInstanceState
     */
    private List<AddressInfo> addressInfos=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar.hide();
        listView.setEmptyView(findViewById(android.R.id.empty));
        listView.getRefreshableView().setMenuCreator(this);
        listView.getRefreshableView().setOnMenuItemClickListener(this);
        adapter = new MyAdapter(getData());
        listView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getNewAddressData();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.mine_address_acty;
    }

    @Override
    protected void initialized() {

    }

    @Override
    protected void requestData() {

    }

    @Override
    @OnItemClick(android.R.id.list)
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//        Intent mIntent = new Intent(this,AddressDetailAty.class);
//        Bundle bundle = new Bundle();
//        bundle.putSerializable(ADDRESSINFO_KEY,addressInfos.get(position));
//        mIntent.putExtras(bundle);
//        startActivity(mIntent);

    }


    @Override
    public void create(SwipeMenu menu) {
        SwipeMenuItem editItem = new SwipeMenuItem(this);
        editItem.setBackground(new ColorDrawable(Color.parseColor("#DCDCDC")));
        editItem.setWidth((int) getResources().getDimension(R.dimen.x110));
        editItem.setIcon(R.drawable.ic_address_edit);
        menu.addMenuItem(editItem);

        SwipeMenuItem deleteItem = new SwipeMenuItem(this);
        deleteItem.setBackground(new ColorDrawable(Color.parseColor("#FB4747")));
        deleteItem.setWidth((int) getResources().getDimension(R.dimen.x110));
        deleteItem.setIcon(R.drawable.ic_address_delete);
        menu.addMenuItem(deleteItem);
    }

    @Override
    public void onMenuItemClick(int position, SwipeMenu menu, int index) {
        switch (index) {
            case 0:
                Intent mIntent = new Intent(this,AddressDetailAty.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(ADDRESSINFO_KEY,addressInfos.get(position));
                mIntent.putExtras(bundle);
                startActivity(mIntent);
                break;
            case 1:
                addressInfos.remove(position);
                adapter.notifyDataSetChanged();
                break;
        }
    }


    @Override
    @OnClick({R.id.back,R.id.mine_feedback_submit})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                this.finish();
                break;
            case R.id.mine_feedback_submit:
                startActivity(AddressDetailAty.class,null);
                this.finish();
                break;
        }
    }


    /**
     * 获取数据
     */
    private List<AddressInfo> getData(){
        for(int i=0;i<10;i++){
            addressInfos.add(new AddressInfo("name"+i,"11111111"+i,"location"+i,"详细地址"+i,"0"));
        }
        return addressInfos;
    }


    /**
     * 获取新增地址数据
     */
    private void getNewAddressData(){
        AddressInfo mAddressInfo = (AddressInfo)getIntent().getSerializableExtra(ADDRESSINFO_KEY);
        if(mAddressInfo==null){
            addressInfos.add(mAddressInfo);
            adapter.notifyDataSetChanged();
        }
    }






    private class MyAdapter extends BaseAdapter {

        private List<AddressInfo> address;
        private ViewHolder viewHolder;

        public MyAdapter(List<AddressInfo> address){

            this.address=address;
        }

        @Override
        public int getCount() {
            return (address==null)?0:address.size();
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
                convertView = LayoutInflater.from(AddressAty.this).inflate(R.layout.mine_address_listitem, parent, false);
                ViewUtils.inject(viewHolder, convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            if (position == 0) viewHolder.imageView.setVisibility(View.VISIBLE);
            else viewHolder.imageView.setVisibility(View.GONE);

            viewHolder.tvName.setText(address.get(position).getName());
            viewHolder.tvPhone.setText(address.get(position).getPhone());
            viewHolder.tvAddress.setText(address.get(position).getAddress());

            return convertView;
        }

        private class ViewHolder {
            @ViewInject(R.id.listitem_address_name)
            public TextView tvName;
            @ViewInject(R.id.listitem_address_phone)
            public TextView tvPhone;
            @ViewInject(R.id.listitem_address_address)
            public TextView tvAddress;
            @ViewInject(R.id.listitem_address_default)
            public ImageView imageView;
        }
    }




}
