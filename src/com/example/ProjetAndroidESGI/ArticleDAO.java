package com.example.ProjetAndroidESGI;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by Alban on 14/02/2016.
 */
public class ArticleDAO extends DAOBase {
    public static final String ID_COLUMN = "id";
    public static final String TABLE_NAME = "article";
    public static final String TITLE_COLUMN = "title";
    public static final String LINK_COLUMN = "link";
    public static final String IMG_COLUMN = "img";
    public static final String CONTENT_COLUMN = "content";

    public ArticleDAO(Context context) {
        super(context);
    }

    public void add(Article article) {
        ContentValues value = new ContentValues();
        value.put(TITLE_COLUMN, article.getTitle());
        value.put(LINK_COLUMN, article.getUrl());
        value.put(IMG_COLUMN, article.getImg());
        value.put(CONTENT_COLUMN, article.getContent());
        db.insert(TABLE_NAME, null, value);
    }

    public void remove(long id) {
        db.delete(TABLE_NAME, ID_COLUMN + " = ?", new String[] {String.valueOf(id)});
    }

    public void update(Article article) {
        ContentValues value = new ContentValues();
        value.put(TITLE_COLUMN, article.getTitle());
        value.put(LINK_COLUMN, article.getUrl());
        value.put(IMG_COLUMN, article.getImg());
        value.put(CONTENT_COLUMN, article.getContent());
        db.update(TABLE_NAME, value, ID_COLUMN + " = ?", new String[]{String.valueOf(article.getId())});
    }

    public Article getArticleById(long id) {
        Cursor c = db.rawQuery("SELECT DISTINCT * FROM " + TABLE_NAME + " WHERE "+ID_COLUMN+" = ?", new String[]{String.valueOf(id)});

        return new Article(c.getLong(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4));
    }
}
