package com.toocms.fresh.mine.collection;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;

import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;
import com.toocms.fresh.index.gooddetail.ShoppingDetailActiy;
import com.toocms.fresh.index.promotion.PromotionAdapter;

import cn.zero.android.common.view.actionitembadge.ActionItemBadge;
import cn.zero.android.common.view.pulltorefresh.PullToRefreshBase;
import cn.zero.android.common.view.pulltorefresh.PullToRefreshListView;

/**
 * Created by Administrator on 2016/3/3.
 */
public class MyCollectionActiy extends BaseAty implements PullToRefreshListView.OnRefreshListener2 {


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
        mActionBar.setTitle("我的收藏");

        mRefreshListView.setOnRefreshListener(this);

        initListView();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.mine_mycollection_actiy;
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
        startActivity(ShoppingDetailActiy.class,null);

    }
}
