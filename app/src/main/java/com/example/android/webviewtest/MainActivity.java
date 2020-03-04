package com.example.android.webviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = (WebView) findViewById(R.id.webViewXML);
        //переменная кот отвечает за настройки веб брауз
        WebSettings webSettings = web.getSettings();
        //вкл js в браузере
        webSettings.setJavaScriptEnabled(true);
        //открывает сайт в нашем прил, а не в браузере по умолчанию
        web.setWebViewClient(new WebViewClient());
        //устан url
        web.loadUrl("https://www.yandex.ru");
    }

    @Override
    public void onBackPressed() {
        if(web.canGoBack()){
            web.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
