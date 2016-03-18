package com.toocms.fresh;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lidroid.xutils.view.annotation.event.OnClick;
import com.toocms.frame.tool.Toolkit;
import com.toocms.fresh.classify.ClassifyFragment;
import com.toocms.fresh.content.Content;
import com.toocms.fresh.index.IndexFragment;
import com.toocms.fresh.mine.MineFragment;
import com.toocms.fresh.shoppingcar.ShoppingCarFragment;

public class MainActivity extends BaseAty {


    public static int postion=0;
    public static TextView[] tabs = new TextView[4];

    public static String[] main_tabs_icons_normal;
    public static String[] main_tabs_icons_checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //隱藏toolbar
        mActionBar.hide();

        // 初始化底部Tab控件
        for (int i = 0; i < 4; i++) {
            tabs[i] = (TextView) findViewById(Toolkit.getViewRes(this, getResources().getStringArray(R.array.main_tabs_ids)[i]));
        }

        //默认首页
        addFragment(IndexFragment.class,null);
        selectedItem(this,0);

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initialized() {

        main_tabs_icons_normal = getResources().getStringArray(R.array.main_tabs_icons_normal);
        main_tabs_icons_checked = getResources().getStringArray(R.array.main_tabs_icons_checked);

    }

    @Override
    protected void requestData() {

    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.main_content;
    }

    /**
     * tab点击切换
     * @param v
     */
    @Override
    @OnClick({R.id.tab_index,R.id.tab_classfy,R.id.tab_shopping_car,R.id.tab_mine})
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tab_index:
                if (postion== Content.INDEX_TAB_FLAG) return;
                postion=Content.INDEX_TAB_FLAG;
                addFragment(IndexFragment.class,null);
                break;
            case R.id.tab_classfy:
                if (postion== Content.CLASSFY_TAB_FLAG) return;
                postion=Content.CLASSFY_TAB_FLAG;
                addFragment(ClassifyFragment.class,null);
                break;
            case R.id.tab_shopping_car:
                if (postion== Content.SHOPPINGCAR_TAB_FLAG) return;
                postion=Content.SHOPPINGCAR_TAB_FLAG;
                addFragment(ShoppingCarFragment.class,null);
                break;
            case R.id.tab_mine:
                if (postion== Content.MINE_TAB_FLAG) return;
                postion=Content.MINE_TAB_FLAG;
                addFragment(MineFragment.class,null);
                break;
        }

        selectedItem(this, postion);

    }

    /**
     * 选择底部标签
     *
     * @param context
     * @param position 标签标识
     */
    public void selectedItem(Context context, int position) {
        for (int i = 0; i < tabs.length; i++) {
            if (i == position) {
                tabs[i].setTextColor(Color.parseColor("#72C63C"));
                tabs[i].setCompoundDrawablesWithIntrinsicBounds(0, Toolkit.getBitmapRes(context, main_tabs_icons_checked[i]), 0, 0);
            } else {
                tabs[i].setTextColor(Color.parseColor("#5E5E5E"));
                tabs[i].setCompoundDrawablesWithIntrinsicBounds(0, Toolkit.getBitmapRes(context, main_tabs_icons_normal[i]), 0, 0);
            }
        }
    }
}
