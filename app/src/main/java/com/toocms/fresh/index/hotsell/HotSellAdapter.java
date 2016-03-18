package com.toocms.fresh.index.hotsell;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.toocms.fresh.R;

/**
 * Created by Administrator on 2016/3/3.
 */
public class HotSellAdapter extends BaseAdapter {

    private Context context;

    public HotSellAdapter(Context context){

        this.context=context;

    }

    /**
     * 设置数据
     */
    public void setData(){



    }

    @Override
    public int getCount() {
        return 10;
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

        ViewHolder holder=null;

        if(view==null){

            holder=new ViewHolder();

            view= LinearLayout.inflate(context, R.layout.index_promotion_actiy_listitem,null);

            view.setTag(holder);

        }else{

            holder=(ViewHolder)view.getTag();

        }


        return view;
    }



    class ViewHolder{




    }
}
