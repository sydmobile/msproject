package com.syd.mystudydemo.training_view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

/**
 * 说明：自己实现 LinearLayout
 * <p>
 * date: 2018/12/11 9:51
 *
 * @author sunyidong
 * @version 1.0
 */
public class MyNewLinearLayout extends ViewGroup {

    public String TAG = getClass().getName();

    /**
     * 垂直布局
     */
    public static final byte ORIENTATION_VERTICAL = 0x1;
    /**
     * 水平布局
     */
    public static final byte ORIENTATION_HORIZONTAL = 0x0;

    // 线性布局的方向，默认值为水平
    private int mOrientation = ORIENTATION_HORIZONTAL;

    // 最终宽度
    private int mWidth;

    // 最终高度
    private int mHeight;

    public MyNewLinearLayout(Context context) {
        this(context, null);
        mOrientation = ORIENTATION_HORIZONTAL;
    }

    public MyNewLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyNewLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, 0);
    }

    /**
     * 设置线性布局的方向
     * @param orientation 方向
     */
    public void setOrientation(byte orientation) {
        mOrientation = orientation;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e(TAG,"onMeasure");

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
