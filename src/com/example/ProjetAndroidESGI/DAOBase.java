package com.example.ProjetAndroidESGI;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Alban on 14/02/2016.
 */
public class DAOBase {
    protected static final int VERSION = 1;
    protected static final String db_name = "article.db";

    protected SQLiteDatabase db = null;
    protected DatabaseHandler dbHandler = null;

    public DAOBase(Context context) {
        this.dbHandler = new DatabaseHandler(context, db_name, null, VERSION);
    }

    public SQLiteDatabase open() {

        this.db = dbHandler.getWritableDatabase();
        return this.db;
    }

    public SQLiteDatabase read() {
        this.db = dbHandler.getReadableDatabase();
        return this.db;
    }

    public void close() {
        this.db.close();
    }

    public SQLiteDatabase getDB() {
        return this.db;
    }
}
