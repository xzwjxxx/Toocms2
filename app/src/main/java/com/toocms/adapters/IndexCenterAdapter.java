package com.toocms.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.toocms.frame.image.ImageLoader;
import com.toocms.fresh.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/2.
 */
public class IndexCenterAdapter extends BaseAdapter{


    private Context context;
    private List<Map<String, String>> centerData;
    private ImageLoader imageLoader;

    public IndexCenterAdapter(Context context,List<Map<String, String>> centerData){

        this.context=context;
        this.centerData=centerData;
        this.imageLoader=new ImageLoader(context,R.drawable.index_center_image);

    }

    @Override
    public int getCount() {

        return (centerData!=null)?centerData.size():0;

    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder viewHolder;

        if(view==null){

            viewHolder=new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.index_center_listitem, parent, false);
            viewHolder.image= (ImageView) view.findViewById(R.id.index_center_itemimage);
            view.setTag(viewHolder);

        }else {

            viewHolder=(ViewHolder) view.getTag();

        }

        imageLoader.disPlay(viewHolder.image,centerData.get(position).get("ad_pic"));

        return view;
    }

    class ViewHolder{

        public ImageView image;

    }
}
