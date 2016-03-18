package com.toocms.fresh.index;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.toocms.adapters.IndexCenterAdapter;
import com.toocms.adapters.IndexRecommendAdapter;
import com.toocms.adapters.MyBannerAdapter;
import com.toocms.adapters.NavigationAdapter;
import com.toocms.frame.config.Config;
import com.toocms.frame.config.Settings;
import com.toocms.frame.ui.BaseFragment;
import com.toocms.fresh.MainActivity;
import com.toocms.fresh.R;
import com.toocms.fresh.index.goodlist.GoodListActiy;
import com.toocms.fresh.index.hotsell.HotSellActiy;
import com.toocms.fresh.index.message.MessageAty;
import com.toocms.fresh.index.promotion.PromotionActiy;
import com.toocms.fresh.index.recharge.RechargeActiy;
import com.toocms.fresh.index.gooddetail.ShoppingDetailActiy;
import com.toocms.fresh.index.search.SearchActiy;
import com.toocms.interfaces.Index;
import com.toocms.view.MonitorScrollView;
import com.toocms.view.RefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.zero.android.common.util.JSONUtils;
import cn.zero.android.common.util.ListUtils;
import cn.zero.android.common.view.banner.SliderBanner;
import cn.zero.android.common.view.blocklistview.BlockListView;
import cn.zero.android.common.view.linearlistview.LinearListView;


public class IndexFragment extends BaseFragment implements LinearListView.OnItemClickListener, BlockListView.OnItemClickListener, MonitorScrollView.OnScrollListener, SwipeRefreshLayout.OnRefreshListener {



    private int space; // 推荐列表的中间间距
    private int sWidth, sHeight; // 推荐列表宽高
    private List<Map<String, String>> bannerdata; // banner数据
    private List<Map<String, String>> centerData;//中间推荐图
    private List<Map<String, String>> index_recmdgoods_list; // 商品列表
    private String[] arrayNavigationText;
    private String[] arrayNavigationLogo;
    private Index index;


    /**
     * 页面滚动控件
     */
    @ViewInject(R.id.index_custom_scrollview)
    private MonitorScrollView mMonitorScrollView;

    /**
     * Banner
     */
    @ViewInject(R.id.index_banner)
    private SliderBanner binner;
    private MyBannerAdapter bannerAdapter;

    /**
     * 中间listview
     */
    @ViewInject(R.id.index_center_listview)
    private LinearListView centerListView;
    private IndexCenterAdapter indexCenterAdapter;

    /**
     * 推荐listview
     */
    @ViewInject(R.id.index_recommend_listview)
    private BlockListView recommendListview;
    private IndexRecommendAdapter indexRecommendAdapter;

    /**
     * ToolBar设置透明度
     */
    @ViewInject(R.id.index_toobar_layout)
    private LinearLayout toolbarLayout;

    /**
     * 中间菜单
     */
    @ViewInject(R.id.index_lv_navigation)
    private LinearListView llvNavigation;
    private NavigationAdapter navigationAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //初始设置toolbar透明度
        toolbarLayout.getBackground().setAlpha(0);

        centerListView.setOnItemClickListener(this);
        mMonitorScrollView.setOnScrollListener(this);

        //中间菜单
        navigationAdapter = new NavigationAdapter(getContext(), arrayNavigationText, arrayNavigationLogo);
        llvNavigation.setAdapter(navigationAdapter);
        llvNavigation.setOnItemClickListener(this);



    }

    @Override
    protected int getLayoutResId() {
        return R.layout.index_fragment;
    }

    @Override
    protected void initialized() {
        index=new Index();
        // 推荐
        space = (int) getResources().getDimension(R.dimen.x10);
        sWidth = (Settings.displayWidth - (space * 3)) / 2;
        sHeight = (int) getResources().getDimension(R.dimen.y300);

        // 导航
        arrayNavigationText = getResources().getStringArray(R.array.index_navigation_text);
        arrayNavigationLogo = getResources().getStringArray(R.array.index_navigation_logo);

    }

    @Override
    protected void requestData() {
        showProgressContent();
        index.index(this);
    }


    @Override
    public void onComplete(String requestUrl, ResponseInfo<String> responseInfo) {

//        Log.e("mylog","首页数据："+responseInfo.result);
        if(requestUrl.contains("index")){
            Map<String, String> data = JSONUtils.parseDataToMap(responseInfo.result);
            bannerdata=JSONUtils.parseKeyAndValueToMapList(data.get("index_advert"));
//            Log.e("mylog","首页Banner数据："+bannerdata);
            centerData=JSONUtils.parseKeyAndValueToMapList(data.get("advert_list"));
//            Log.e("mylog","中间推荐图数据："+centerData);
            index_recmdgoods_list=JSONUtils.parseKeyAndValueToMapList(data.get("goods_index_list"));
            Log.e("mylog","推荐商品数据："+index_recmdgoods_list);

            setCenterListViewData(centerData);
            setRecommendListViewData(index_recmdgoods_list);
            setBannerData(bannerdata);

        }
        super.onComplete(requestUrl, responseInfo);

    }

    @Override
    public void onItemClick(LinearListView linearListView, View view, int i, long l) {

        if(linearListView==centerListView){

            startActivity(GoodListActiy.class,null);

        }else if(linearListView==llvNavigation){

            switch (i){
            case 0:
                startActivity(PromotionActiy.class,null);
                break;
            case 1:
                startActivity(HotSellActiy.class,null);
                break;
            case 2:
                startActivity(RechargeActiy.class,null);
                break;
            case 3:
                MainActivity.tabs[1].performClick();
                break;
            case 4:
                startActivity(SearchActiy.class,null);
                break;
             }

        }

    }


    /**
     * Banner设置
     */
    private void setBannerData(List<Map<String, String>> bannerdata) {
        // banner
        bannerAdapter = new MyBannerAdapter(getActivity(), bannerdata);
        binner.setAdapter(bannerAdapter);
        binner.setDotNum(ListUtils.getSize(bannerdata));
        bannerAdapter.notifyDataSetChanged();
        binner.beginPlay();


    }

    /**
     * 设置中间数据
     */
    public void setCenterListViewData(List<Map<String, String>> centerData) {

        //中间listview数据
        indexCenterAdapter = new IndexCenterAdapter(getActivity(),centerData);
        centerListView.setAdapter(indexCenterAdapter);
        indexCenterAdapter.notifyDataSetChanged();

    }

    /**
     * 设置推荐listview数据
     */
    private void setRecommendListViewData(List<Map<String, String>> index_recmdgoods_list) {
        indexRecommendAdapter = new IndexRecommendAdapter(getActivity());
        indexRecommendAdapter.setSpace(space, space);
        indexRecommendAdapter.setBlockSize(sWidth, sHeight);
        indexRecommendAdapter.setColumnNum(2);
        recommendListview.setAdapter(indexRecommendAdapter);
        indexRecommendAdapter.displayBlocks(index_recmdgoods_list);
        recommendListview.setOnItemClickListener(this);
    }

    /**
     * 推荐列表点击
     * @param view
     * @param i
     */
    @Override
    public void onItemClick(View view, int i) {

        startActivity(ShoppingDetailActiy.class,null);

    }

    /**
     * 页面滚动监听
     *
     * @param x    滚动起始点x坐标
     * @param y    滚动起始点y坐标
     * @param oldx
     * @param oldy
     */
    @Override
    public void onScroll(int x, int y, int oldx, int oldy) {

        if ((binner != null) && (binner.getHeight() > 0)) {

            int height = binner.getHeight();
            if (y < height) {

                toolbarLayout.getBackground().setAlpha((int) (new Float(y) / new Float(height) * 200));

            } else {

                toolbarLayout.getBackground().setAlpha(255);
            }

        }

        if (y <= 0) toolbarLayout.getBackground().setAlpha(0);

    }

    @Override
    public void onRefresh() {

    }


    @Override
    @OnClick({R.id.index_search,R.id.index_message})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.index_search:
                startActivity(SearchActiy.class,null);
                break;
            case R.id.index_message:
                startActivity(MessageAty.class,null);
                break;
        }

    }
}
