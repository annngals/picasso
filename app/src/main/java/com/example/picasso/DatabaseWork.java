package com.example.picasso;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseWork {
    private static SQLiteDatabase db;
    private SQLiteOpenHelper openHelper;
    private static DatabaseWork instance;
    Cursor c = null;

    private DatabaseWork(Context context) {
        this.openHelper = new DatabaseHelper(context);
    }

    public static DatabaseWork getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseWork(context);
        }
        return instance;
    }

    public void open() {
        this.db = openHelper.getWritableDatabase();
    }

    public void close() {
        if (db!=null) {
            this.db.close();
        }
    }

    public static Cursor getData() {
        return db.query("products", null, null, null, null, null, null);

        //return db.rawQuery("select * from products", null);
    }
}