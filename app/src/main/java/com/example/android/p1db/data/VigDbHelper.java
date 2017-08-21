package com.example.android.p1db.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Usuario on 21/08/2017.
 */

                        // extendemos de SQLiteOpeHelper
public class VigDbHelper extends SQLiteOpenHelper {

    //Creamos los métodos y el constructor con la bombilla
    public VigDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
