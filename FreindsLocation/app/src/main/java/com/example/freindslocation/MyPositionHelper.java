package com.example.freindslocation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyPositionHelper extends SQLiteOpenHelper {
    public static final String table="Position";
    public static final String column_name="Name";
    public static final String column_lang="Latitude";
    public static final String column_lat="Langitude";

    String req="Create Table "+ table+" ( "+column_name+" Text Not Null,"+column_lang+
            " Text Not Null,"+column_lat+" Text Not Null)";
    public MyPositionHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(req);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table "+table+" ");
        onCreate(MainActivity.bd);

    }
}
