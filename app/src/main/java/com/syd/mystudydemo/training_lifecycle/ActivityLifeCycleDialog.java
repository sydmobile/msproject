package com.syd.mystudydemo.training_lifecycle;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;

import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 说明：生命周期
 * <p>
 * date: 2018/12/3 10:10
 *
 * @author sunyidong
 * @version 1.0
 */
public class ActivityLifeCycleDialog extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.et_label_for)
    EditText etLabelFor;
    @BindView(R.id.bt_null)
    Button btNull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        ButterKnife.bind(this);
        init();
        Log.e("onCreate", "++++++");
    }

    @Override
    protected void initView() {
        super.initView();

    }

    @Override
    protected void initListener() {
        super.initListener();
        btNull.setOnClickListener(this);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e("onRestoreInstanceState", "++++++");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("onStart", "++++++");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("onRestart", "++++++");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume", "++++++");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause", "++++++");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("onSaveInstanceState()", "outState");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.e("onSaveInstanceState()", "outState,outPersistentState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onStop", "++++++");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy", "++++++");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_null:
                PopupWindow popupWindow = new PopupWindow(this);
                popupWindow.setContentView(View.inflate(this, R.layout.pop_selectphoto, null));
                popupWindow.showAsDropDown(btNull);
                break;
        }
    }
}
