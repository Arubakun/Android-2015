package com.example.ProjetAndroidESGI;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alban on 14/02/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String ID_COLUMN = "id";
    public static final String TABLE_NAME_ARTICLE = "article";
    public static final String TITLE_COLUMN = "title";
    public static final String LINK_COLUMN = "link";
    public static final String IMG_COLUMN = "img";
    public static final String CONTENT_COLUMN = "content";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String createArticleRequest = "CREATE TABLE "+TABLE_NAME_ARTICLE+" ("+
                ID_COLUMN+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                TITLE_COLUMN + " TEXT,"+
                LINK_COLUMN + " TEXT," +
                IMG_COLUMN + "TEXT," +
                CONTENT_COLUMN + " TEXT); ";

        db.execSQL(createArticleRequest);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
