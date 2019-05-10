package com.syd.mystudydemo.training_menu;

import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;

import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;

/**
 * 说明：Menu Test 页面
 * <p>
 * date: 2019/1/21 10:17
 * @author sunyidong
 * @version 1.0
 */
public class MenuActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);

    }
}
