package com.example.android.p1db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.android.p1db.data.VigContract;
import com.example.android.p1db.data.VigDbHelper;

public class EditarActivity extends AppCompatActivity {

    // Declaramos la variable que va a recoger la información
    // que viene como extra en el , Intent ,.
    private String usuarioEditar;

    // Por otro lado declaramos las variables para asignar
    // cada uno de los editText
    EditText editTextNombre, editTextApellido, editTextPass, editTextTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        // Recogemos los extras que llegan aquí desde el , Intent , de
        // la actividad , MostrarActivity ,.
        Bundle extras = this.getIntent().getExtras();
        // comprobamos que la variable extra del , Intent , viene cargada
        if(extras != null){

            // cargamos la variable con la información que nos ha enviado la
            // actividad , MostrarActivity ,
            usuarioEditar = extras.getString("idQueVieneConElIntent");


        }

            // Cargamos también las variables con sus editText correspondientes
            editTextNombre = (EditText) findViewById(R.id.editTextNombreEditable);
            editTextApellido = (EditText) findViewById(R.id.editTextApellidoEditable);
            editTextPass = (EditText) findViewById(R.id.editTextPassEditable);
            editTextTime = (EditText) findViewById(R.id.editTextTimeEditable);


        // Llamamos a una función de rellenado y creamos el método
        reflejarCampos();

    }

    // Aquí la función de rellenado de campos.
    private void reflejarCampos() {

        // Hacemos tod este tema de la base de datos
        VigDbHelper bh = new VigDbHelper(this);
        if (bh != null){
            SQLiteDatabase bd = bh.getReadableDatabase();
            // cargamos un cursor que recoge la Query
            Cursor cursor = bd.rawQuery("SELECT * FROM " + VigContract.VigEntry.TABLE_NAME
            + " WHERE " + VigContract.VigEntry._ID
            + " = " + usuarioEditar, null);

            try {
                // Si el cursor se mueve al siguiente, significa
                // que sí que existen registros.
                if(cursor.moveToNext()){
                    // Escribimos dentro de los campos la información del
                    // cursor.
                    /*
                    Voy a usar , getColumnIndex , y getString indistintamente
                    aunque sirvan para lo mismo por ser este un ejercicio.
                     */
                    editTextNombre.setText(cursor.getString(1));
                    // En este caso atrapamos la 3a columna con el número 2...
                    editTextApellido.setText(cursor.getString(2));
                    // ... y aquí la 4a con el número 3.
                    editTextPass.setText(cursor.getString(3));
                    editTextTime.setText(cursor.getString(4));



                }

            } finally {

            }
        }



    }
}











