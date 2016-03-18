package com.toocms.interfaces;

import com.lidroid.xutils.http.RequestParams;
import com.toocms.frame.web.ApiListener;
import com.toocms.frame.web.ApiTool;
import com.toocms.config.AppConfig;

import java.io.File;

/**
 * 个人信息
 *
 * @author Zero
 * @date 2016/1/28 11:46
 */
public class Member {

    private String module = this.getClass().getSimpleName(); // 模块名

    /**
     * 修改昵称
     *
     * @param m_id        会员id
     * @param nickname    昵称
     * @param apiListener
     */
    public void editNickname(String m_id, String nickname, ApiListener apiListener) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("m_id", m_id);
        params.addBodyParameter("nickname", nickname);
        ApiTool apiTool = new ApiTool();
        apiTool.postApi(AppConfig.BASE_URL + module + "/editNickname", params, apiListener);
    }

    /**
     * 修改头像
     *
     * @param m_id        会员id
     * @param head        头像
     * @param apiListener
     */
    public void editHead(String m_id, File head, ApiListener apiListener) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("m_id", m_id);
        params.addBodyParameter("head", head);
        ApiTool apiTool = new ApiTool();
        apiTool.postApi(AppConfig.BASE_URL + module + "/editHead", params, apiListener);
    }

    /**
     * 添加或移除收藏
     *
     * @param collector
     * @param collect
     * @param apiListener
     */
    public void addCollect(String collector, String collect, ApiListener apiListener) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("collector", collector);
        params.addBodyParameter("collect", collect);
        ApiTool apiTool = new ApiTool();
        apiTool.postApi(AppConfig.BASE_URL + module + "/addCollect", params, apiListener);
    }

}
