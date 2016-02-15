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
public class IgnoreDAO extends DAOBase {

    private ArticleDAO articleDAO;
    public IgnoreDAO(Context context) {

        super(context);
        this.articleDAO = new ArticleDAO(context);
    }

    public void add(Article article) {
        ContentValues value = new ContentValues();
        value.put(DatabaseHandler.IGNORE_TITLE, article.getTitle());
        value.put(DatabaseHandler.IGNORE_LINK, article.getUrl());
        db.insert(DatabaseHandler.TABLE_IGNORE, null, value);
    }

    public void delete(final long id) {
        db.delete(DatabaseHandler.TABLE_IGNORE, DatabaseHandler.IGNORE_ID + " = ?", new String[] {String.valueOf(id)});
    }

    public void update(Article article) {
        ContentValues value = new ContentValues();
        value.put(DatabaseHandler.IGNORE_TITLE, article.getTitle());
        value.put(DatabaseHandler.IGNORE_LINK, article.getUrl());
        db.update(DatabaseHandler.TABLE_IGNORE, value, DatabaseHandler.IGNORE_ID + " = ?", new String[]{String.valueOf(article.getId())});
    }

    public Article getIgnoreById(final long id) {
        Cursor c = db.rawQuery("SELECT DISTINCT * FROM " + DatabaseHandler.TABLE_IGNORE + " WHERE "+DatabaseHandler.IGNORE_ID+" = ?", new String[]{String.valueOf(id)});
        c.moveToNext();

        return new Article(c.getLong(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4));
    }

    public void blockArticleById(final long id) {
        Article blocked = articleDAO.getArticleById(id);
        add(blocked);
        articleDAO.delete(id);
    }

    public List<Article> getAllIgnored() {
        Article tmp = null;
        ArrayList<Article> blocked = new ArrayList();
        Cursor c = db.rawQuery("SELECT DISTINCT * FROM " + DatabaseHandler.TABLE_IGNORE, null);

        while(c.moveToNext()) {
            tmp = new Article(c.getLong(0), c.getString(1), c.getString(2));
            blocked.add(tmp);
        }

        return blocked;
    }
}
