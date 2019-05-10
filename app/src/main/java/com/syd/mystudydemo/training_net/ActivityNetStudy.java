package com.syd.mystudydemo.training_net;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 说明：网络学习
 * <p>
 * date: 2019/3/21 16:28
 *
 * @author sunyidong
 * @version 1.0
 */
public class ActivityNetStudy extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.bt_volley)
    Button btVolley;
    @BindView(R.id.bt_ok_http)
    Button btOkHttp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);
        ButterKnife.bind(this);
        init();
    }

    @Override
    protected void initListener() {
        super.initListener();
        btOkHttp.setOnClickListener(this);
        btVolley.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // okHttp 请求
            case R.id.bt_ok_http:
                Intent intent = new Intent(this, ActivityOkHttp.class);
                startActivity(intent);
                break;
            // Volley 请求
            case R.id.bt_volley:
                Intent intent1 = new Intent(this,ActivityVolley.class);
                startActivity(intent1);
                break;
        }
    }
}
