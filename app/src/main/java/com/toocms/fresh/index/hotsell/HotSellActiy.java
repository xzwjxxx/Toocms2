package com.toocms.fresh.index.hotsell;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;

import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;
import com.toocms.fresh.index.promotion.PromotionAdapter;
import com.toocms.interfaces.Goods;

import java.util.List;
import java.util.Map;

import cn.zero.android.common.util.JSONUtils;
import cn.zero.android.common.view.actionitembadge.ActionItemBadge;
import cn.zero.android.common.view.pulltorefresh.PullToRefreshBase;
import cn.zero.android.common.view.pulltorefresh.PullToRefreshListView;

/**
 * Created by Administrator on 2016/3/3.
 */
public class HotSellActiy extends BaseAty implements PullToRefreshListView.OnRefreshListener2{

    private List<Map<String,String>> hotData;
    private Goods goods;

    /**
     * 下拉刷新列表
     * @param savedInstanceState
     */
    @ViewInject(android.R.id.list)
    private PullToRefreshListView mRefreshListView;
    private PromotionAdapter mPromotionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActionBar.setTitle("促销");

        initListView();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.index_hotsell_actiy;
    }

    @Override
    protected void initialized() {
        goods=new Goods();
    }

    @Override
    protected void requestData() {

        showProgressContent();
        goods.hot(1,this);

    }

    @Override
    public void onComplete(String requestUrl, ResponseInfo<String> responseInfo) {
        if(requestUrl.contains("hot")){
            hotData= JSONUtils.parseDataToMapList(responseInfo.result);

            if(mPromotionAdapter!=null) {
                mPromotionAdapter.setData(hotData);
            }
        }
        super.onComplete(requestUrl, responseInfo);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_promotion, menu);
        ActionItemBadge.update(this, menu.findItem(R.id.menu_cart), getResources().getDrawable(R.drawable.menu_cart), ActionItemBadge.BadgeStyles.RED, 10);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase pullToRefreshBase) {

    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase pullToRefreshBase) {

    }


    /**
     * 初始化ListView，设置适配器
     */
    private void initListView(){

        mPromotionAdapter=new PromotionAdapter(this);

        mRefreshListView.setAdapter(mPromotionAdapter);

    }

    @Override
    @OnItemClick(android.R.id.list)
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        super.onItemClick(parent, view, position, id);

        showToast("click");

    }
}
