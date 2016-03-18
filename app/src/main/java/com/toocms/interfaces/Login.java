package com.toocms.interfaces;

import com.lidroid.xutils.http.RequestParams;
import com.toocms.frame.web.ApiListener;
import com.toocms.frame.web.ApiTool;
import com.toocms.config.AppConfig;

/**
 * 用户登录
 *
 * @author Zero
 * @date 2016/1/28 10:14
 */
public class Login {

    private String module = this.getClass().getSimpleName(); // 模块名

    /**
     * 用户登录
     *
     * @param account     用户名
     * @param password    密码
     * @param apiListener
     */
    public void login(String account, String password, ApiListener apiListener) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("account", account);
        params.addBodyParameter("password", password);
        ApiTool apiTool = new ApiTool();
        apiTool.postApi(AppConfig.BASE_URL + module + "/login", params, apiListener);
    }

    /**
     * 找回密码第一步
     *
     * @param account     手机号
     * @param verify      验证码
     * @param apiListener
     */
    public void retrieve_1(String account, String verify, ApiListener apiListener) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("account", account);
        params.addBodyParameter("verify", verify);
        ApiTool apiTool = new ApiTool();
        apiTool.postApi(AppConfig.BASE_URL + module + "/retrieve_1", params, apiListener);
    }

    /**
     * 找回密码第二步
     *
     * @param m_id        用户id
     * @param password    密码
     * @param re_password 确认密码
     * @param apiListener
     */
    public void retrieve_2(String m_id, String password, String re_password, ApiListener apiListener) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("m_id", m_id);
        params.addBodyParameter("password", password);
        params.addBodyParameter("re_password", re_password);
        ApiTool apiTool = new ApiTool();
        apiTool.postApi(AppConfig.BASE_URL + module + "/retrieve_2", params, apiListener);
    }

    /**
     * 找回密码验证码，修改绑定手机第一步获取验证码
     *
     * @param account     手机号
     * @param apiListener
     */
    public void retrieve(String account, ApiListener apiListener) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("account", account);
        ApiTool apiTool = new ApiTool();
        apiTool.postApi(AppConfig.BASE_URL + module + "/retrieve", params, apiListener);
    }

    /**
     * 第三方登录
     *
     * @param openid      第三方标识id
     * @param type        登录类型 （1 第三方）
     * @param nickname    第三方昵称
     * @param apiListener
     */
    public void otherLogin(String openid, String type, String nickname, ApiListener apiListener) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("openid", openid);
        params.addBodyParameter("type", type);
        params.addBodyParameter("nickname", nickname);
        ApiTool apiTool = new ApiTool();
        apiTool.postApi(AppConfig.BASE_URL + module + "/otherLogin", params, apiListener);
    }
}
