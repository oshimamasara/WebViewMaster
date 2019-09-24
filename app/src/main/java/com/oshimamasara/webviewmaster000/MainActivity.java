package com.oshimamasara.webviewmaster000;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = (WebView) findViewById(R.id.webview);

        myWebView.getSettings().setJavaScriptEnabled(true);

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

    //戻るボタン
    @Override
    public void onBackPressed() {
        if(myWebView!= null && myWebView.canGoBack())
            myWebView.goBack();// if there is previous page open it
        else
            super.onBackPressed();//if there is no previous page, close app
    }
}
