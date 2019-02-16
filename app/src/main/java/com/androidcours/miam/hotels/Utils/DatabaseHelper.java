package com.androidcours.miam.hotels.Utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.androidcours.miam.hotels.Models.Hotel;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Helper
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "hotels_db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Hotel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Hotel.TABLE_NAME);
        onCreate(db);
    }

}
