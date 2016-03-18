package com.toocms.dialog;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.toocms.frame.tool.Commonly;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;
import com.toocms.fresh.mine.login.SetNewPasswordAty;
import com.toocms.fresh.mine.regist.RegistFirstStepAty;
import com.toocms.interfaces.Login;
import com.toocms.view.TabUI;

import java.util.Map;

/**
 * Created by Administrator on 2016/3/4.
 */
public class UITableActiy extends BaseAty {


    @ViewInject(R.id.uitable_acty_ui)
    private TabUI tabui;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActionBar.setTitle("自定义菜单");

        tabui.addItem(0,"left","right",R.drawable.mine_head_right);
        tabui.addItem(0,"left","right",R.drawable.mine_head_right);
        tabui.addItem(R.drawable.mine_head,"left","right",R.drawable.mine_head_right);
        tabui.addItem(R.drawable.mine_head,"left","right",R.drawable.mine_head_right);
        tabui.addItem(R.drawable.mine_head,"left","right",R.drawable.mine_head_right);
        tabui.addItem(R.drawable.mine_head,"left","right",R.drawable.mine_head_right);

        tabui.commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_uitable,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_uitable:
                // create intent to perform web search for this planet
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, getSupportActionBar().getTitle());
                // catch event that there's no activity to handle intent
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {

                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.uitable_acty;
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
    public void onError(Map<String, String> error) {

        super.onError(error);
    }

    @Override
    @OnClick({})
    public void onClick(View v) {

        switch (v.getId()){



        }

    }
}
