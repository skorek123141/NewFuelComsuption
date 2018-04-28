package com.example.skore.newfuelcomsuption;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by skore on 12.04.2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "AvgFuel.db";
    public static final String TABLE_NAME = "avgFuel_table";

    public static final String ID = "ID";
    public static final String AMOUNT_FUEL = "AMOUNT_FUEL";
    public static final String AMOUNT_KM = "AMOUNT_KM";
    public static final String AVG = "AVG";
    public static final String DATA = "DATA";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AMOUNT_FUEL + " REAL, " + AMOUNT_KM + " REAL, " + AVG + " REAL, " + DATA + " TEXT" + ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String amount_fuel, String amount_km, double avg){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(AMOUNT_FUEL,amount_fuel);
        contentValues.put(AMOUNT_KM,amount_km);
        contentValues.put(AVG,avg);
        contentValues.put(DATA,getNow());
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public void removeData(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + ID + " =\"" + id + "\";");
    }
    private String getNow(){
        // set the format to sql date time
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}