package com.toocms.view;//com.toocms.view.MonitorScrollView

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * 监听滑动的ScrollView
 *
 * @author Zero
 * @date 2016/1/13 17:12
 */
public class MonitorScrollView extends ScrollView {

    private OnScrollListener listener;

    public MonitorScrollView(Context context) {
        super(context);
    }

    public MonitorScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MonitorScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        if (listener != null) {
            listener.onScroll(l, t, oldl, oldt);
        }
    }

    /**
     * 添加滚动监听
     *
     * @param listener
     */
    public void setOnScrollListener(OnScrollListener listener) {
        this.listener = listener;
    }

    public interface OnScrollListener {
        public void onScroll(int x, int y, int oldx, int oldy);
    }

}
