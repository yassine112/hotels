//package com.androidcours.miam.hotels.Utils;
//
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//
//import java.util.List;
//
//public class SqliteHelper extends Datasource {
//
//    private String path = "";
//    private String databaseName = "";
//    private SQLiteDatabase db;
//    private Cursor cursor;
//
//    // Constructor
//    public SqliteHelper (String path, String databaseName) {
//        this.path = path;
//        this.databaseName = databaseName;
//        this.db = getDatabaseWith(path+databaseName);
//    }
//
//    // Methods
//    private SQLiteDatabase getDatabaseWith(String databasePath) {
//        return SQLiteDatabase.openDatabase(databasePath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
//    }
//
//    public Cursor getById(String table, Integer id) {
//        String query = "SELECT * FROM " + table + " WHERE id = ?";
//        cursor = db.rawQuery(query, new String[]{ id.toString() });
//        if (cursor.getCount() > 0) {
//            return cursor;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean insert(Object entity) {
//        return false;
//    }
//
//    @Override
//    public boolean delete(Object entity) {
//        return false;
//    }
//
//    @Override
//    public boolean update(Object entity) {
//        return false;
//    }
//
//    @Override
//    public List read() {
//        return null;
//    }
//
//    @Override
//    public List read(String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
//        return null;
//    }
//}
