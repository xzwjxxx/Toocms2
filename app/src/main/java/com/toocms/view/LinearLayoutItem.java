package com.toocms.view;//com.toocms.view.LinearLayoutItem

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.toocms.fresh.R;

/**
 * Created by Administrator on 2016/3/7.
 */
public class LinearLayoutItem extends RelativeLayout {

    private View view;
    private TextView firstTv,lastTv;
    private ImageView lastImage,firstImage;

    private String firsttext="title1",lasttext="title2";
    private int image=R.drawable.mine_head_right;
    private int firstimage=0;

    public LinearLayoutItem(Context context) {
        super(context);
        getView();
    }

    public LinearLayoutItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        getView();
    }

    public LinearLayoutItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getView();
    }

    /**
     * 设置自定义View
     */
    public void getView(){

        this.view=LinearLayout.inflate(getContext(), R.layout.linearlayout_button_item,null);

        this.firstTv= (TextView) view.findViewById(R.id.linearlayout_button_item_first_text);
        this.lastTv= (TextView) view.findViewById(R.id.linearlayout_button_item_last_text);
        this.lastImage= (ImageView) view.findViewById(R.id.linearlayout_button_item_last_image);
        this.firstImage= (ImageView) view.findViewById(R.id.linearlayout_button_item_first_firstimage);

        this.firstTv.setText(getFirsttext());
        this.lastTv.setText(getLasttext());
        this.lastImage.setImageResource(getImage());

        if(getfirstImage()!=0){

            this.firstImage.setVisibility(View.VISIBLE);
            this.firstImage.setImageResource(getfirstImage());

        }else {

            this.firstImage.setVisibility(View.GONE);

        }

        this.addView(view);

    }

    public void setData(String firsttext,String lasttext,int image){

        this.firsttext=firsttext;
        this.lasttext=lasttext;
        this.image=image;
        this.getView();

    }

    public void setData(int firstimage,String firsttext,String lasttext,int image){

        this.firsttext=firsttext;
        this.lasttext=lasttext;
        this.image=image;
        this.firstimage=firstimage;

        this.getView();

    }

    private String getFirsttext(){

        return (this.firsttext.equals(""))?"":this.firsttext;
    }

    private String getLasttext(){

        return (this.lasttext.equals(""))?"":this.lasttext;
    }

    private int getImage(){

        return this.image;
    }

    public int getfirstImage() {

        return firstimage;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
