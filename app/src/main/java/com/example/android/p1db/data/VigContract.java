package com.example.android.p1db.data;

import android.provider.BaseColumns;

/**
 * Created by Usuario on 21/08/2017.
 */


// Ojo, se nombra , final , esta clase
public final class VigContract {

    // prevenimos que inicialicen la clase con esta instrucción
    private VigContract(){}

    // Creamos esta subclase para darle nombre a la tabla y sus columnas.
    public static final class VigEntry implements BaseColumns {

        public static final String TABLE_NAME = "vigilancias";

        public static final String _ID = BaseColumns._ID;

        public static final String CN_NOMBRE = "nombre";
        public static final String CN_APELLIDO = "apellido";
        public static final String CN_PASS = "pass";
        public static final String CN_TIME = "time";



    }

}
