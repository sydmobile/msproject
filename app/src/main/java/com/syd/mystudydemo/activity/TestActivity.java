package com.syd.mystudydemo.activity;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 说明：测试 Activity
 * <p>
 * date: 2019/4/10 14:26
 *
 * @author sunyidong
 * @version 1.0
 */
public class TestActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.bt_test)
    Button btTest;
    String string;
    @BindView(R.id.et)
    EditText et;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.iv_android)
    ImageView ivAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        init();
    }

    @Override
    protected void initListener() {
        super.initListener();
        btTest.setOnClickListener(this);
        string = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_test:

               Drawable drawable =  ivAndroid.getDrawable();
                ((Animatable)drawable).start();
                String etString = et.getText().toString();
                Log.e("etString", "etString" + etString);
//                Log.e("test", String.format("%s", string)+ tv.getText().toString()+  et.getText().toString());
                // String to be scanned to find the pattern.
                String line = "This is regex string demo 233333 ! are you ok ?";
//                String pattern = "(\\w)(\\d+)(.*)";
//                String pattern = "(\\w)(\\d+)(.*)";
                String pattern = "(.*)(\\d+)(.*)";

                // Create a Pattern object
                Pattern r = Pattern.compile(pattern);

                // Now create matcher object.
                Matcher m = r.matcher(line);
                if (m.find()) {

                    System.out.println("Found value: " + m.group(0));
                    System.out.println("Found value: " + m.group(1));
                    System.out.println("Found value: " + m.group(2));
                    System.out.println("Found value: " + m.group(3));

//                    System.out.println("Found value: " + m.group(2) );
//                    System.out.println("Found value: " + m.group() );
//                    System.out.println("Found value: " + m.group(0) );

                } else {
                    System.out.println("NO MATCH");
                }
                break;
        }
    }
}
