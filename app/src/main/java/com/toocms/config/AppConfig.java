package com.toocms.config;

import com.toocms.frame.tool.AppManager;

import cn.zero.android.common.util.PreferencesUtils;

/**
 * APP配置
 *
 * @author Zero
 * @date 2016/1/22 10:34
 */
public class AppConfig {

    /**
     * 主URL
     */
    public static final String BASE_URL = "http://shengxian.toocms.com/index.php/Api/";

    /**
     * 购物车角标数量+1
     */
    public static final void plusCartNum() {
        int cart_num = PreferencesUtils.getInt(AppManager.getInstance().getTopActivity(), Constants.CART_NUM, 0);
        PreferencesUtils.putInt(AppManager.getInstance().getTopActivity(), Constants.CART_NUM, ++cart_num);
    }

    /**
     * 购物车角标数量-1
     */
    public static final void reduceCartNum() {
        int cart_num = PreferencesUtils.getInt(AppManager.getInstance().getTopActivity(), Constants.CART_NUM, 0);
        if (cart_num == 0) return;
        PreferencesUtils.putInt(AppManager.getInstance().getTopActivity(), Constants.CART_NUM, --cart_num);
    }

    /**
     * 购物车角标数量增加固定数值
     *
     * @param num
     */
    public static final void plusCartFixedNum(int num) {
        int cart_num = PreferencesUtils.getInt(AppManager.getInstance().getTopActivity(), Constants.CART_NUM, 0);
        PreferencesUtils.putInt(AppManager.getInstance().getTopActivity(), Constants.CART_NUM, cart_num + num);
    }

    /**
     * 购物车角标数量减少固定数值
     *
     * @param num
     */
    public static final void reduceCartFixedNum(int num) {
        int cart_num = PreferencesUtils.getInt(AppManager.getInstance().getTopActivity(), Constants.CART_NUM, 0);
        if (cart_num == 0) return;
        PreferencesUtils.putInt(AppManager.getInstance().getTopActivity(), Constants.CART_NUM, cart_num - num);
    }

    /**
     * 获取购物车角标数量
     */
    public static final int getCartNum() {
        return PreferencesUtils.getInt(AppManager.getInstance().getTopActivity(), Constants.CART_NUM, 0);
    }
}
