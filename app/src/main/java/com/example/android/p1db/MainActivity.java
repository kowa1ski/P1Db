package com.example.android.p1db;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAgregar, buttonMostrar, buttonMostrarConCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAgregar = (Button) findViewById(R.id.buttonAgregar);
        buttonMostrar = (Button) findViewById(R.id.buttonMostrar);
        buttonMostrarConCursor = (Button) findViewById(R.id.buttonMostrarConCursor);

        buttonMostrar.setOnClickListener(this);
        buttonAgregar.setOnClickListener(this);
        buttonMostrarConCursor.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.buttonAgregar:

                Intent intentAgregar = new Intent(this, AgregarActivity.class);
                startActivity(intentAgregar);

                break;

            case R.id.buttonMostrar:

                Intent intentMostrar = new Intent(this, MostrarActivity.class);
                startActivity(intentMostrar);

                break;

            case R.id.buttonMostrarConCursor:

                Intent intentMostrarConCursor = new Intent(this, MostrarConCursorActivity.class);
                startActivity(intentMostrarConCursor);

            default:


        }

    }
}
