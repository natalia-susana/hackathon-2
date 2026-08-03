package servicie;

import java.util.HashSet;
import model.Contacto;

public class Agenda {

    private HashSet<Contacto> contactos;
    private final int capacidadMaxima;

    // Asignar capacidad máxima en 10
    public Agenda() {
        contactos = new HashSet<>();
        capacidadMaxima = 10;
    }

    // Método para agregar contactos
    public void añadirContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    /**
     * Tarea Elios: Verifica si un contacto existe en la agenda.
     */
    public boolean existeContacto(Contacto c) {
        if (c == null) {
            return false;
        }
        return contactos.contains(c);
    }
}