package com.example.android.p1db;

import android.database.Cursor;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.android.p1db.data.VigContract;
import com.example.android.p1db.data.VigDbHelper;

public class MostrarConCursorActivity extends AppCompatActivity {


    private VigDbHelper vigDbHelper;

    private Cursor cursor;
    private ListView listView;
    SimpleCursorAdapter simpleCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_con_cursor);


        vigDbHelper = new VigDbHelper(this);
        listView = (ListView) findViewById(R.id.listViewConCursor2);
        cursor = vigDbHelper.CargarCursorContactos(this);

        String[] from = new String[] {VigContract.VigEntry.CN_NOMBRE,
                                        VigContract.VigEntry.CN_TIME};
        int[] to = new int[]{android.R.id.text1, android.R.id.text2};
        simpleCursorAdapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item, cursor, from,to, 0);

        listView.setAdapter(simpleCursorAdapter);




    }



}
