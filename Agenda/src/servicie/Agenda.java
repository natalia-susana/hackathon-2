public class Agenda {



























    //Buscar por nombre y apellido, si existe, mostrar telefono
    //Arreglo
    private Contacto[] contactos;
    // Constructor
    public Agenda(int capacidad) {
        this.contactos = new Contacto[capacidad];
    }
    public String buscarContacto(String nombre, String apellido) {
        // Validación
        if (nombre == null || apellido == null || nombre.trim().isEmpty() || apellido.trim().isEmpty()) {
            return "El nombre y apellido no pueden estar vacíos.";
        }
        for (Contacto c : contactos) {
            if (c != null) {
                if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                    return "Teléfono: " + c.getTelefono();
                }
            }
        }
        return "Contacto no encontrado: " + nombre + " " + apellido;
    }
}
