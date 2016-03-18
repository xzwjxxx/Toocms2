package com.toocms.interfaces;

import com.lidroid.xutils.http.RequestParams;
import com.toocms.frame.web.ApiListener;
import com.toocms.frame.web.ApiTool;
import com.toocms.config.AppConfig;

/**
 * 购物下单
 *
 * @author Zero
 * @date 2016/1/29 9:26
 */
public class Flow {

    private String module = this.getClass().getSimpleName(); // 模块名

    /**
     * 添加购物车
     *
     * @param m_id        会员id
     * @param goods_id    商品id
     * @param buy_number  购买数量
     * @param apiListener
     */
    public void addCart(String m_id, String goods_id, String buy_number, ApiListener apiListener) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("m_id", m_id);
        params.addBodyParameter("goods_id", goods_id);
        params.addBodyParameter("buy_number", buy_number);
        ApiTool apiTool = new ApiTool();
        apiTool.postApi(AppConfig.BASE_URL + module + "/addCart", params, apiListener);
    }

    /**
     * 清理购物车
     *
     * @param m_id
     * @param cart_ids
     * @param apiListener
     */
    public void clearCart(String m_id, String cart_ids, ApiListener apiListener) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("m_id", m_id);
        params.addBodyParameter("cart_ids", cart_ids);
        ApiTool apiTool = new ApiTool();
        apiTool.postApi(AppConfig.BASE_URL + module + "/clearCart", params, apiListener);
    }

    /**
     * 增加购物数量
     *
     * @param cart_id     购物车id
     * @param buy_number  减少数量
     * @param apiListener
     */
    public void cartInc(String cart_id, String buy_number, ApiListener apiListener) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("cart_id", cart_id);
        params.addBodyParameter("buy_number", buy_number);
        ApiTool apiTool = new ApiTool();
        apiTool.postApi(AppConfig.BASE_URL + module + "/cartInc", params, apiListener);
    }

    /**
     * 减少购买数量
     *
     * @param cart_id     购物车id
     * @param buy_number  减少数量
     * @param apiListener
     */
    public void cartDec(String cart_id, String buy_number, ApiListener apiListener) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("cart_id", cart_id);
        params.addBodyParameter("buy_number", buy_number);
        ApiTool apiTool = new ApiTool();
        apiTool.postApi(AppConfig.BASE_URL + module + "/cartDec", params, apiListener);
    }

    /**
     * 购物车列表
     *
     * @param m_id
     * @param apiListener
     */
    public void cartList(String m_id, ApiListener apiListener) {
        RequestParams params = new RequestParams();
        params.addQueryStringParameter("m_id", m_id);
        ApiTool apiTool = new ApiTool();
        apiTool.getApi(AppConfig.BASE_URL + module + "/cartList", params, apiListener);
    }
}
