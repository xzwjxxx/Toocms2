package com.toocms.fresh.mine.order;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;
import com.toocms.fresh.mine.MineFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/3/8.
 */
public class MyOrderAty extends BaseAty {

    public static String TAB_DAIFUKUAN="代付款";
    public static String TAB_DAIJIEDAN="待接单";
    public static String TAB_DAIFAHUO="代发货";
    public static String TAB_PEISONGZHONG="配送中";

    private String flag;

    private ViewPager mPager;
    private ArrayList<Fragment> fragmentList;

    @ViewInject(R.id.cursor)
    private TextView barText;
    private int currIndex;//当前页卡编号

    /**
     * tab样式
     * @param savedInstanceState
     */
    @ViewInject(R.id.myorder_layout)
    private LinearLayout myorderTabLayout;//tab布局


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar.hide();
        getBundleData();
        InitTextBar();
        InitViewPager();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.mine_order;
    }

    @Override
    protected void initialized() {

    }

    @Override
    protected void requestData() {

    }

    @Override
    @OnClick({R.id.back, R.id.myorder_whole, R.id.myorder_no_pay, R.id.myorder_payying, R.id.myorder_payfinish, R.id.myorder_paycancle})
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.back:
                this.finish();
                break;
            case R.id.myorder_whole:
                mPager.setCurrentItem(0);
                break;
            case R.id.myorder_no_pay:
                mPager.setCurrentItem(1);
                break;
            case R.id.myorder_payying:
                mPager.setCurrentItem(2);
                break;
            case R.id.myorder_payfinish:
                mPager.setCurrentItem(3);
                break;
            case R.id.myorder_paycancle:
                mPager.setCurrentItem(4);
                break;

        }

    }

    /*
            * 初始化图片的位移像素
            */
    public void InitTextBar(){
        barText = (TextView) super.findViewById(R.id.cursor);
        Display display = getWindow().getWindowManager().getDefaultDisplay();
        // 得到显示屏宽度
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        // 1/3屏幕宽度
        int  tabLineLength = metrics.widthPixels /5;
        LayoutParams lp = (LayoutParams) barText.getLayoutParams();
        lp.width = tabLineLength;
        barText.setLayoutParams(lp);

    }


    /*
	     * 初始化ViewPager
	     */
    public void InitViewPager(){
        mPager = (ViewPager)findViewById(R.id.viewpager);
        fragmentList = new ArrayList<Fragment>();
        Fragment orderFragment1= OrderFragment.newInstance("xxxxxxxxxxxxxxxx");
        Fragment orderFragment2= OrderFragment.newInstance("xxxxxxxxxxxxxxxx");
        Fragment orderFragment3= OrderFragment.newInstance("xxxxxxxxxxxxxxxx");
        Fragment orderFragment4= OrderFragment.newInstance("xxxxxxxxxxxxxxxx");
        Fragment orderFragment5= OrderFragment.newInstance("xxxxxxxxxxxxxxxx");

        fragmentList.add(orderFragment1);
        fragmentList.add(orderFragment2);
        fragmentList.add(orderFragment3);
        fragmentList.add(orderFragment4);
        fragmentList.add(orderFragment5);


        //给ViewPager设置适配器
        mPager.setAdapter(new MyOrderFragmentPagerAdapter(getSupportFragmentManager(), fragmentList));
        if(TAB_DAIFUKUAN.equals(flag)){
            currIndex=1;
            mPager.setCurrentItem(currIndex);
        }else if(TAB_DAIJIEDAN.equals(flag)){
            currIndex=2;
            mPager.setCurrentItem(currIndex);
        }else if(TAB_DAIFAHUO.equals(flag)){
            currIndex=3;
            mPager.setCurrentItem(currIndex);
        }else if(TAB_PEISONGZHONG.equals(flag)){
            currIndex=4;
            mPager.setCurrentItem(currIndex);
        }else{
            mPager.setCurrentItem(0);//设置当前显示标签页为第一页
        }
        mPager.setOnPageChangeListener(new MyOnPageChangeListener());//页面变化时的监听器
    }


    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub
            // 取得该控件的实例
            LinearLayout.LayoutParams ll = (android.widget.LinearLayout.LayoutParams) barText.getLayoutParams();

            if(currIndex == arg0){
                ll.leftMargin = (int) (currIndex * barText.getWidth() + arg1 * barText.getWidth());
            }else if(currIndex > arg0){
                ll.leftMargin = (int) (currIndex * barText.getWidth() - (1 - arg1)* barText.getWidth());
            }
            barText.setLayoutParams(ll);
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageSelected(int arg0) {
            // TODO Auto-generated method stub
            currIndex = arg0;
            int i = currIndex + 1;
        }
    }


    /**
     * 获取Bundle数据
     */
    private void getBundleData(){

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            flag=bundle.getString(MineFragment.MINE_KEY);
        }

    }


}
