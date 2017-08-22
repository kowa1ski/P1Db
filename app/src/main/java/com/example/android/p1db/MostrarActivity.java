package com.example.android.p1db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.p1db.data.VigClass;
import com.example.android.p1db.data.VigContract;
import com.example.android.p1db.data.VigDbHelper;

import java.util.ArrayList;

import static com.example.android.p1db.data.VigContract.VigEntry;

public class MostrarActivity extends AppCompatActivity {

    // Declaramos el Array y el listView
    private ArrayList<VigClass> vigClassArrayList = new ArrayList<>();
    private ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        // Casamos el listView con el layout.
        listView = (ListView) findViewById(R.id.listViewDeRegistros);

        // Llamamos a un método para llenar la lista y lo generamos
        LlenarLista();

    }

    // Se genera aquí y vamos a rellenar lo que tiene que hacer
    private void LlenarLista() {

        // Vamos a llamar a la basee helper
        VigDbHelper bh = new VigDbHelper(this);
        // Una pequeña comprobación y seguimos
        if (bh != null){

            // Ayudados de , SQLiteDatabase , accedemos en modo lectura
            SQLiteDatabase db = bh.getReadableDatabase();
            // Por fin vamos a cargar un cursor. PASO 1
            Cursor cursor = db.rawQuery("SELECT * FROM "+VigEntry.TABLE_NAME, null);
            // Terminamos de cargar el cursor. Paso 2.
            if (cursor.moveToFirst()){

                do{
                    vigClassArrayList.add(new VigClass(cursor.getString(0),
                            cursor.getString(1), cursor.getString(2),
                            cursor.getString(3), cursor.getString(4)));
                } while (cursor.moveToNext());
            }

        }
        // Ahora declaramos un arreglo para contener la información del cursor
        // La longitud del arreglo será lo gande que sea la lista
        String[] arreglo = new String[vigClassArrayList.size()];

        // el bucle durará hasta que sea más grande que la longitud del arreglo
        for (int i = 0 ; i < arreglo.length; i++){

            // obtenemos una celda de la row(i).
            arreglo[i] = vigClassArrayList.get(i).getNombre();

        }

        // Conformamos un adaptador para la lista
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arreglo);
        listView.setAdapter(adaptador);


    }


}
