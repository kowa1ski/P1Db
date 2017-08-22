package com.example.android.p1db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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

    // Declaramos esta variable poniéndola a , -1 , porque
    // ese valor indica que no hay ninguno seleccionado.
    // La usaremos en el , listener , del , onClick , ese largo que
    // vamos a hacer en este paso.
    private int usuarioSeleccionado = -1 ;
    // Delaramos también este objeto que usaremos en el método del , listener ,.
    private Object mActionMode;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        // Casamos el listView con el layout.
        listView = (ListView) findViewById(R.id.listViewDeRegistros);

        // Llamamos a un método para llenar la lista y lo generamos
        LlenarLista();
        onClick();

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

    // Vamos a crear el método , onClick , para poner un listener y poder selecionar de la lista
    private void onClick() {

        // Primero le decimos que se va a tratar de una seleción , single , o sea que no es multiple
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        // Ahora sí, le vamos a meter el , listener , de click largo
        // OJO , que sea el que es, que sea el ITEM, setonITEMlonclicklistener
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override   // Este , Override , se ha generado sólo automáticamente al escribir el
                        // interior del paréntesis de arriba.
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                // El item seleccionado nos lo da la , position,.
                usuarioSeleccionado = position;
                // Vamos a elaborar un , callBack,.
                // Aquí , amc , será un tipo de objeto , callback,.
                 // MUY ATENTO porque en el tutorial es, ... .this.starActionmode(... , y
                // y me daba un error muy raro. Lo he solucionado con
                // esa otra , startSupportActionMode , que por lo visto es la que se corresponde
                // apropiadamente con el import , import android.support.v7.view.ActionMode;
                mActionMode = MostrarActivity.this.startSupportActionMode(amc);
                // Esto hay que escribirlo y ya está, no pregunto mucho más.
                view.setSelected(true);

                return true;
            }
        });

    }
    // Es jodido pero vamos a construir ese , amc ,.
    private ActionMode.Callback amc = new ActionMode.Callback() {
        @Override           // Todos estos , Override , se han generado por arte de magia
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // Este es el , Override , que nos hace falta. Vamos a por él.
            // En , R.menu , todavia no hemos credo el menu que nos lo ç
            // tragamos primero en rojo. Tenemos que crear un , android.resource.file ,
            // en el menú de 1:Project y
            // en , res , click derecho.
            // Luego, que sea de nombre opciones,
            // tipo menu y entonces se generará un xml
            // y desaparecerá el error
            getMenuInflater().inflate(R.menu.opciones, menu);

            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }
    };




}
















