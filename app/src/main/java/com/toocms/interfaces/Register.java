package com.toocms.interfaces;

import com.lidroid.xutils.http.RequestParams;
import com.toocms.config.AppConfig;
import com.toocms.frame.web.ApiListener;
import com.toocms.frame.web.ApiTool;

/**
 * 注册
 *
 * @author Zero
 * @date 2016/1/27 17:57
 */
public class Register {

    private String module = this.getClass().getSimpleName(); // 模块名

    /**
     * 注册短信验证码
     *
     * @param account     手机号
     * @param apiListener
     */
    public void smsVerify(String account, ApiListener apiListener) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("account", account);
        ApiTool apiTool = new ApiTool();
        apiTool.postApi(AppConfig.BASE_URL + module + "/smsVerify", params, apiListener);
    }

    /**
     * 用户注册第一步
     *
     * @param account     手机号
     * @param verify      验证码
     * @param apiListener
     */
    public void register_1(String account, String verify, ApiListener apiListener) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("account", account);
        params.addBodyParameter("verify", verify);
        ApiTool apiTool = new ApiTool();
        apiTool.postApi(AppConfig.BASE_URL + module + "/register_1", params, apiListener);
    }

    /**
     * 用户注册第二步，修改绑定手机第二步获取验证码
     *
     * @param account     手机号
     * @param password    密码
     * @param re_password 确认密码
     * @param apiListener
     */
    public void register_2(String account, String password, String re_password, ApiListener apiListener) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("account", account);
        params.addBodyParameter("password", password);
        params.addBodyParameter("re_password", re_password);
        ApiTool apiTool = new ApiTool();
        apiTool.postApi(AppConfig.BASE_URL + module + "/register_2", params, apiListener);
    }
}
