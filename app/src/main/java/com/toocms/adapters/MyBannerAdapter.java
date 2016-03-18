package com.toocms.adapters;

/**
 * Created by Administrator on 2016/3/2.
 */

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.toocms.frame.image.ImageLoader;
import com.toocms.fresh.R;

import java.util.List;
import java.util.Map;

import cn.zero.android.common.util.ListUtils;
import cn.zero.android.common.view.banner.BannerAdapter;

/**
 * Banner
 */
public class MyBannerAdapter extends BannerAdapter {

    private ImageLoader imageLoader;
    private Context context;

    private List<Map<String, String>> bannerdata; // banner数据

    public MyBannerAdapter(Context context, List<Map<String, String>> bannerdata) {
        this.context = context;
        this.bannerdata = bannerdata;
        imageLoader = new ImageLoader(context, R.drawable.index_center_image);
    }

    @Override
    public View getView(LayoutInflater layoutInflater, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageLoader.disPlay(imageView, bannerdata.get(position).get("ad_pic"));
        return imageView;
    }

    @Override
    public int getCount() {
        return ListUtils.getSize(bannerdata);
    }
}
