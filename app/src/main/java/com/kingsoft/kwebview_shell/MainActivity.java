package com.kingsoft.kwebview_shell;

import android.os.Bundle;
import android.app.Activity;
import android.widget.LinearLayout;
import com.kingsoft.kwebview.WebView;
import com.kingsoft.kwebview.WebViewClient;

public class MainActivity extends Activity {

    private WebView mWebView = null;

    private WebView createWebView() {
        return new WebView(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AwShellResourceProvider.registerResources(this);
        LinearLayout contentContainer = (LinearLayout) findViewById(R.id.content_container);

        mWebView = createWebView();
        contentContainer.addView(mWebView);
        mWebView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f));
        mWebView.setWebViewClient(new KWebViewClient());
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebView.getSettings().setJavaScriptEnabled(true);//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
        mWebView.getSettings().setSupportZoom(true);//是否可以缩放，默认true
        mWebView.getSettings().setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
        mWebView.getSettings().setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
        mWebView.getSettings().setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
        mWebView.getSettings().setAppCacheEnabled(true);//是否使用缓存
        mWebView.getSettings().setDomStorageEnabled(true);//DOM Storage
        mWebView.loadUrl("http://xw.qq.com");d
    }

    class KWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view,String url) {
            if (view != null && url != null) {
                view.loadUrl(url);
            }
            return true;
        }
    }
}
