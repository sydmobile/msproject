package com.syd.mystudydemo.training_glide;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 说明：Glide 测试
 * <p>
 * date: 2019/4/17 10:56
 *
 * @author sunyidong
 * @version 1.0
 */
public class GlideActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.bt_load)
    Button btLoad;
    @BindView(R.id.iv_big)
    ImageView ivBig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glide_activity_main);
        ButterKnife.bind(this);
        init();
    }

    @Override
    protected void initListener() {
        super.initListener();
        btLoad.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 加载图片
            case R.id.bt_load:
//                String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
//                String url = "http://p1.pstatp.com/large/166200019850062839d3";
                String url = "http://www.msyt-tech.com/others/static/hospital/msyt-logo.jpg";
                loadImg(url);
                break;
        }
    }

    public void loadImg(String url) {
        Glide.with(this).load(url)
                .placeholder(R.mipmap.logo)
                .error(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(ivBig);
//        Glide.with().loa
    }
}
