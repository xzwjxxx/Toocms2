package com.toocms.fresh.index.goodlist;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.toocms.frame.tool.Toolkit;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;
import com.toocms.fresh.index.promotion.PromotionAdapter;
import com.toocms.fresh.index.search.SearchActiy;
import com.toocms.interfaces.Goods;
import com.toocms.utils.ScreenWidthUtils;

import cn.zero.android.common.util.ScreenUtils;
import cn.zero.android.common.view.pulltorefresh.PullToRefreshBase;
import cn.zero.android.common.view.pulltorefresh.PullToRefreshListView;

/**
 * Created by Administrator on 2016/3/3.
 */
public class GoodListActiy extends BaseAty implements PullToRefreshListView.OnRefreshListener2{


    private Goods goods;

    /**
     * 下拉刷新列表
     * @param savedInstanceState
     */
    @ViewInject(android.R.id.list)
    private PullToRefreshListView mRefreshListView;
    private PromotionAdapter mPromotionAdapter;

    /**
     * 排序效果
     */
    @ViewInject(R.id.index_goodacty_xiaoliang_image)
    private ImageView promotionImage;
    @ViewInject(R.id.index_goodacty_price_image)
    private ImageView priceImage;

    /**
     * 下划线
     * @param savedInstanceState
     */
    @ViewInject(R.id.index_goodacty_line)
    private View tabLine;
    private int screenWidth=0;//屏幕宽度
    private int lineWidth=0;//线条宽度
    private int offset=0;
    private boolean isSelected=true;//是否选中

    /**
     * tab标签数组
     * @param savedInstanceState
     */
    private TextView[] tabs=new TextView[4];
    private ImageView[] imageViews=new ImageView[2];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar.hide();
        mRefreshListView.setOnRefreshListener(this);

        for(int i=0;i<tabs.length;i++){
            tabs[i]= (TextView) findViewById(Toolkit.getViewRes(this, getResources().getStringArray(R.array.goodlist_tabs_ids)[i]));
        }

        imageViews[0]=promotionImage;
        imageViews[1]=priceImage;

        transLation(this,0);
        initListView();
        initTabLine();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.index_goodactiy;
    }

    @Override
    protected void initialized() {

        goods=new Goods();
    }

    @Override
    protected void requestData() {

        showProgressContent();
//        goods.goodsLists();
    }

    @Override
    public void onComplete(String requestUrl, ResponseInfo<String> responseInfo) {
        super.onComplete(requestUrl, responseInfo);

    }


    @Override
    public void onPullDownToRefresh(PullToRefreshBase pullToRefreshBase) {

    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase pullToRefreshBase) {

    }

    @Override
    @OnClick({R.id.back,R.id.search,R.id.index_goodacty_all,R.id.index_goodacty_cuxiao,
            R.id.index_goodacty_xiaoliang_layout,R.id.index_goodacty_price_layout})
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.back:
                this.finish();
                break;
            case R.id.search:
                startActivity(SearchActiy.class,null);
                break;
            case R.id.index_goodacty_all:
                transLation(this,0);
                break;
            case R.id.index_goodacty_cuxiao:
                transLation(this,1);
                break;
            case R.id.index_goodacty_xiaoliang_layout:
                transLation(this,2);
                break;
            case R.id.index_goodacty_price_layout:
                transLation(this,3);
                break;
        }

    }
    /**
     * 初始化ListView，设置适配器
     */
    private void initListView(){

        mPromotionAdapter=new PromotionAdapter(this);

        mRefreshListView.setAdapter(mPromotionAdapter);

    }


    /**
     * 设置tab下划线
     */
    private void initTabLine(){
        this.screenWidth= ScreenWidthUtils.getWindowsWidth(this);
        ViewGroup.LayoutParams layoutParams=tabLine.getLayoutParams();
        this.offset=layoutParams.width=screenWidth/4;
        tabLine.setLayoutParams(layoutParams);
        tabLine.setPadding(offset/4,0,offset/4,0);
        tabLine.setBackgroundResource(R.color.tab_line);
    }


    /**
     * 下划线移动,标签样式
     */
    private void transLation(Context context,float i){

        tabLine.setTranslationX(i*offset);

        for (int j = 0; j < tabs.length; j++) {
            if (j == i) {
                tabs[j].setTextColor(Color.parseColor("#72C63C"));
            } else {
                tabs[j].setTextColor(Color.parseColor("#5E5E5E"));
            }
        }
        if(i>1) {

            if(isSelected){
                imageViews[0].setImageResource(R.drawable.xiaoliang_down);
                imageViews[1].setImageResource(R.drawable.xiaoliang_up);
            }else{
                imageViews[0].setImageResource(R.drawable.xiaoliang_up);
                imageViews[1].setImageResource(R.drawable.xiaoliang_down);
            }
            isSelected=!isSelected;

        }

    }



}
