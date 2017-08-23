package com.example.android.p1db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class EditarActivity extends AppCompatActivity {

    // Declaramos la variable que va a recoger la información
    // que viene como extra en el , Intent ,.
    private int usuarioEditar;

    // Por otro lado declaramos las variables para asignar
    // cada uno de los editText
    EditText editTextNombre, editTextApellido, editTextPass, editTextTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        // Recogemos los extras que llegan aquí desde el , Intent , de
        // la actividad , MostrarActivity ,.
        Bundle extras = this.getIntent().getExtras();{
        // comprobamos que la variable extra del , Intent , viene cargada
        if(extras != null){

            // cargamos la variable con la información que nos ha enviado la
            // actividad , MostrarActivity ,
            usuarioEditar = extras.getInt("idQueVieneConElIntent");


        }

            // Cargamos también las variables con sus editText correspondientes
            editTextNombre = (EditText) findViewById(R.id.editTextName);
            editTextApellido = (EditText) findViewById(R.id.editTextApellido);
            editTextPass = (EditText) findViewById(R.id.editTextPass);
            editTextTime = (EditText) findViewById(R.id.editTextTime);



        }
    }
}











