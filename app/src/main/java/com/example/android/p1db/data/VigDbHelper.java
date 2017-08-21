package com.example.android.p1db.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Usuario on 21/08/2017.
 */


public class VigDbHelper extends SQLiteOpenHelper {

    // Damos nombre a la base y numeramos la versión
    private static final String DATABASE_NAME = "p1bd.sqlite";
    private static final int DATABASE_VERSION = 1 ;


    // Borramos los parámetros que no hacen falta porque le pasamos directamente
    // los valores a la superclase desde aquí
    public VigDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
