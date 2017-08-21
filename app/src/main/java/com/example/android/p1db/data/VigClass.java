package com.example.android.p1db.data;

/**
 * Created by Usuario on 21/08/2017.
 */

/*
Creamos la clase , VigClass , para poder montarla en el Array
 */
public class VigClass {

    //Declaramos las variables que vamos a usar para lo setters y eso
    private String nombre, apellido, pass, time;


    // El constructor lo generamos con la bombilla y, fuera del constructor, los
    // getters y los setters con la bombilla también
    public VigClass(String nombre, String apellido, String pass, String time) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pass = pass;
        this.time = time;


        // asignamos los valoores a los setters
        setNombre(nombre);
        setApellido(apellido);
        setPass(pass);
        setTime(time);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
