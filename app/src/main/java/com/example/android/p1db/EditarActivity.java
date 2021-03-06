package com.example.android.p1db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
                    editTextNombre.setText(cursor.getString(cursor.getColumnIndex(VigContract.VigEntry.CN_NOMBRE)));
                    // En este caso atrapamos la 3a columna con el número 2...
                    editTextApellido.setText(cursor.getString(2));
                    // ... y aquí la 4a con el número 3.
                    editTextPass.setText(cursor.getString(cursor.getColumnIndex(VigContract.VigEntry.CN_PASS)));
                    editTextTime.setText(cursor.getString(4));

                }

            } finally {

            }
        }



    }

    public void editar(View view){

        // Lo de siempre bh(que ahora lo pongo como vigDbHelper...db etc.
        VigDbHelper vigDbHelper = new VigDbHelper(this);
        if(vigDbHelper != null){
            SQLiteDatabase db = vigDbHelper.getWritableDatabase();

            // Montamos el contenedor de valores
            ContentValues contentValues = new ContentValues();
            contentValues.put(VigContract.VigEntry.CN_NOMBRE, editTextNombre.getText().toString());
            contentValues.put(VigContract.VigEntry.CN_APELLIDO, editTextApellido.getText().toString());
            contentValues.put(VigContract.VigEntry.CN_PASS, editTextPass.getText().toString());
            contentValues.put(VigContract.VigEntry.CN_TIME, editTextTime.getText().toString());
            // Ahora sí, vamos a actualizar el registro
            long response = db.update(VigContract.VigEntry.TABLE_NAME, contentValues,
                    VigContract.VigEntry._ID +" = " + usuarioEditar, null);
            if (response > 0 ){
                Toast.makeText(this, "EL REGISTRO SE HA EDITADO", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "hubo un problema, registro no editado", Toast.LENGTH_LONG).show();
            }

        }



    }
}











