package model;

import java.util.Objects;

public class Contacto {

    //atributos
    private String nombre;
    private String apellido;
    private String telefono;

    //metodo constructor
    public Contacto(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    //setters and getters
    public String getNombre() {

        return nombre;
    }

    public String getApellido() {

        return apellido;
    }

    public String getTelefono() {

        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object objeto) {

        if (this == objeto) {
            return true;
        }

        if (objeto == null || getClass() != objeto.getClass()) {
            return false;
        }

        Contacto contacto = (Contacto) objeto;

        return nombre.equalsIgnoreCase(contacto.nombre)
                && apellido.equalsIgnoreCase(contacto.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                nombre.toLowerCase(),
                apellido.toLowerCase()
        );
    }

    //define como se va imprimir un objeto
    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + telefono;
    }
}

