package com.toocms.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.toocms.fresh.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.zero.android.common.util.ListUtils;

/**
 * 左边一级分类适配器
 *
 * @author Zero
 * @date 2016/1/15 16:56
 */
public class LeftAdapter extends BaseAdapter {

    private Context context;
    private ViewHolder viewHolder;
    private List<Map<String, String>> list;

    public List<Boolean> isSelector; // 控制每个item的状态
    public int lastPosition; // 上一次点击的位置

    public LeftAdapter(Context context, List<Map<String, String>> list) {
        this.context = context;
        this.list = list;
        isSelector = new ArrayList<>();
        for (int i = 0; i < getCount(); i++) {
            isSelector.add(false);
        }
        isSelector.set(0, true);
    }

    @Override
    public int getCount() {
        return ListUtils.getSize(list);
    }

    @Override
    public Map<String, String> getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Map<String, String> map = getItem(position);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.listitem_classification_left, parent, false);
            ViewUtils.inject(viewHolder, convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (isSelector.get(position)) {
            viewHolder.flag.setVisibility(View.VISIBLE);
            viewHolder.textView.setBackgroundResource(R.drawable.bg_classification_selected);
            viewHolder.textView.setTextColor(Color.parseColor("#8fc31f"));
        } else {
            viewHolder.flag.setVisibility(View.GONE);
            viewHolder.textView.setBackgroundResource(R.drawable.bg_classification_normal);
            viewHolder.textView.setTextColor(Color.parseColor("#666666"));
        }
        viewHolder.textView.setText(map.get("name"));
        return convertView;
    }

    private class ViewHolder {
        @ViewInject(R.id.listitem_classification_left_flag)
        public View flag;
        @ViewInject(R.id.listitem_classification_left_text)
        public TextView textView;
    }
}
