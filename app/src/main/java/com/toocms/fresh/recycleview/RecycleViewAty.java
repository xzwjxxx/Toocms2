package com.toocms.fresh.recycleview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.toocms.fresh.BaseAty;
import com.toocms.fresh.R;

/**
 * Created by Administrator on 2016/3/8.
 */
public class RecycleViewAty extends BaseAty implements MyClickListener {


    @ViewInject(R.id.recyclerview)
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActionBar.hide();

        initRecycleView();

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.recycleview_layout;
    }

    @Override
    protected void initialized() {

    }

    @Override
    protected void requestData() {

    }

    @Override
    @OnClick({})
    public void onClick(View v) {
        switch (v.getId()){

        }
    }


    /**
     * 初始化recycleview
     */
    private void initRecycleView(){

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        myAdapter=new MyAdapter();

        recyclerView.setAdapter(myAdapter);

        myAdapter.setOnItemClickListener(this);

        //设置Item增加、移除动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
//        recyclerView.addItemDecoration(new MyItemDecoration(this, R.drawable.recycle_item_decoraton));

    }

    @Override
    public void onItemClick(View view, int postion) {

        showToast("item:"+postion);

    }


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        private MyClickListener myClickListener;

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view= LayoutInflater.from(RecycleViewAty.this).inflate(R.layout.recycleview_layout_item,parent,false);

            CardView cardView= (CardView) view.findViewById(R.id.card_view);

            cardView.setRadius(5);

            MyViewHolder myViewHolder=new MyViewHolder(view,myClickListener);

            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 11;
        }

        public void setOnItemClickListener(MyClickListener myClickListener){

            this.myClickListener=myClickListener;
        }


        class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            private MyClickListener myClickListener;
            public MyViewHolder(View itemView,MyClickListener myClickListener) {
                super(itemView);
                this.myClickListener=myClickListener;

                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {

                if(myClickListener != null){
                    myClickListener.onItemClick(v,getPosition());
                }

            }
        }

    }


    /**
     * 分割线
     */
    class MyItemDecoration extends RecyclerView.ItemDecoration{

        private Drawable mDrawable;
        public MyItemDecoration(Context context,int resid) {
            mDrawable=context.getResources().getDrawable(resid);

        }

        @Override
        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            super.onDraw(c, parent, state);
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.set(0,0,0,mDrawable.getIntrinsicWidth());
        }

        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {

            final int left =parent.getPaddingLeft();
            final int right=parent.getWidth()-parent.getPaddingRight();
            final int childCount=parent.getChildCount();
            for (int i=0;i<childCount;i++){

                final View child=parent.getChildAt(i);
                final RecyclerView.LayoutParams params= (RecyclerView.LayoutParams) child.getLayoutParams();

                final int top=child.getBottom()+params.bottomMargin;
                final int bootom =top+mDrawable.getIntrinsicHeight();
                mDrawable.setBounds(left,top,right,bootom);
                mDrawable.draw(c);
            }
            super.onDrawOver(c, parent, state);
        }
    }










}
