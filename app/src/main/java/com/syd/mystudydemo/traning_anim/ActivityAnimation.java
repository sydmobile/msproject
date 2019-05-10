package com.syd.mystudydemo.traning_anim;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 说明：View Animation
 * <p>
 * date: 2019/1/8 15:59
 *
 * @author sunyidong
 * @version 1.0
 */
public class ActivityAnimation extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.bt_animation)
    Button btAnimation;
    @BindView(R.id.bt_animation_scale)
    Button btAnimationScale;
    @BindView(R.id.bt_animation_rotate)
    Button btAnimationRotate;
    @BindView(R.id.tv_no_limit)
    TextView tvNoLimit;
    @BindView(R.id.tv_no_id)
    TextView tvNoId;
    @BindView(R.id.tv_have_id)
    TextView tvHaveId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);
        //初始化
        init();
    }

    @Override
    protected void initView() {
        super.initView();
        Animation translateAnimation = AnimationUtils.loadAnimation(this, R.anim.view_animation);
        Animation translateAnimation1 = new TranslateAnimation(300, 900, 300, 900);
        translateAnimation1.setDuration(3000);
        translateAnimation1.setStartTime(AnimationUtils.currentAnimationTimeMillis() + 5000);
        btAnimation.startAnimation(translateAnimation1);

//        Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.view_animation_scale);
//        btAnimationScale.startAnimation(scaleAnimation);

        Animation scaleAnimation1 = new ScaleAnimation(0, 3, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation1.setDuration(3000);
        scaleAnimation1.setFillAfter(true);
        btAnimationScale.startAnimation(scaleAnimation1);

        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.view_animation_rotate);
        btAnimationRotate.startAnimation(rotateAnimation);
    }

    @Override
    protected void initListener() {
        super.initListener();
        // 关于 ripple 实验
        tvNoId.setOnClickListener(this);
        tvNoLimit.setOnClickListener(this);
        tvHaveId.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


    }
}
