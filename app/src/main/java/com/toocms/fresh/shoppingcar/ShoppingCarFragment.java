package com.toocms.fresh.shoppingcar;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.toocms.frame.ui.BaseFragment;
import com.toocms.fresh.R;
import com.toocms.fresh.mine.order.OrderDetailsAty;

import cn.zero.android.common.view.FButton;


public class ShoppingCarFragment extends BaseFragment {


    /**
     * listview,適配器
     *
     * @param savedInstanceState
     */
    @ViewInject(android.R.id.list)
    private ListView listView;
    private ShoppingCarAdapter mShoppingCarAdapter;

    /**
     * 结算button
     */
    @ViewInject(R.id.cart_fbtn)
    private FButton fButton;

    /**
     * 编辑
     *
     * @param savedInstanceState
     */
    @ViewInject(R.id.shopping_car_edit)
    private TextView carEdit;
    private boolean isEditState=false;//编辑状态
    private boolean isChecked=true;

    @ViewInject(R.id.shopping_car_price_layout)
    private LinearLayout priceLayout;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    protected int getLayoutResId() {
        return R.layout.shoppigcar_fragment;
    }

    @Override
    protected void initialized() {


    }

    @Override
    protected void requestData() {


        initListView();

    }


    @Override
    public void onComplete(String requestUrl, ResponseInfo<String> responseInfo) {

        super.onComplete(requestUrl, responseInfo);

    }


    /**
     * 設置適配器
     */
    private void initListView() {

        this.mShoppingCarAdapter = new ShoppingCarAdapter(getActivity());

        listView.setAdapter(mShoppingCarAdapter);

    }


    @Override
    @OnClick({R.id.shopping_car_edit,R.id.cart_fbtn})
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.shopping_car_edit:

                if(isEditState){
                    carEdit.setText("编辑");
                    priceLayout.setVisibility(View.VISIBLE);
                    fButton.setText("去结算");
                    fButton.setButtonColor(Color.parseColor("#ff9c00"));
                }else{
                    carEdit.setText("完成");
                    priceLayout.setVisibility(View.GONE);
                    fButton.setText("删除");
                    fButton.setButtonColor(Color.parseColor("#e60012"));
                }
                isEditState=!isEditState;
                mShoppingCarAdapter.notifyDataSetChanged();
                break;
            case R.id.cart_fbtn:
                if(!isEditState){
                    startActivity(OrderDetailsAty.class,null);
                }
                break;

        }

    }


    /**
     * 适配器
     */
    class ShoppingCarAdapter extends BaseAdapter {

        private Context context;

        public ShoppingCarAdapter(Context context) {

            this.context = context;

        }

        /**
         * 设置数据
         */
        public void setData() {


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
        public View getView(int position, View view, ViewGroup parent) {

             ViewHolder holder = null;

            if (view == null) {

                holder = new ViewHolder();

                view = LinearLayout.inflate(context, R.layout.shoppigcar_listitem, null);

                ViewUtils.inject(holder,view);

                view.setTag(holder);

            } else {

                holder = (ViewHolder) view.getTag();

            }

            if(isEditState){

                holder.goodNum.setVisibility(View.GONE);
                holder.editStateLayout.setVisibility(View.VISIBLE);

            }else{

                holder.goodNum.setVisibility(View.VISIBLE);
                holder.editStateLayout.setVisibility(View.GONE);

            }

            holder.checkState.setOnClickListener(new myClickListener(holder));

            return view;
        }


        class ViewHolder {

            @ViewInject(R.id.shopping_cart_edit_state)
            private LinearLayout editStateLayout;
            @ViewInject(R.id.shopping_car_item_number)
            private TextView goodNum;
            @ViewInject(R.id.shopping_car_lititem_checkbox)
            private ImageView checkState;

        }

        private class myClickListener implements View.OnClickListener{

            private ViewHolder holder;

           public  myClickListener(ViewHolder holder){

               this.holder=holder;
            }


            @Override
            public void onClick(View v) {

                if(isChecked){

                    holder.checkState.setBackgroundResource(R.drawable.ic_cart_cbox_checked);

                }else {

                    holder.checkState.setBackgroundResource(R.drawable.ic_cart_cbox_normal);
                }

                isChecked=!isChecked;

            }
        }

    }

    }
