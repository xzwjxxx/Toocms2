package com.toocms.fresh.index.promotion;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.toocms.frame.image.ImageLoader;
import com.toocms.fresh.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/3.
 */
public class PromotionAdapter extends BaseAdapter {

    private Context context;
    private List<Map<String,String>> promotionData;
    private ImageLoader imageLoader;

    public PromotionAdapter(Context context){

        this.context=context;
        this.imageLoader=new ImageLoader(context,R.drawable.index_recommend_image);

    }

    /**
     * 设置数据
     */
    public void setData(List<Map<String,String>> promotionData){
        this.promotionData=promotionData;
        this.notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return (promotionData!=null)?promotionData.size():0;
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
            ViewUtils.inject(holder,view);
            view.setTag(holder);

        }else{
            holder=(ViewHolder)view.getTag();
        }
        imageLoader.disPlay(holder.goodImage,promotionData.get(position).get("goods_cover"));
        holder.goodTitle.setText(promotionData.get(position).get("goods_name"));
        holder.goodWeight.setText(promotionData.get(position).get("attr")+""+promotionData.get(position).get("unit"));
        holder.goodPrice.setText(promotionData.get(position).get("goods_price"));
        holder.goodOldPrice.setText(promotionData.get(position).get("market_price"));
        holder.goodOldPrice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        return view;
    }



    class ViewHolder{
        @ViewInject(R.id.promotion_image)
        private ImageView goodImage;
        @ViewInject(R.id.promotion_title)
        private TextView goodTitle;
        @ViewInject(R.id.promotion_weight)
        private TextView goodWeight;
        @ViewInject(R.id.promotion_price)
        private TextView goodPrice;
        @ViewInject(R.id.promotion_old_price)
        private TextView goodOldPrice;

    }
}
