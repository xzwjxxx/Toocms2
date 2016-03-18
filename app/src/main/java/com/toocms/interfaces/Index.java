package com.toocms.interfaces;

import com.lidroid.xutils.http.RequestParams;
import com.toocms.frame.web.ApiListener;
import com.toocms.frame.web.ApiTool;
import com.toocms.config.AppConfig;

/**
 * 首页
 *
 * @author Zero
 * @date 2016/1/25 17:12
 */
public class Index {

    private String module = this.getClass().getSimpleName(); // 模块名

    /**
     * 首页
     *
     * @param apiListener
     */
    public void index(ApiListener apiListener) {
        RequestParams params = new RequestParams();
        ApiTool apiTool = new ApiTool();
        apiTool.getApi(AppConfig.BASE_URL + module + "/index", params, apiListener);
    }

}
