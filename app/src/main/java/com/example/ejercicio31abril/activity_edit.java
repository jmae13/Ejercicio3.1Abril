package com.example.ejercicio31abril;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ejercicio31abril.configuracion.Empleados;
import com.example.ejercicio31abril.configuracion.SQLiteConexion;
import com.example.ejercicio31abril.configuracion.Transacciones;

public class activity_edit extends AppCompatActivity {
    EditText textNombre2, textApellido2, textEdad2,textDireccion2,textPuesto2;
    TextView textId;
    Button buttonEdit, buttonBorrar;
    SQLiteConexion conexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);


        Button Edit = (Button) findViewById(R.id.buttonEdit);
        Button Borrar = (Button) findViewById(R.id.buttonBorrar);

        textId = (TextView) findViewById(R.id.textId);
        textNombre2 = (EditText) findViewById(R.id.textNombre2);
        textApellido2 = (EditText) findViewById(R.id.textApellido2);
        textEdad2 = (EditText) findViewById(R.id.textEdad2);
        textDireccion2 = (EditText) findViewById(R.id.textDireccion2);
        textPuesto2 = (EditText) findViewById(R.id.textPuesto2);


        Bundle obj = getIntent().getExtras();

        Empleados show = null;

        if (obj != null) {
           show = (Empleados)  obj.getSerializable("Empleados");

            textId.setText(show.getId().toString());
            textNombre2.setText(show.getNombre().toString());
            textApellido2.setText(show.getApellidos().toString());
            textEdad2.setText(show.getEdad());
            textDireccion2.setText(show.getDireccion().toString());
            textPuesto2.setText(show.getPuesto().toString());
        }
       Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!textNombre2.getText().toString().isEmpty() && !textApellido2.getText().toString().isEmpty() && !textEdad2.getText().toString().isEmpty() && !textDireccion2.getText().toString().isEmpty()  && !textPuesto2.getText().toString().isEmpty() ){
                   Editar();
                }
                else{
                    Toast.makeText(getApplicationContext()," Culminar" ,Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    private void Editar() {
        SQLiteDatabase db = conexion.getWritableDatabase();
        String[] params = {textId.getText().toString()};
        ContentValues valores = new ContentValues();
        valores.put(Transacciones.nombre, textNombre2.getText().toString());
        valores.put(Transacciones.apellidos, textApellido2.getText().toString());
        valores.put(Transacciones.edad, textEdad2.getText().toString());
        valores.put(Transacciones.direccion, textDireccion2.getText().toString());
        valores.put(Transacciones.puesto,textPuesto2.getText().toString());

        db.update(Transacciones.tablaEmpleados, valores, Transacciones.id + "=?", params);
        Toast.makeText(getApplicationContext(), "Informacion en bd", Toast.LENGTH_LONG).show();
       Clean();


    }



    private void Clean() {
        textNombre2.setText("");
        textApellido2.setText("");
        textEdad2.setText("");
        textDireccion2.setText("");
        textPuesto2.setText("");


    }
}