package com.example.ejercicio31abril.configuracion;

public class Empleados {


    private Integer id;
    String Nombre;
    String Apellidos;
    String Qth;
    String Puesto,Edad;

    public Empleados(String Nombre, String Apellidos, String Qth, String Puesto, String Edad, Integer id) {
        Nombre = Nombre;
        Apellidos = Apellidos;
        Qth = Qth;
        Puesto = Puesto;
        Edad = Edad;


        this.id = id;
    }

    public Empleados() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getDireccion() {
        return Qth;
    }

    public void setDireccion(String direccion) {
        Qth = direccion;
    }

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String puesto) {
        Puesto = puesto;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
