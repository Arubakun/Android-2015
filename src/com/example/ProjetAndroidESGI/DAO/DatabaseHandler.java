package com.example.ProjetAndroidESGI.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alban on 14/02/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String TABLE_ARTICLE = "article";
    public static final String ARTICLE_ID = "a_id";
    public static final String ARTICLE_TITLE = "a_title";
    public static final String ARTICLE_LINK = "a_link";
    public static final String ARTICLE_IMG = "a_img";
    public static final String ARTICLE_CONTENT = "a_content";

    public static final String TABLE_IGNORE = "ignore";
    public static final String IGNORE_ID = "i_id";
    public static final String IGNORE_TITLE = "i_title";
    public static final String IGNORE_LINK = "i_link";

    public static final String ARTICLE_TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_ARTICLE + ";";
    public static final String IGNORE_TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_IGNORE + ";";


    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ARTICLE_TABLE_DROP+IGNORE_TABLE_DROP);
        onCreate(db);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        final String createArticleRequest = "CREATE TABLE "+ TABLE_ARTICLE +" ("+
                ARTICLE_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ARTICLE_TITLE + " TEXT,"+
                ARTICLE_LINK + " TEXT," +
                ARTICLE_IMG + " TEXT," +
                ARTICLE_CONTENT + " TEXT); ";


        final String createIgnoreArticle = "CREATE TABLE "+ TABLE_IGNORE +" ("+
                IGNORE_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                IGNORE_LINK + " TEXT); ";

        db.execSQL(createArticleRequest+createIgnoreArticle);
    }
}
