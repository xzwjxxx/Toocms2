package com.toocms.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.toocms.frame.image.ImageLoader;
import com.toocms.fresh.R;

import java.util.List;
import java.util.Map;

import cn.zero.android.common.util.ListUtils;

/**
 * 右侧二级分类适配器
 *
 * @author Zero
 * @date 2016/1/16 9:17
 */
public class RightAdapter extends BaseAdapter {

    private Context context;
    private ViewHolder viewHolder;
    private List<Map<String, String>> list;

    private ImageLoader imageLoader;

    public RightAdapter(Context context, List<Map<String, String>> list) {
        this.context = context;
        this.list = list;
        imageLoader = new ImageLoader(context, R.drawable.ic_default_96_96);
    }

    public void setSource(List<Map<String, String>> list) {
        this.list = list;
        notifyDataSetChanged();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.listitem_classification_right, parent, false);
            ViewUtils.inject(viewHolder, convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        imageLoader.disPlay(viewHolder.imageView, map.get("icon"));
        viewHolder.textView.setText(map.get("name"));
        return convertView;
    }

    private class ViewHolder {
        @ViewInject(R.id.listitem_classification_right_logo)
        public ImageView imageView;
        @ViewInject(R.id.listitem_classification_right_text)
        public TextView textView;
    }
}
