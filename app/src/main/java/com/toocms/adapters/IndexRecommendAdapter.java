package com.toocms.adapters;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.toocms.config.Constants;
import com.toocms.frame.image.ImageLoader;
import com.toocms.fresh.MainActivity;
import com.toocms.fresh.R;
import com.toocms.fresh.shoppingcar.addShopCartAnim;

import java.util.Map;

import cn.zero.android.common.util.ScreenUtils;
import cn.zero.android.common.view.BadgeView;
import cn.zero.android.common.view.blocklistview.BlockListAdapter;

/**
 * Created by Administrator on 2016/3/2.
 */
public class IndexRecommendAdapter extends BlockListAdapter<Map<String,String>> {



    private TextView shopCart= MainActivity.tabs[2];//购物车
    private ViewGroup anim_mask_layout;//动画层
    private ImageView buyImg;// 这是在界面上跑的小图片
    private int buyNum = 0;//购买数量
    private BadgeView buyNumView;//显示购买数量的控件
    private addShopCartAnim aShopCartAnim;





    private ImageLoader imageLoader;
    private Context context;
    private ViewHolder viewHolder;

    public IndexRecommendAdapter(Context context){

        this.context=context;
        imageLoader=new ImageLoader(context,R.drawable.index_recommend_image);


//        buyNumView = new BadgeView(context, MainActivity.tabs[Constants.MAIN_CART]);
//        buyNumView.setBadgeMargin(ScreenUtils.dpToPxInt(25), ScreenUtils.dpToPxInt(5));
//        aShopCartAnim=new addShopCartAnim(context,handler,shopCart);

    }

    @Override
    public View getView(LayoutInflater layoutInflater, int i) {

        final Map<String, String> map = mItemList.get(i);

        View convertView=layoutInflater.inflate(R.layout.index_recmd_listitem,null);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.listitem_index_recommend_imgv_image);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.listitem_index_recommend_tv_title);
        TextView tvPrice = (TextView) convertView.findViewById(R.id.listitem_index_recommend_tv_price);
        ImageButton imageButton = (ImageButton) convertView.findViewById(R.id.listitem_index_recommend_imgbtn_cart);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int[] start_location = new int[2];// 一个整型数组，用来存储按钮的在屏幕的X、Y坐标
//                v.getLocationInWindow(start_location);// 这是获取购买按钮的在屏幕的X、Y坐标（这也是动画开始的坐标）
//                buyImg = new ImageView(context);// buyImg是动画的图片，我的是一个小球（R.drawable.sign）
//                buyImg.setImageResource(R.drawable.anim_icon);// 设置buyImg的图片
//                aShopCartAnim.setShopCartAnim(anim_mask_layout, buyImg, start_location);
            }
        });


        if(!map.isEmpty()){

            imageLoader.disPlay(imageView,map.get("goods_cover"));
            tvTitle.setText(""+map.get("goods_name")+" "+map.get("goods_brief"));
            tvPrice.setText("¥" + map.get("goods_price"));

        }
        return convertView;
    }


    class ViewHolder{



    }



    Handler handler=new Handler(){

        public void handleMessage(android.os.Message msg) {

            if(msg.arg1==1){

                buyNum++;//让购买数量加1
                buyNumView.setText(buyNum + "");//
                buyNumView.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);
                buyNumView.show();

            }

        };

    };



}
