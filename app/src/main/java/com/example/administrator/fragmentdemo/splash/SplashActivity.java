package com.example.administrator.fragmentdemo.splash;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.administrator.fragmentdemo.R;
import com.example.administrator.fragmentdemo.base.BaseActivity;
import com.example.administrator.fragmentdemo.config.SatticConstants;
import com.example.administrator.fragmentdemo.guide.GuideActivity;
import com.example.administrator.fragmentdemo.main.MainActivity;
import com.example.administrator.fragmentdemo.utils.PackageUtil;
import com.example.administrator.fragmentdemo.utils.SPUtil;
import com.example.administrator.fragmentdemo.utils.imageload.ImageLoader;
import com.example.administrator.fragmentdemo.utils.nohttp.CallServer;
import com.example.administrator.fragmentdemo.utils.nohttp.HttpListener;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.Request;
import com.yolanda.nohttp.Response;

public class SplashActivity extends BaseActivity {
    private long mStart = 0;
    private final int DELAY_TIME = 3 * 1000;
    private ImageView iv_pic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        mStart = System.currentTimeMillis();
    }

    @Override
    protected void setContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void initData() {
//        loadAdImageByNohttp();
        loadImageByGlide();

    }

    private void loadImageByGlide() {
        ImageLoader.loadNormalImage(this, "http://img0.imgtn.bdimg.com/it/u=22923577,3104477963&fm=21&gp=0.jpg", -1, iv_pic);
    }

    private void loadAdImageByNohttp() {
        Request<Bitmap> request = null;
        request = NoHttp.createImageRequest("http://pic4.nipic.com/20090910/992145_010003721901_2.jpg");
        if (request != null)
            CallServer.getRequestInstance().add(this, 0, request, mHttpListener, false, false);
    }

    @Override
    protected void findViews() {
        iv_pic = (ImageView) findViewById(R.id.iv_pic);
    }

    HttpListener mHttpListener = new HttpListener() {
        @Override
        public void onSucceed(int what, Response response) {
            Bitmap bitmap = (Bitmap) response.get();
            if (null != bitmap) {
                iv_pic.setImageBitmap(bitmap);
            }

        }

        @Override
        public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {

        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goToNextActivity();
            }
        }, DELAY_TIME);
    }

    private void goToNextActivity() {
        if ((Boolean) SPUtil.getParam(SplashActivity.this, SatticConstants.SHOW_GUIDE_PAGE+ PackageUtil.getVersionName(), true)) {
            startActivity(new Intent(SplashActivity.this, GuideActivity.class));
        } else {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        }
        finish();
    }
}
