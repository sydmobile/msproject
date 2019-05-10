package com.syd.mystudydemo.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 说明：ble 开发
 * <p>
 * date: 2019/3/12 11:34
 *
 * @author sunyidong
 * @version 1.0
 */
public class ActivityBLE extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.bt_start)
    Button btStart;
    @BindView(R.id.bt_start_system)
    Button btStartSystem;
    @BindView(R.id.bt_move)
    Button btMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ble_main);
        ButterKnife.bind(this);
        init();
    }

    @Override
    protected void initView() {
        super.initView();

    }

    @Override
    protected void initListener() {
        super.initListener();
        btStart.setOnClickListener(this);
        btStartSystem.setOnClickListener(this);
        btMove.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_start:
                openBleDirect();
                break;
            case R.id.bt_start_system:
                openBleByIntent();
                break;
            case R.id.bt_move:
                Log.e("sss",""+(-1>>2)+ (-1>>30)   +(-1>>>1));
                Log.e("sss",""+(2>>20));
                Log.e("sss",""+2);
                Log.e("sss",""+(1073741825<<1));
                Log.e("sss",""+(1073741825*2));
                Log.e("sss",""+(-3%13));
                Log.e("sss",""+(-16/16));
                Log.e("sss111",""+(16%-9));
                int a =3,b=4;
                Log.e("==",">>>>"+ --a + (b--)+a*4+"");

//                2147483648
//                2147483650

        }
    }

    /**
     * 直接打开蓝牙设备
     */
    public void openBleDirect() {
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(BLUETOOTH_SERVICE);
        if (bluetoothManager != null) {
            BluetoothAdapter bluetoothAdapter = bluetoothManager.getAdapter();
            if (bluetoothAdapter != null) {
                if (bluetoothAdapter.isEnabled()) {
                    Toast.makeText(this, "蓝牙已打开", Toast.LENGTH_SHORT).show();
                } else {
                    // 开启蓝牙
                    if (bluetoothAdapter.enable()) {
                        Toast.makeText(this, "蓝牙刚刚打开", Toast.LENGTH_SHORT).show();
                    }
                }
            } else {
                Toast.makeText(this, "不支持蓝牙", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void openBleByIntent() {
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(BLUETOOTH_SERVICE);
        if (bluetoothManager != null) {
            BluetoothAdapter bluetoothAdapter = bluetoothManager.getAdapter();
            if (bluetoothAdapter != null) {
                if (bluetoothAdapter.isEnabled()) {
                    Toast.makeText(this, "蓝牙已打开", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(intent, 2);
                }
            } else {
                Toast.makeText(this, "不支持蓝牙", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Toast.makeText(this, "成功了", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent, 2);
        }
    }

    public void timerTest() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 20, 1000);
    }
}
