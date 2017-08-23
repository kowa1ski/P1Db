package com.example.android.p1db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.p1db.data.VigContract;
import com.example.android.p1db.data.VigDbHelper;

public class AgregarActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nombre, apellido, pass, time;
    Button buttonAgregarRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        buttonAgregarRegistro = (Button) findViewById(R.id.buttonInsertReg);

        buttonAgregarRegistro.setOnClickListener(this);

        // Vamos a meter los editText en unas variables
        nombre = (EditText) findViewById(R.id.editTextName);
        apellido = (EditText) findViewById(R.id.editTextApellidoEditable);
        pass = (EditText) findViewById(R.id.editTextPassEditable);
        time = (EditText) findViewById(R.id.editTextTimeEditable);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.buttonInsertReg:

                if (comprobarcampos()){

                    // Declaramos las variables que usaremos aquí dentro a continuacion.
                    String mNombre, mApellido, mPass, mTime;

                    // En las variables mXXXX, metemos la información String de
                    // los editText
                    mNombre = nombre.getText().toString();
                    mApellido = apellido.getText().toString();
                    mPass = pass.getText().toString();
                    mTime = time.getText().toString();

                    // creamos una base llamda bh
                    VigDbHelper bh = new VigDbHelper(this);

                    if (bh != null){

                        // Si tod va bien accedemos en modo escritura.
                        SQLiteDatabase db = bh.getWritableDatabase();

                        // Montamos un ContentValues.
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(VigContract.VigEntry.CN_NOMBRE, mNombre);
                        contentValues.put(VigContract.VigEntry.CN_APELLIDO, mApellido);
                        contentValues.put(VigContract.VigEntry.CN_PASS, mPass);
                        contentValues.put(VigContract.VigEntry.CN_TIME, mTime);

                        // Por fin insertamos los valores en la tabla y leemos el
                        // resultado en una variable de tipo , long , .
                        long insertarRegistro = db.insert(VigContract.VigEntry.TABLE_NAME, null, contentValues);

                        // comprobamos que el nuevo registro se ha insertado correctamente,
                        // se lo decimos al usuario
                        // y borramos los editText.
                        if (insertarRegistro > 0){

                            Toast.makeText(this, R.string.registro_insertado_correctamente, Toast.LENGTH_LONG).show();

                            nombre.setText(R.string.vaciado_de_campo);
                            apellido.setText(R.string.vaciado_de_campo);
                            pass.setText(R.string.vaciado_de_campo);
                            time.setText(R.string.vaciado_de_campo);


                        } else {
                            // Si ha habido algún error se le hace saber al usuario.
                            Toast.makeText(this, R.string.registro_no_insertado, Toast.LENGTH_LONG).show();
                        }



                    }


                } else {

                    Toast.makeText(this, R.string.campos_vacios, Toast.LENGTH_LONG).show();

                }

                break;
            default:

        }

    }

    private boolean comprobarcampos() {

        if ( nombre.getText().toString().isEmpty() || time.getText().toString().isEmpty()){
            return false;
        } else {
            return true;
        }

    }
}
