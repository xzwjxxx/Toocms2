package com.toocms.fresh.classify;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.lidroid.xutils.view.annotation.event.OnItemClick;
import com.toocms.adapters.LeftAdapter;
import com.toocms.adapters.RightAdapter;
import com.toocms.frame.ui.BaseFragment;
import com.toocms.fresh.R;
import com.toocms.fresh.index.goodlist.GoodListActiy;
import com.toocms.fresh.index.search.SearchActiy;
import com.toocms.interfaces.Goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.zero.android.common.util.JSONUtils;


public class ClassifyFragment extends BaseFragment{


    @ViewInject(R.id.classification_left)
    private ListView listView;
    private LeftAdapter leftAdapter;
    @ViewInject(R.id.classification_right)
    private GridView gridView;
    private RightAdapter rightAdapter;

    private Goods goods;
    private List<Map<String, String>> leftClass;
    private List<List<Map<String, String>>> rightClass;
    private int position; // 被选中的一级分类位置

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        getLeftData();
//        getRightData();
//        setMenuAdapter();

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.classify_fragment;
    }


    @Override
    protected void initialized() {

        goods=new Goods();
        rightClass=new ArrayList<>();
    }

    @Override
    protected void requestData() {

        showProgressContent();
        goods.cateList(this);

    }

    @Override
    @OnClick(R.id.classification_search)
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        bundle.putString("flag", "classification");
        startActivity(SearchActiy.class, bundle);
    }

    @Override
    @OnItemClick({R.id.classification_left, R.id.classification_right})
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent == listView) {
            if (position == leftAdapter.lastPosition) return;
            this.position = position;
            leftAdapter.isSelector.set(position, true);
            leftAdapter.isSelector.set(leftAdapter.lastPosition, false);
            leftAdapter.lastPosition = position;
            leftAdapter.notifyDataSetChanged();
            rightAdapter.setSource(rightClass.get(position));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("cate_id", rightClass.get(this.position).get(position).get("cate_id"));
            startActivity(GoodListActiy.class, bundle);
        }
    }

    @Override
    public void onComplete(String requestUrl, ResponseInfo<String> responseInfo) {

        Log.e("mylog","分类返回数据："+responseInfo.result);
            leftClass=JSONUtils.parseDataToMapList(responseInfo.result);
            for (Map<String, String> map: leftClass) {
                List<Map<String, String>> list = JSONUtils.parseKeyAndValueToMapList(map.get("list_two"));
                rightClass.add(list);
                leftClass.remove("list_two");
            }
            setMenuAdapter();
        super.onComplete(requestUrl, responseInfo);
    }


    /**
     * 设置适配器
     */
    private void setMenuAdapter(){

        leftAdapter = new LeftAdapter(getContext(), leftClass);
        listView.setAdapter(leftAdapter);
        rightAdapter = new RightAdapter(getContext(), rightClass.get(position));
        gridView.setEmptyView(getContext().findViewById(android.R.id.empty));
        gridView.setAdapter(rightAdapter);

    }

}
