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
    private long id;
    private String title;
    private String url;
    private String img;
    private String content;


    public Article(String title, String url, String img, String content) {
        this.title = title;
        this.url = url;
        this.img = img;
        this.content = content;
    }

    public Article(long id, String title, String url, String img, String content) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.img = img;
        this.content = content;
    }

    @Override
    public String toString(){
        return this.title.substring(0,50) + "...";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
