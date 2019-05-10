package com.syd.mystudydemo.training_net;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BaseHttpStack;
import com.android.volley.toolbox.HttpResponse;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.syd.mystudydemo.R;
import com.syd.mystudydemo.activity.base.BaseActivity;

import java.io.IOException;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 说明：Volley 学习
 * <p>
 * date: 2019/3/21 16:27
 *
 * @author sunyidong
 * @version 1.0
 */
public class ActivityVolley extends BaseActivity {

    @BindView(R.id.bt_string_request)
    Button btStringRequest;
    @BindView(R.id.bt_json_request)
    Button btJsonRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        ButterKnife.bind(this);
        init();
    }

    @Override
    protected void initDef() {
        super.initDef();
        RequestQueue requestQueue = Volley.newRequestQueue(this, new BaseHttpStack() {
            @Override
            public HttpResponse executeRequest(Request<?> request, Map<String, String> additionalHeaders) throws IOException, AuthFailureError {
                return null;
            }
        });
        ImageRequest imageRequest = new ImageRequest("url", new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {

            }
        }, 0, 0, ImageView.ScaleType.FIT_XY, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        final ImageLoader.ImageListener listener = new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {

            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        };
        ImageLoader imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                return null;
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {

            }
        });

        RequestQueue requestQueue1 = Volley.newRequestQueue(this);
        ImageView imageView = null;
        ImageLoader.ImageListener imageLoader1 = ImageLoader.getImageListener(imageView, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        ImageLoader imageLoader2 = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {

            LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(10 * 1024 * 1024) {
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    return value.getRowBytes() * value.getHeight();
                }
            };

            @Override
            public Bitmap getBitmap(String url) {
                return lruCache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                lruCache.put(url, bitmap);
            }

        });
//      imageLoader.get()
    }

    @Override
    protected void initListener() {
        super.initListener();
    }
}
