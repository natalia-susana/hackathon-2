package servicie;

import java.util.ArrayList;
import java.util.List;
import model.Contacto;
public class Agenda {


    private List<Contacto> contactos;
    private int capacidadMaxima;

    // Asignar capacidad máxima en 10
    public Agenda() {
        this.contactos = new ArrayList<>();
        this.capacidadMaxima = 10;
    }

    // Constructor con tamaño personalizado
    public Agenda(int capacidad) {
        this.contactos = new ArrayList<>();
        this.capacidadMaxima = capacidad > 0 ? capacidad : 10;
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

    //Buscar por nombre y apellido, si existe, mostrar telefono
    //Arreglo
    private Contacto[] contactoss;


    public String buscarContacto(String nombre, String apellido) {
        // Validación
        if (nombre == null || apellido == null || nombre.trim().isEmpty() || apellido.trim().isEmpty()) {
            return "El nombre y apellido no pueden estar vacíos.";
        }
        for (Contacto c : contactoss) {
            if (c != null) {
                if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                    return "Teléfono: " + c.getTelefono();
                }
            }
        }
        return "Contacto no encontrado: " + nombre + " " + apellido;
    }


    // eliminarContacto
// Elimina un contacto de la agenda basándose en la coincidencia de nombre y apellido
    public void eliminarContacto(Contacto c) {
        if (c == null) {
            System.out.println("El contacto proporcionado no es válido.");
            return;
        }

        if (contactos.remove(c)) {
            System.out.println("El contacto fue eliminado exitosamente de la agenda.");
        } else {
            System.out.println("No se pudo eliminar: El contacto no fue encontrado en la agenda.");
        }
    }

    // agendaLlena
// Indica si la agenda ha alcanzado su capacidad máxima permitida
    public boolean agendaLlena() {
        if (contactos.size() >= capacidadMaxima) {
            System.out.println("La agenda está llena. No hay espacio disponible para nuevos contactos.");
            return true;
        } else {
            System.out.println("¡La agenda no está llena. Aún hay espacio disponible.");
            return false;
        }
    }
}
