package com.example.tommorow.ui;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.tommorow.BaseActivity;
import com.example.tommorow.R;

import butterknife.ButterKnife;

import static com.example.tommorow.R.id.gameWeb;

/**
 * Created by lenovo on 2017/4/6.
 */

public class GameActivity extends BaseActivity {
    private String webUrl = "http://www.wigsgames.com/html/bertsbrain/index.html";
    private WebView gameView;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        title.setText(getResources().getString(R.string.game));
        Intent intent = getIntent();
        webUrl = intent.getStringExtra("gameUrl");
        init();
    }

    @Override
    public int getContnetView() {
        return R.layout.activity_game;
    }

    private void init() {
        gameView = (WebView) findViewById(gameWeb);
        //enable javascript
        WebSettings settings = gameView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);//设定支持viewport
        settings.setLoadWithOverviewMode(true);   //自适应屏幕
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSupportZoom(true);//设定支持缩放
        //WebView加载web资源
        gameView.loadUrl(webUrl);
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        gameView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (gameView.canGoBack()) {
            gameView.goBack();
        } else {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "One more press to exit game",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                super.onBackPressed();
            }

        }
    }



//    @Override
//    public void onPageFinished(WebView view, String url) {
//        CookieManager cookieManager = CookieManager.getInstance();
//        String CookieStr = cookieManager.getCookie(url);
//        Log.e("HEHE", "Cookies = " + CookieStr);
//        super.onPageFinished(view, url);
//    }
}


