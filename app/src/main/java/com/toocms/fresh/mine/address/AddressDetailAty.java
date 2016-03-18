package com.toocms.fresh.mine.address;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.lidroid.xutils.view.annotation.event.OnItemClick;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;

import cn.zero.android.common.swipemenulistview.SwipeMenu;
import cn.zero.android.common.swipemenulistview.SwipeMenuCreator;
import cn.zero.android.common.swipemenulistview.SwipeMenuItem;
import cn.zero.android.common.swipemenulistview.SwipeMenuListView;
import cn.zero.android.common.view.pulltorefresh.PullToRefreshSwipeMenuListView;

/**
 * Created by Administrator on 2016/3/8.
 */
public class AddressDetailAty extends BaseAty{

    @ViewInject(R.id.address_name_edit)
    private EditText etName;
    @ViewInject(R.id.address_phone_edit)
    private EditText etPhone;
    @ViewInject(R.id.address_address_edit)
    private EditText etAddress;
    @ViewInject(R.id.address_doornumber_edit)
    private EditText etDoorNum;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar.hide();
        setBundleData(getBundleData());
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.mine_addressdetail_acty;
    }

    @Override
    protected void initialized() {

    }

    @Override
    protected void requestData() {

    }

    @Override
    @OnClick({R.id.back,R.id.mine_feedback_submit,R.id.address_detail_address})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                this.finish();
                break;
            case R.id.mine_feedback_submit:

                AddressInfo info=new AddressInfo(etName.getText().toString(),
                        etPhone.getText().toString(),
                        etAddress.getText().toString(),etDoorNum.getText().toString(),"");
                Intent mIntent = new Intent(this,AddressAty.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(AddressAty.ADDRESSINFO_KEY,info);
                mIntent.putExtras(bundle);
                startActivity(mIntent);
                this.finish();
                break;
            case R.id.address_detail_address:

                startActivity(BaiMapAty.class,null);

                break;

        }
    }

    /**
     * 获取传递的数据
     */
    private AddressInfo getBundleData(){

        AddressInfo mAddressInfo = (AddressInfo)getIntent().getSerializableExtra(AddressAty.ADDRESSINFO_KEY);
        if(mAddressInfo==null){
            mAddressInfo=new AddressInfo("","","","","");
        }
        return mAddressInfo;

    }

    /**
     * 讲传递的数据设置到界面上面
     */
    private void setBundleData(AddressInfo mAddressInfo){

        etName.setText(mAddressInfo.getName());
        etPhone.setText(mAddressInfo.getPhone());
        etAddress.setText(mAddressInfo.getAddress());
        etDoorNum.setText(mAddressInfo.getDetailAddress());

    }


}
