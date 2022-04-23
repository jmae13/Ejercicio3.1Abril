package com.example.ejercicio31abril;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejercicio31abril.configuracion.SQLiteConexion;
import com.example.ejercicio31abril.configuracion.Transacciones;

public class MainActivity extends AppCompatActivity {
    EditText textNombre, textApellido, textEdad,textDireccion,textPuesto;
    Button buttonGuardar, buttonVer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNombre = (EditText) findViewById(R.id.textNombre);
        textApellido =(EditText) findViewById(R.id.textApellido);
        textEdad = (EditText) findViewById(R.id.textEdad);
        textDireccion = (EditText) findViewById(R.id.textDireccion);
        textPuesto = (EditText) findViewById(R.id.textPuesto);



        buttonVer = (Button) findViewById(R.id.buttonVer);



        buttonVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar();
                Intent intent = new Intent(getApplicationContext(), activity_lista.class);
                startActivity(intent);
            }
        });

    }

    private void guardar() {
        SQLiteConexion conexion=new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        SQLiteDatabase db=conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Transacciones.nombre, textNombre.getText().toString());
        valores.put(Transacciones.apellidos, textApellido.getText().toString());
        valores.put(Transacciones.edad, textEdad.getText().toString());
        valores.put(Transacciones.direccion, textDireccion.getText().toString());
        valores.put(Transacciones.puesto, textPuesto.getText().toString());



        Long resultado= db.insert(Transacciones.tablaEmpleados, Transacciones.id, valores);
        Toast.makeText(getApplicationContext(),"Introduciendo : Code : " + resultado.toString(), Toast.LENGTH_LONG).show();
        db.close();
        LimpiarPantalla();

    }

    private void LimpiarPantalla() {
        textNombre.setText("");
        textApellido.setText("");
        textEdad.setText("");
        textDireccion.setText("");
        textPuesto.setText("");






    }
}