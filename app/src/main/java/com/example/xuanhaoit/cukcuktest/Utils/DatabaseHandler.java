package com.example.xuanhaoit.cukcuktest.Utils;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by XuanHaoIT on 20/09/2017.
 */

public class DatabaseHandler  extends SQLiteOpenHelper {
    private Context context;
    SQLiteDatabase db;
    static final String dbPath = "/data/data/com.example.xuanhaoit.cukcuktest/databases/";
    static final String dbName = "Restaurant.sqlite";
    static final String PATH = dbPath + dbName;
    static final Integer VERSION = 1;

    public DatabaseHandler(Context context) {
        super(context, dbName, null, VERSION);
        this.context = context;
        openDB();
    }

    public SQLiteDatabase openDB() {
        SQLiteDatabase dbCheck = null;
        try {
            dbCheck = SQLiteDatabase.openDatabase(PATH, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (dbCheck == null) {
            copyDatabaseToSDCard();
        } else {
            dbCheck.close();
            db = SQLiteDatabase.openDatabase(PATH, null, SQLiteDatabase.OPEN_READWRITE);
        }
        return db;
    }

    public void closeDB() {
        db.close();
    }

    public boolean copyDatabaseToSDCard() {
        this.getReadableDatabase();
        try {
            InputStream mInput = context.getAssets().open(getDatabaseName());
            OutputStream mOutput = new FileOutputStream(PATH);
            byte[] buffer = new byte[1024];
            int lenght;
            while ((lenght = mInput.read(buffer)) > 0) {
                mOutput.write(buffer, 0, lenght);
            }
            mOutput.flush();
            mOutput.close();
            mInput.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getCount(String sql) {
        Cursor cur = getCursor(sql);
        int count = cur.getCount();
        closeDB();
        return count;

    }

    public void ExcuteSQL(String sql) {
        openDB();
        db.execSQL(sql);
        closeDB();

    }

    public Cursor getCursor(String sql) {
        openDB();
        return db.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}