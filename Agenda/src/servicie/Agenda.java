package servicie;
import java.util.HashSet;

public class Agenda {

    private HashSet<Contacto> contactos;
    private final int capacidadMaxima;

    //asignar capacidad maxima en 10
    public Agenda() {
        contactos = new HashSet<>();
        capacidadMaxima = 10;
    }

    // Método para agregar contactos
    public void añadirContacto(Contacto contacto) {
        contactos.add(contacto);
    }
}