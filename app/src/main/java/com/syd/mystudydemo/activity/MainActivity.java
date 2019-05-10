package com.syd.mystudydemo.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;
import com.syd.mystudydemo.ble.ActivityBLE;
import com.syd.mystudydemo.config.ActivityCategory;
import com.syd.mystudydemo.process_training.activity.ActivityFirst;
import com.syd.mystudydemo.training_click.ActivityClick;
import com.syd.mystudydemo.training_focus.ActivityMain;
import com.syd.mystudydemo.training_glide.GlideActivity;
import com.syd.mystudydemo.training_inputmanager.ActivityInputManager;
import com.syd.mystudydemo.training_lifecycle.ActivityLifeCycle;
import com.syd.mystudydemo.training_net.ActivityNetStudy;
import com.syd.mystudydemo.training_progressbar.ActivityProgressBarMain;
import com.syd.mystudydemo.training_shadow.ActivityShadow;
import com.syd.mystudydemo.training_status_bar.ActivityStatusBar;
import com.syd.mystudydemo.training_surface.ActivitySurface;
import com.syd.mystudydemo.training_thread.ActivityThread;
import com.syd.mystudydemo.training_view.ActivityView;
import com.syd.mystudydemo.traning_anim.ActivityAnimation;
import com.syd.mystudydemo.utils.UtilsGoNextPage;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create at sydMobile
 * 练习页面的主页面
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.tv_to_activity_first)
    TextView tvToActivityFirst;
    @BindView(R.id.tv_next_input_manager)
    TextView tvNextInputManager;
    @BindView(R.id.tv_next_event_bus)
    TextView tvNextEventBus;
    @BindView(R.id.tv_next_focus)
    TextView tvNextFocus;
    @BindView(R.id.tv_next_progressbar)
    TextView tvNextProgressbar;
    @BindView(R.id.tv_next_surface)
    TextView tvNextSurface;
    @BindView(R.id.tv_next_shadow)
    TextView tvNextShadow;
    @BindView(R.id.tv_next_ok_http)
    TextView tvNextOkHttp;
    @BindView(R.id.tv_next_view)
    TextView tvNextView;
    @BindView(R.id.tv_activity_life_cycle)
    TextView tvActivityLifeCycle;
    @BindView(R.id.tv_activity_button)
    TextView tvActivityButton;
    @BindView(R.id.activity_main)
    ScrollView activityMain;
    @BindView(R.id.tv_activity_animation)
    TextView tvActivityAnimation;
    @BindView(R.id.tv_activity_thread)
    TextView tvActivityThread;
    @BindView(R.id.tv_activity_ble)
    TextView tvActivityBle;
    @BindView(R.id.tv_activity_status_bar)
    TextView tvActivityStatusBar;
    @BindView(R.id.tv_test)
    TextView tvTest;
    @BindView(R.id.tv_activity_glide)
    TextView tvActivityGlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();

    }

    @Override
    protected void initView() {
        super.initView();
        tvNextSurface.setText(getResources().getString(R.string.text_surface));
    }

    @Override
    protected void initListener() {
        super.initListener();
        tvNextSurface.setOnClickListener(this);
        tvToActivityFirst.setOnClickListener(this);
        tvNextInputManager.setOnClickListener(this);
        //到EventBus练习页面
        tvNextEventBus.setOnClickListener(this);
        //到Focus页面
        tvNextFocus.setOnClickListener(this);
        //到ProgressBar页面
        tvNextProgressbar.setOnClickListener(this);
        tvNextShadow.setOnClickListener(this);
        //到okHttp页面
        tvNextOkHttp.setOnClickListener(this);
        // 到自定义 View 页面
        tvNextView.setOnClickListener(this);
        // 到 Activity 生命周期页面
        tvActivityLifeCycle.setOnClickListener(this);
        tvActivityButton.setOnClickListener(this);
        tvActivityAnimation.setOnClickListener(this);
        tvActivityThread.setOnClickListener(this);
        tvActivityBle.setOnClickListener(this);
        tvActivityStatusBar.setOnClickListener(this);
        tvTest.setOnClickListener(this);
        tvActivityGlide.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            // 到线程练习页面
            case R.id.tv_to_activity_first:
//                Intent intent1 = new Intent(this, ActivityFirst.class);
//                startActivity(intent1);
                UtilsGoNextPage.toActivity(this, ActivityFirst.class, ActivityCategory.ACTIVITY_COMMON);
                break;
            // 到Surface练习页面
            case R.id.tv_next_surface:
                Intent intent2 = new Intent(this, ActivitySurface.class);
                startActivity(intent2);
                break;
            //到软键盘测试页面按钮
            case R.id.tv_next_input_manager:
                UtilsGoNextPage.toActivity(this, ActivityInputManager.class, ActivityCategory.ACTIVITY_COMMON);
                break;
            case R.id.tv_next_event_bus:
//                UtilsGoNextPage.toActivity(this, ActivityEventBus.class, ActivityCategory.ACTIVITY_COMMON);
                new AlertDialog.Builder(this).setTitle("title").setMessage("内容").show();
                break;
            //到焦点练习页面
            case R.id.tv_next_focus:
                UtilsGoNextPage.toActivity(this, ActivityMain.class, ActivityCategory.ACTIVITY_COMMON);
                break;
            //到ProgressBar页面
            case R.id.tv_next_progressbar:
                UtilsGoNextPage.toActivity(this, ActivityProgressBarMain.class, ActivityCategory.ACTIVITY_COMMON);

                break;
            case R.id.tv_next_shadow:
                UtilsGoNextPage.toActivity(this, ActivityShadow.class, ActivityCategory.ACTIVITY_COMMON);
//                int ii = textReturn();
                break;
            case R.id.tv_next_ok_http:
                UtilsGoNextPage.toActivity(this, ActivityNetStudy.class, ActivityCategory.ACTIVITY_COMMON);
                break;
            case R.id.tv_next_view:
                UtilsGoNextPage.toActivity(this, ActivityView.class, ActivityCategory.ACTIVITY_COMMON);
                break;
            case R.id.tv_activity_life_cycle:
                UtilsGoNextPage.toActivity(this, ActivityLifeCycle.class, ActivityCategory.ACTIVITY_COMMON);
                break;
            case R.id.tv_activity_button:
                UtilsGoNextPage.toActivity(this, ActivityClick.class, ActivityCategory.ACTIVITY_COMMON);
                break;
            // 到动画页面
            case R.id.tv_activity_animation:
                UtilsGoNextPage.toActivity(this, ActivityAnimation.class, ActivityCategory.ACTIVITY_COMMON);
                break;
            // 到线程页面
            case R.id.tv_activity_thread:
                UtilsGoNextPage.toActivity(this, ActivityThread.class, ActivityCategory.ACTIVITY_COMMON);
                break;
            // 到 ble 开发页面
            case R.id.tv_activity_ble:
                UtilsGoNextPage.toActivity(this, ActivityBLE.class, ActivityCategory.ACTIVITY_COMMON);
                break;
            // 到 状态 bar 页面
            case R.id.tv_activity_status_bar:
                UtilsGoNextPage.toActivity(this, ActivityStatusBar.class, ActivityCategory.ACTIVITY_COMMON);
                break;
            // 专门测试页面
            case R.id.tv_test:
                UtilsGoNextPage.toActivity(this, TestActivity.class, ActivityCategory.ACTIVITY_COMMON);
                break;

            case R.id.tv_activity_glide:
                UtilsGoNextPage.toActivity(this, GlideActivity.class, ActivityCategory.ACTIVITY_COMMON);
                break;
        }
    }

}
