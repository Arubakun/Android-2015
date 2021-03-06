package com.example.ProjetAndroidESGI.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.ProjetAndroidESGI.DAO.DatabaseHandler;

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
        if(this.db != null && !this.db.isOpen())
            this.db = dbHandler.getWritableDatabase();

        return this.db;
    }

    public SQLiteDatabase read() {
        if(this.db != null && !this.db.isOpen())
            this.db = dbHandler.getReadableDatabase();

        return this.db;
    }

    public void close() {
        if(this.db != null && this.db.isOpen())
            this.db.close();
    }

    public SQLiteDatabase getDB() {
        return this.db;
    }
}
