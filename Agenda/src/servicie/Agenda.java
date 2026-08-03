package servicie;
import java.util.HashSet;
import model.Contacto;
public class Agenda{


    private HashSet<Contacto> contactos;
    private int capacidadMaxima;

    //asignar capacidad maxima en 10
    public Agenda() {
        contactos = new HashSet<>();
        capacidadMaxima = 10;
    }

    // Método para agregar contactos
    public void añadirContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    //Buscar por nombre y apellido, si existe, mostrar telefono
    //Arreglo
    private Contacto[] contactoss;
    // Constructor
    public Agenda(int capacidad) {
        this.contactoss = new Contacto[capacidad];
    }
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
}
