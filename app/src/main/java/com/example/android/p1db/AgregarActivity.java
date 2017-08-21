package com.example.android.p1db;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class AgregarActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nombre, apellido, pass, time;
    Button buttonAgregarRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        buttonAgregarRegistro = (Button) findViewById(R.id.buttonInsertReg);

        buttonAgregarRegistro.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.buttonInsertReg:

                Toast.makeText(this, "Funciona el jodido botón, ou yea!!", Toast.LENGTH_LONG).show();

                break;
            default:

        }

    }
}
