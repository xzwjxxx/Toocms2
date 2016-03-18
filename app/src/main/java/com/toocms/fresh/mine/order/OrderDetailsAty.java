package com.toocms.fresh.mine.order;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;
import com.toocms.fresh.mine.address.AddressAty;
import com.toocms.fresh.mine.coupon.MyCouponAty;

import cn.zero.android.common.view.linearlistview.LinearListView;

/**
 * Created by Administrator on 2016/3/8.
 */
public class OrderDetailsAty extends BaseAty {


    /**
     * 初始化控件
     *
     * @param savedInstanceState
     */
    @ViewInject(android.R.id.list)
    private LinearListView listView;
    private MyAdapter adapter;

    /**
     * 时间选择
     *
     * @param savedInstanceState
     */
    @ViewInject(R.id.myorder_send_time_select)
    private RadioGroup mRadioGroup;
    private boolean isClicked = false;

    /**
     * 送货时间
     *
     * @param savedInstanceState
     */
    @ViewInject(R.id.myorder_send_time_show)
    private TextView tvTimeShow;

    /**
     * 支付方式
     * @param savedInstanceState
     */
    @ViewInject(R.id.myoder_detail_paystyle_num)
    private TextView tvPayStyleShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar.hide();
        getBundleData();
        setOrderData();
        createSendTime();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.myorder_details_acty;
    }

    @Override
    protected void initialized() {

    }

    @Override
    protected void requestData() {

    }

    @Override
    @OnClick({R.id.back, R.id.myorder_create_address_layout, R.id.myorder_create_send_time, R.id.myoder_detail_coupon,
            R.id.myoder_detail_couponstyle, R.id.myoder_detail_paylayout})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                this.finish();
                break;
            case R.id.myorder_create_address_layout:
                startActivity(AddressAty.class, null);
                break;
            case R.id.myorder_create_send_time:
                if (!isClicked) {
                    mRadioGroup.setVisibility(View.VISIBLE);
                } else {
                    mRadioGroup.setVisibility(View.GONE);
                }
                isClicked = !isClicked;
                break;
            case R.id.myoder_detail_coupon:
                startActivity(MyCouponAty.class, null);
                break;
            case R.id.myoder_detail_couponstyle:
                break;
            case R.id.myoder_detail_paylayout:
                createPayDialog();
                break;

        }
    }

    /**
     * 设置订单数据
     */
    private void setOrderData() {
        adapter = new MyAdapter();
        listView.setAdapter(adapter);

    }

    /**
     * 动态添加送货时间
     */
    private void createSendTime() {

        for (int i = 0; i < 10; i++) {
            RadioButton tempButton = new RadioButton(this);
            tempButton.setText((8 + i) + ":00" + "—" + (8 + (i + 2)) + ":00");
            //tempButton.setBackgroundResource(R.drawable.xxx);   // 设置RadioButton的背景图片
            tempButton.setButtonDrawable(R.drawable.radio_button_checked);           // 设置按钮的样式
            tempButton.setPadding(20, 20, 0, 20); // 设置文字距离按钮四周的距离
            tempButton.setTextSize(16);
            mRadioGroup.addView(tempButton, LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        }

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                RadioButton tempButton = (RadioButton) findViewById(checkedId); // 通过RadioGroup的findViewById方法，找到ID为checkedID的RadioButton
                //对这个RadioButton进行处理了
                tvTimeShow.setText("" + tempButton.getText().toString());
            }
        });
    }


    /**
     * 支付弹出对话框
     */
    private void createPayDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("支付方式");
        //    指定下拉列表的显示数据
        final String[] style = {"在线支付", "货到付款"};
        //    设置一个下拉的列表选择项
        builder.setItems(style, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tvPayStyleShow.setText(""+style[which]);
            }
        });
        builder.show();

    }

    /**
     * 获取Bundle数据
     */
    private void getBundleData() {


    }


    /**
     * 设置适配器
     */

    class MyAdapter extends BaseAdapter {

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
                convertView = LayoutInflater.from(OrderDetailsAty.this).inflate(R.layout.myorder_listitem_detail, parent, false);
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
