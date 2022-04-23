package com.example.ejercicio31abril;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.ejercicio31abril.configuracion.Empleados;
import com.example.ejercicio31abril.configuracion.SQLiteConexion;
import com.example.ejercicio31abril.configuracion.Transacciones;

import java.io.Serializable;
import java.util.ArrayList;

public class activity_lista extends AppCompatActivity {


    SQLiteConexion conexion;
    ListView list;
    Button buttonModificar;

    //Creando Array
    ArrayList<Empleados> Arraylist;
    ArrayList<String> Aempleados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        conexion=new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        list=(ListView) findViewById(R.id.list);

       ListaD();

        ArrayAdapter adp = new ArrayAdapter( this, android.R.layout.simple_list_item_1, Aempleados);
        list.setAdapter(adp);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Empleados mostrarr = Arraylist.get(i);

                Intent intent = new Intent(activity_lista.this, activity_edit.class);
                Bundle bundle = new Bundle();
                intent.putExtras(bundle);
                startActivity(intent);
                finish();



            }
        });

    buttonModificar = (Button) findViewById(R.id.buttonModificar);



        buttonModificar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(getApplicationContext(), activity_lista.class);
            startActivity(intent);
        }
    });

}


        private void ListaD() {

            SQLiteDatabase db = conexion.getReadableDatabase();
            Empleados list_personas = null;
           Arraylist = new ArrayList<Empleados>();
           Cursor cursor = db.rawQuery("SELECT * FROM " + Transacciones.tablaEmpleados, null);


            while (cursor.moveToNext()) {
                list_personas = new Empleados();
                list_personas.setId(cursor.getInt(0));
                list_personas.setNombre(cursor.getString(1));
                list_personas.setApellidos(cursor.getString(2));
                list_personas.setEdad(cursor.getString(3));
                list_personas.setDireccion(cursor.getString(4));
                list_personas.setPuesto(cursor.getString(5));

                Arraylist.add(list_personas);
            }
            cursor.close();

            filllist();


        }

        private void filllist() {
            Aempleados = new ArrayList<String>();

            for (int i = 0; i < Arraylist.size(); i++) {
                Aempleados.add(Arraylist.get(i).getId() + " | "
                        + Arraylist.get(i).getNombre() + " "
                        + Arraylist.get(i).getApellidos() + " || "
                        + Arraylist.get(i).getPuesto());

            }

        }  }

