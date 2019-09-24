package com.oshimamasara.webviewmaster000;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://blog.codecamp.jp");

        myWebView.setWebViewClient(new MyWebViewClient());
    }

    //アプリ内でブラウザオープン　特定ドメイン以外はブラウザ起動
    // text https://developer.android.com/guide/webapps/webview#HandlingNavigation
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //if ("blog.codecamp.jp".equals(Uri.parse(url).getHost())) {
                return false;
        }
            //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            //startActivity(intent);
            //return true;
        //}
    }
}
