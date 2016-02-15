package com.example.ProjetAndroidESGI.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.example.ProjetAndroidESGI.Article;

/**
 * Created by Alban on 14/02/2016.
 */
public class ArticleDAO extends DAOBase {

    public ArticleDAO(Context context) {
        super(context);
    }

    public void add(Article article) {
        ContentValues value = new ContentValues();
        value.put(DatabaseHandler.ARTICLE_TITLE, article.getTitle());
        value.put(DatabaseHandler.ARTICLE_LINK, article.getUrl());
        value.put(DatabaseHandler.ARTICLE_IMG, article.getImg());
        value.put(DatabaseHandler.ARTICLE_CONTENT, article.getContent());
        db.insert(DatabaseHandler.TABLE_ARTICLE, null, value);
    }

    public void delete(final long id) {
        db.delete(DatabaseHandler.TABLE_ARTICLE, DatabaseHandler.ARTICLE_ID + " = ?", new String[] {String.valueOf(id)});
    }

    public void update(Article article) {
        ContentValues value = new ContentValues();
        value.put(DatabaseHandler.ARTICLE_TITLE, article.getTitle());
        value.put(DatabaseHandler.ARTICLE_LINK, article.getUrl());
        value.put(DatabaseHandler.ARTICLE_IMG, article.getImg());
        value.put(DatabaseHandler.ARTICLE_CONTENT, article.getContent());
        db.update(DatabaseHandler.TABLE_ARTICLE, value, DatabaseHandler.ARTICLE_ID + " = ?", new String[]{String.valueOf(article.getId())});
    }

    public Article getArticleById(final long id) {
        Cursor c = db.rawQuery("SELECT DISTINCT * FROM " + DatabaseHandler.TABLE_ARTICLE + " WHERE "+DatabaseHandler.ARTICLE_ID+" = ?", new String[]{String.valueOf(id)});

        return new Article(c.getLong(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4));
    }
}
