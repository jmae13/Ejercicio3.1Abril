package com.example.ejercicio31abril.configuracion;

public class Transacciones {


    public static final String NameDatabase = " SQLiteDatabase";

    public static final String tablaEmpleados = "Empleados";

    //atributos
    public static final String id= "id";
    public static final String nombre="nombre";
    public static final String apellidos="apellidos";
    public static final String edad="edad";
    public static final String puesto="puesto";
    public static final String direccion="direccion";

    public static final String CREATE_TABLE_Empleados = "CREATE TABLE " + tablaEmpleados +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "nombre TEXT, apellidos TEXT, edad INTEGER, direccion TEXT, puesto TEXT)";





    public static final String DROP_TABLE_Empleados ="DROP TABLE IF EXISTS Empleados";
    public static final String SELECT_ALL_TABLE_EMPLEADOS = "SELECT * FROM " + tablaEmpleados;

}






