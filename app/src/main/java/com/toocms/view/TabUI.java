package com.toocms.view;//com.toocms.view.TabUI

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.toocms.fresh.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/11.
 */
public class TabUI extends LinearLayout {

    private View view;
    private LinearLayout uiTabList;
    private LayoutInflater mInflater;

    private List<UITabItem> mItemList;
    private int mIndexController = 0;

    public TabUI(Context context) {
        super(context);
        initView(context);
    }

    public TabUI(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public TabUI(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }


    /**
     * 初始化控件
     */
    private void initView(Context context){
        mItemList=new ArrayList<>();
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=mInflater.inflate(R.layout.uitable_layout,null);
        uiTabList= (LinearLayout) view.findViewById(R.id.uitab_linearlayout);
    }


    /**
     * 适配器
     */
    public void addItem(int left_drawable,String left_title,String right_title,int right_drawable){
        mItemList.add(new UITabItem(left_drawable,left_title,right_title,right_drawable));
    }


    /**
     * 事务提交
     */
    public void commit() {
        mIndexController = 0;
        if (mItemList.size() >= 1) {
            View veiwitem;
            ImageView leftimage;
            ImageView rightimage;
            TextView lefttitle;
            TextView righttitle;
            for (int i=0;i<mItemList.size();i++) {
                 veiwitem= mInflater.inflate(R.layout.uitable_layout_item,null);
                 leftimage= (ImageView) veiwitem.findViewById(R.id.uitab_item_leftimage);
                 rightimage= (ImageView) veiwitem.findViewById(R.id.uitab_item_rightimage);
                 lefttitle= (TextView) veiwitem.findViewById(R.id.uitab_item_lefttitle);
                 righttitle= (TextView) veiwitem.findViewById(R.id.uitab_item_righttitle);

                if(mItemList.get(i).getLeftdrawable()==0){
                    leftimage.setVisibility(View.GONE);
                }else{
                    leftimage.setVisibility(View.VISIBLE);
                    leftimage.setImageResource(mItemList.get(i).getLeftdrawable());
                }
                if(mItemList.get(i).getRightdrawable()==0){
                    rightimage.setVisibility(View.GONE);
                }else{
                    rightimage.setVisibility(View.VISIBLE);
                    rightimage.setImageResource(mItemList.get(i).getRightdrawable());
                }
                if("".equals(mItemList.get(i).getLefttitle())){
                    lefttitle.setVisibility(View.GONE);
                }else{
                    lefttitle.setVisibility(View.VISIBLE);
                    lefttitle.setText(mItemList.get(i).getLefttitle());
                }
                if("".equals(mItemList.get(i).getRighttitle())){
                    righttitle.setVisibility(View.GONE);
                }else{
                    righttitle.setVisibility(View.VISIBLE);
                    righttitle.setText(mItemList.get(i).getRighttitle());
                }
                uiTabList.addView(veiwitem,i);
            }
        }

        this.addView(view);
    }

}
