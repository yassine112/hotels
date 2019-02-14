//package com.androidcours.miam.hotels.Utils;
//
//import android.database.sqlite.SQLiteDatabase;
//
//import java.util.List;
//
///**
// * Created by Yassine EL HALAOUI on 2/11/19.
// */
//
//public abstract class Datasource<T> {
//    protected SQLiteDatabase mDatabase;
//
//    public Datasource(SQLiteDatabase database) {
//        mDatabase = database;
//    }
//
//    public abstract boolean insert(T entity);
//    public abstract boolean delete(T entity);
//    public abstract boolean update(T entity);
//    public abstract List read();
//    public abstract List read(String selection, String[] selectionArgs, String groupBy, String having, String orderBy);
//
//}
