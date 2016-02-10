package com.example.ProjetAndroidESGI;

import android.content.ClipData;
import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.util.List;

/**
 * Created by Maxime on 15/01/2016.
 */
public class Article {

    String title,url,content;
    public Article(String title, String url, String content) {
        this.title = title;
        this.url = url;
        this.content = content;
    }

    @Override
    public String toString(){
        return this.title.substring(0,50) + "...";
    }
}
