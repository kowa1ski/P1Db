package com.example.android.p1db.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


// importamos , VigContract , para hacer más cómodo el
// llamado de la creación de la tabla.

import com.example.android.p1db.data.VigContract.VigEntry;

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

        // Creamos el String para con las sentencias SQL para
        // la creación de la tabla.
        String SQL_CREATE_TABLE_VIG = "CREATE TABLE " + VigEntry.TABLE_NAME + " ("
                + VigEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + VigEntry.CN_NOMBRE + " TEXT NOT NULL, "
                + VigEntry.CN_APELLIDO + " TEXT, "
                + VigEntry.CN_PASS + " TEXT, "
                + VigEntry.CN_TIME + " TEXT);";

        // Ejecutamos la sentencia SQL para la creación de la tabla
        db.execSQL(SQL_CREATE_TABLE_VIG);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
