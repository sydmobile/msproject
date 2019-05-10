package com.syd.mystudydemo.training_status_bar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 说明：状态栏内容
 * <p>
 * date: 2019/3/28 15:09
 *
 * @author sunyidong
 * @version 1.0
 */
public class ActivityStatusBar extends BaseActivity {

    @BindView(R.id.iv)
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusbar);
        ButterKnife.bind(this);
        init();
    }

    @Override
    protected void initDef() {
        super.initDef();

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
//            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);


            // 单独使用的话，触碰 UI 任何地方，系统都会将这个属性设置去除，不再生效因此需要和 View.SYSTEM_UI_FLAG_IMMERSIVE 配合使用
//            int option =  View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|View.SYSTEM_UI_FLAG_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
            // View.SYSTEM_UI_FLAG_IMMERSIVE 单独使用是没有任何意义的，需要和 View.SYSTEM_UI_FLAG_FULLSCREEN、View.SYSTEM_UI_FLAG_HIDE_NAVIGATION 配合使用

            // 那么则是保留系统 UI 的位置（实际上是固定了我们的 UI 的高度，我们 UI 的高度就是屏幕去掉系统栏高度后的高度），那么这个时候你如何设置了 FLAG_HIDE_NAVIGATION 是不起作用的，因为我们的布局高度已经确定了，不可能延伸到系统栏。

//        int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
//                | View.SYSTEM_UI_FLAG_FULLSCREEN;

//            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN ;
//            int option = View.SYSTEM_UI_FLAG_FULLSCREEN ;
//            int option = View.SYSTEM_UI_FLAG_FULLSCREEN ;
//            decorView.setSystemUiVisibility(option);
//            decorView.setFitsSystemWindows(true);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // 单纯的在根目录中设置 fitWindwos  true   ,使用 LAYOUT_FULLSCREEN  会保留系统栏的部分，我们的布局不会被系统栏遮挡
        // 实际上

//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//            getWindow().setNavigationBarColor(Color.TRANSPARENT);
//            getWindow().setNavigationBarColor(Color.TRANSPARENT);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
        // Android 4.4 引入了 FLAG_TRANSLUCENT_STATUS 这种模式，使用这种模式可以使内容布局占据状态栏
        //
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
//        }
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        getWindow().setStatusBarColor(Color.TRANSPARENT);
//        findViewById(android.R.id.content);

//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View
// .SYSTEM_UI_FLAG_LAYOUT_STABLE);

//        getWindow().setStatusBarColor(Color.TRANSPARENT);

////        View decorView = getWindow().getDecorView();
////        int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
////        decorView.setSystemUiVisibility(option);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();


//        if (Build.VERSION.SDK_INT >= 21){
//            View decorView = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View
// .SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(option);
////            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }

//        if (Build.VERSION.SDK_INT >= 21) {
//            View decorView = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(option);
////            getWindow().setNavigationBarColor(Color.TRANSPARENT);
////            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();


//        if (Build.VERSION.SDK_INT >= 21) {
//            View decorView = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN | View
// .SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(option);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        ViewGroup systemContent = findViewById(android.R.id.content);
//        View statusBarView = new View(this);
//        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,40);
//        statusBarView.setBackgroundColor(getResources().getColor(R.color.main_green_00b661));
////
////      systemContent.getChildAt(0).setFitsSystemWindows(true);
//        systemContent.addView(statusBarView, 0, lp);

//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        View view = new View(this);
//        view.setBackgroundColor(getResources().getColor(R.color.colorAccent));
//        int screenWidth = getResources().getDisplayMetrics().widthPixels;
//        int statusBarHeight = 440;
//        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(screenWidth,statusBarHeight);
//        view.setLayoutParams(params);
//        view.requestLayout();
//        // 获取根布局
//        ViewGroup systeContent = findViewById(android.R.id.content);
//        ViewGroup userContent = (ViewGroup) systeContent.getChildAt(0);
//        userContent.setFitsSystemWindows(true);
//        systeContent.setFitsSystemWindows(true);
//        systeContent.addView(view, 0);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
//            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
//        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
//            View decorView = getWindow().getDecorView();
//            decorView.setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//
//
//            );
//        }


//        View decorView = getWindow().getDecorView();
//        decorView.setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//
//        );
    }
}