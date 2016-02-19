package com.example.ProjetAndroidESGI.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.example.ProjetAndroidESGI.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alban on 14/02/2016.
 */
public class ArticleDAO extends DAOBase {
    public ArticleDAO(Context context) {
        super(context);
    }

    public long add(Article article){
        open();
        ContentValues value = new ContentValues();
        value.put(DatabaseHandler.ARTICLE_TITLE, article.getTitle());
        value.put(DatabaseHandler.ARTICLE_LINK, article.getUrl());
        value.put(DatabaseHandler.ARTICLE_IMG, article.getImg());
        value.put(DatabaseHandler.ARTICLE_CONTENT, article.getContent());
        long result = db.insert(DatabaseHandler.TABLE_ARTICLE, null, value);
        close();

        return result;
    }

    public long add(List<Article> list) {
        open();
        long result = 0;

        for(Article tmp : list) {
            ContentValues value = new ContentValues();
            value.put(DatabaseHandler.ARTICLE_TITLE, tmp.getTitle());
            value.put(DatabaseHandler.ARTICLE_LINK, tmp.getUrl());
            value.put(DatabaseHandler.ARTICLE_IMG, tmp.getImg());
            value.put(DatabaseHandler.ARTICLE_CONTENT, tmp.getContent());
            result += db.insert(DatabaseHandler.TABLE_ARTICLE, null, value);
        }

        close();

        return result;
    }

    public void deleteById(final long id) {
        open();
        db.delete(DatabaseHandler.TABLE_ARTICLE, DatabaseHandler.ARTICLE_ID + " = ?", new String[] {String.valueOf(id)});
        close();
    }

    public void update(Article article) {
        open();
        ContentValues value = new ContentValues();
        value.put(DatabaseHandler.ARTICLE_TITLE, article.getTitle());
        value.put(DatabaseHandler.ARTICLE_LINK, article.getUrl());
        value.put(DatabaseHandler.ARTICLE_IMG, article.getImg());
        value.put(DatabaseHandler.ARTICLE_CONTENT, article.getContent());
        db.update(DatabaseHandler.TABLE_ARTICLE, value, DatabaseHandler.ARTICLE_ID + " = ?", new String[]{String.valueOf(article.getId())});
        close();
    }

    public Article getById(final long id) {
        Article tmp = null;

        read();
        Cursor c = db.rawQuery("SELECT DISTINCT * FROM " + DatabaseHandler.TABLE_ARTICLE + " WHERE "+DatabaseHandler.ARTICLE_ID+" = ?", new String[]{String.valueOf(id)});
        c.moveToFirst();
        tmp = new Article(c.getLong(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4));
        close();

        return tmp;
    }

    public List<Article> getAll() {
        read();
        Cursor c = db.rawQuery("SELECT DISTINCT * FROM " + DatabaseHandler.TABLE_ARTICLE, null);

        List<Article> list = new ArrayList<Article>();
        Article tmp = null;
        while(c.moveToNext()) {
            tmp = new Article(c.getLong(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4));
            list.add(tmp);
        }
        close();

        return list;
    }
}

