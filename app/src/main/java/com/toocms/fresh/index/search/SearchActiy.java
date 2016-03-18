package com.toocms.fresh.index.search;

import android.os.Bundle;
import android.view.View;

import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;
import com.toocms.fresh.index.promotion.PromotionAdapter;

import cn.zero.android.common.view.pulltorefresh.PullToRefreshBase;
import cn.zero.android.common.view.pulltorefresh.PullToRefreshListView;

/**
 * Created by Administrator on 2016/3/3.
 */
public class SearchActiy extends BaseAty{





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActionBar.hide();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.index_search;
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
    @OnClick({R.id.back})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                this.finish();
                break;
        }
    }
}
