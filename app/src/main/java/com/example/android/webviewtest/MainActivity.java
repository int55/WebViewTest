package com.example.android.webviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView web;
    private long backPressedTime;
    private Toast toastBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = (WebView) findViewById(R.id.webViewXML);
        //переменная которая отвечает за настройки веб брауз
        WebSettings webSettings = web.getSettings();
        //включает js в браузере
        webSettings.setJavaScriptEnabled(true);
        //открывает сайт в нашем приложении, а не в браузере по умолчанию
        web.setWebViewClient(new WebViewClient());
        //устан url
        web.loadUrl("https://www.yandex.ru");
    }

    @Override
    public void onBackPressed() {
        if(web.canGoBack()){
            web.goBack();
        }else  //Системная кнопка "Назад". Двойное нажатие -закрытие приложения
            if (backPressedTime + 2000 > System.currentTimeMillis()){
            toastBack.cancel(); //закрыть Toast
            //закрываем приложение
            super.onBackPressed();
            return;
        }else {

            //Системная кнопка "Назад". Первое нажатие, всплыв подсказка
            toastBack = Toast.makeText(getBaseContext(),"Нажмите еще раз чтобы выйти", Toast.LENGTH_SHORT);
            toastBack.show(); // показать Toast
        }
        backPressedTime = System.currentTimeMillis(); // получаем текущее время в мл/сек
    }
}
