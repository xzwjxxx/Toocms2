package com.toocms.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.toocms.frame.tool.Toolkit;
import com.toocms.fresh.R;

/**
 * 导航
 *
 * @author Zero
 * @date 2016/1/14 15:21
 */
public class NavigationAdapter extends BaseAdapter {

    private Context context;
    private String[] texts;
    private String[] logos;

    private ViewHolder viewHolder;

    public NavigationAdapter(Context context, String[] texts, String[] logos) {
        this.context = context;
        this.texts = texts;
        this.logos = logos;
    }

    @Override
    public int getCount() {
        return texts.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.listitem_index_navigation, parent, false);
            ViewUtils.inject(viewHolder, convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(texts[position]);
        viewHolder.textView.setCompoundDrawablesWithIntrinsicBounds(0, Toolkit.getBitmapRes(context, logos[position]), 0, 0);
        return convertView;
    }

    private class ViewHolder {
        @ViewInject(R.id.listitem_index_navigation_item)
        public TextView textView;
    }
}