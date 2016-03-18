package com.toocms.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * 拦截子控件触摸事件的listview
 *
 * @author Zero
 * @date 2016/1/23 9:57
 */
public class TouchLinearLayout extends LinearLayout {

    public TouchLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }
}
