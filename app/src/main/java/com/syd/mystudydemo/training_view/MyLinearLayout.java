package com.syd.mystudydemo.training_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * 说明：
 *
 * @author sunyidong
 * @version 1.0
 * 创建时间 2018/9/25 16:48
 */
public class MyLinearLayout extends ViewGroup {
    public MyLinearLayout(Context context) {
        this(context, null);

    }

    public MyLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
        int measureHeight = MeasureSpec.getSize(heightMeasureSpec);
        int measureWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int measureHeightMode = MeasureSpec.getMode(heightMeasureSpec);
        int height = 0;
        int width = 0;
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            //测量子控件
            View child = getChildAt(i);
//            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
//            measureChildWithMargins(child,widthMeasureSpec,);
            MarginLayoutParams layoutParams = (MarginLayoutParams) child.getLayoutParams();
            //获得子控件的高度和宽度
            int childHeight = child.getMeasuredHeight() + layoutParams.bottomMargin + layoutParams.topMargin;
            int childWidth = child.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            //得到最大高度，并且累加高度
            height += childHeight;
            width = Math.max(childWidth, width);

        }
//        setMeasuredDimension((measureWidthMode == MeasureSpec.EXACTLY) ? measureWidth : width, (measureHeightMode == MeasureSpec.EXACTLY) ? measureHeight : height);


    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

        int childCount = getChildCount();

        int top = 0;
        for (int j = 0; j < childCount; j++) {
            View view = getChildAt(j);
            MarginLayoutParams lp = (MarginLayoutParams) view.getLayoutParams();
            int childHeight = view.getMeasuredHeight() + lp.bottomMargin + lp.topMargin;
            int width = view.getMeasuredWidth() + lp.rightMargin + lp.leftMargin;
            view.layout(lp.leftMargin, top + lp.topMargin, lp.leftMargin + view.getMeasuredWidth(), top + lp.topMargin + view.getMeasuredHeight());
            top += childHeight;

        }
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }
}
