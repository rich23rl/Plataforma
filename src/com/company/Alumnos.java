package com.company;

public class Alumnos {
    String Nombre;
    String Apellido;
    String Intereses;
    String Descripcion;

    public Alumnos(String Nombre,String Apellido,String Intereses,String Descripcion)
    {
        this.Nombre = Nombre;
        this.Apellido= Apellido;
        this.Intereses = Intereses;
        this.Descripcion = Descripcion;

    }

    public void setNome(String nombre){
        this.Nombre = nombre;

    }
}
