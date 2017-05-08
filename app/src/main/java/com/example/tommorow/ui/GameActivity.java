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
 * Created by lenovo on 2017/4/22.
 * Controller class, corresponding to layout file
 * Handle the game activity logic
 * Hold a webview to set html5 game
 * Layout file name: activity_game.xml
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
        settings.setUseWideViewPort(true);//set viewport
        settings.setLoadWithOverviewMode(true);   //adjusted to window
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSupportZoom(true);
        //WebView load the web resource
        gameView.loadUrl(webUrl);
        //overload WebView
        gameView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                view.loadUrl(url);
                return true;
            }
        });
    }

    /**
     * Override the back button
     *
     */
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


