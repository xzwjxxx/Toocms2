package com.toocms.interfaces;

import android.text.TextUtils;

import com.lidroid.xutils.http.RequestParams;
import com.toocms.config.AppConfig;
import com.toocms.frame.web.ApiListener;
import com.toocms.frame.web.ApiTool;

/**
 * 商品
 *
 * @author Zero
 * @date 2016/1/29 11:59
 */
public class Goods {

    private String module = this.getClass().getSimpleName(); // 模块名

    /**
     * 分类
     *
     * @param apiListener
     */
    public void cateList(ApiListener apiListener) {
        RequestParams params = new RequestParams();
        ApiTool apiTool = new ApiTool();
        apiTool.getApi(AppConfig.BASE_URL + module + "/cateList", params, apiListener);
    }

    /**
     * 商品列表
     *
     * @param goods_name  搜索商品时传
     * @param cate_id     获取分类下的商品时传
     * @param p           分页
     * @param price       desc降序 asc升序
     * @param volume      desc降序 asc升序
     * @param promotion   desc降序 asc升序
     * @param m_id        登陆状态下搜索商品时传
     * @param apiListener
     */
    public void goodsLists(String goods_name, String cate_id, int p, String price, String volume, String promotion, String m_id, ApiListener apiListener) {
        RequestParams params = new RequestParams();
        if (!TextUtils.isEmpty(goods_name))
            params.addQueryStringParameter("goods_name", goods_name);
        if (!TextUtils.isEmpty(cate_id))
            params.addQueryStringParameter("cate_id", cate_id);
        params.addQueryStringParameter("p", String.valueOf(p));
        if (!TextUtils.isEmpty(price))
            params.addQueryStringParameter("price", price);
        if (!TextUtils.isEmpty(volume))
            params.addQueryStringParameter("volume", volume);
        if (!TextUtils.isEmpty(promotion))
            params.addQueryStringParameter("promotion", promotion);
        if (!TextUtils.isEmpty(m_id))
            params.addQueryStringParameter("m_id", m_id);
        ApiTool apiTool = new ApiTool();
        apiTool.getApi(AppConfig.BASE_URL + module + "/goodsLists", params, apiListener);
    }

    /**
     * 商品详情
     *
     * @param goods_id
     * @param apiListener
     */
    public void detail(String goods_id, String m_id, ApiListener apiListener) {
        RequestParams params = new RequestParams();
        params.addQueryStringParameter("goods_id", goods_id);
        if (!TextUtils.isEmpty(m_id))
            params.addQueryStringParameter("m_id", m_id);
        ApiTool apiTool = new ApiTool();
        apiTool.getApi(AppConfig.BASE_URL + module + "/detail", params, apiListener);
    }

    /**
     * 促销商品
     *
     * @param apiListener
     */
    public void promotion(int p, ApiListener apiListener) {
        RequestParams params = new RequestParams();
        params.addQueryStringParameter("p", String.valueOf(p));
        ApiTool apiTool = new ApiTool();
        apiTool.getApi(AppConfig.BASE_URL + module + "/promotion", params, apiListener);
    }

    /**
     * 热销排行
     *
     * @param apiListener
     */
    public void hot(int p, ApiListener apiListener) {
        RequestParams params = new RequestParams();
        params.addQueryStringParameter("p", String.valueOf(p));
        ApiTool apiTool = new ApiTool();
        apiTool.getApi(AppConfig.BASE_URL + module + "/hot", params, apiListener);
    }

    /**
     * 获取热门搜索
     *
     * @param apiListener
     */
    public void searchLog(ApiListener apiListener) {
        RequestParams params = new RequestParams();
        ApiTool apiTool = new ApiTool();
        apiTool.getApi(AppConfig.BASE_URL + module + "/searchLog", params, apiListener);
    }
}
