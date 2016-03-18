package com.toocms.fresh.index.gooddetail;

import android.os.Bundle;
import android.webkit.WebView;

import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;

/**
 * Created by Administrator on 2016/3/3.
 */
public class ShoppingDetailActiy extends BaseAty{


    @ViewInject(R.id.shopping_detail_webview)
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar.setTitle("商品详情");
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.index_gooddetail_actiy;
    }

    @Override
    protected void initialized() {

    }

    @Override
    protected void requestData() {

        loadWebview();

    }

    @Override
    public void onComplete(String requestUrl, ResponseInfo<String> responseInfo) {
        super.onComplete(requestUrl, responseInfo);

    }


    /**
     * 加载WebView
     */
    public void loadWebview(){

        this.webView=new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://news.iciba.com/dailysentence/");


    }


}
