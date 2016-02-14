package com.example.ProjetAndroidESGI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by Maxime on 06/01/2016.
 */
public class ArticleWeb extends Activity {
    WebView article_web;

    @Override
    public void onCreate(Bundle savedInstanceState){

        setContentView(R.layout.web);
        this.article_web = (WebView)findViewById(R.id.webView);
        Intent i = getIntent();
        String url = i.getStringExtra("URL");
        this.setUrl(url);
        super.onCreate(savedInstanceState);
    }

    public void setUrl(String url){
        this.article_web.loadUrl(url);
    }
}
