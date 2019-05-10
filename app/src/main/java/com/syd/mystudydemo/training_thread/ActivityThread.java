package com.syd.mystudydemo.training_thread;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 说明：线程
 * <p>
 * date: 2019/1/14 16:02
 *
 * @author sunyidong
 * @version 1.0
 */
public class ActivityThread extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.bt_start)
    Button btStart;
    @BindView(R.id.bt_stop)
    Button btStop;
    @BindView(R.id.bt_start_timer)
    Button btStartTimer;
    @BindView(R.id.bt_stop_Timer)
    Button btStopTimer;
    // 时间定时器
    Timer timer;
    @BindView(R.id.bt_scroll_to)
    Button btScrollTo;
    @BindView(R.id.bt_scroll_by)
    Button btScrollBy;
    @BindView(R.id.ll_scroll)
    LinearLayout llScroll;
    private boolean isActive = false;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        ButterKnife.bind(this);
        init();
    }

    @Override
    protected void initView() {
        super.initView();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isActive) {
                    Log.e("thread", "===========");
                }
                Log.e("while====", "结束=====");
            }
        });
    }

    @Override
    protected void initListener() {
        super.initListener();
        btStart.setOnClickListener(this);
        btStop.setOnClickListener(this);
        btStartTimer.setOnClickListener(this);
        btStopTimer.setOnClickListener(this);
        btScrollBy.setOnClickListener(this);
        btScrollTo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 线程开始
            case R.id.bt_start:
                isActive = true;
                thread.start();
                break;
            // 线程结束
            case R.id.bt_stop:
                isActive = false;
                break;
            // 开始 Timer
            case R.id.bt_start_timer:
                startTimer();
                break;
            // 结束 Timer
            case R.id.bt_stop_Timer:
                endTimer();
                break;
            // scroll To
            case R.id.bt_scroll_to:
                btScrollTo.scrollTo(-60, -100);
                break;
            // scroll by
            case R.id.bt_scroll_by:
                btScrollTo.scrollBy(-60, -100);
                break;
        }
    }


    //region startTimer()开始定时器------------------------------------------------------------------------------------------------

    /**
     * 开始定时器
     */
    public void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                Log.e("timertask", time + "");
                Log.e("sleep", time + "");
            }
        }, 0, 1000);
    }
    //endregion-----------------------------------------------------------------------------------------------

    //region endTimer()结束定时器------------------------------------------------------------------------------------------------

    /**
     * 结束定时器
     */
    public void endTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }
    //endregion-----------------------------------------------------------------------------------------------

    //region test 测试使用------------------------------------------------------------------------------------------------

    /**
     * 测试使用
     */
    public void test() {

    }
    //endregion-----------------------------------------------------------------------------------------------
}
