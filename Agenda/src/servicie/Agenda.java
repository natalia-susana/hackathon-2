package servicie;
import java.util.HashSet;
import java.util.Scanner;
import model.Contacto;

public class Agenda{

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


    // Metodo para modificar teléfono
    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        Scanner sc = new Scanner(System.in);

        // Recorremos la agenda para verificar si el contacto existe
        for (Contacto persona : contactos) {
            if (persona.getNombre().equalsIgnoreCase(nombre) && persona.getApellido().equalsIgnoreCase(apellido)) {

                // verificamos que el parametro de numero contenga un valor, si es así, le quitamos signos extra y solo quedan digitos
                String telefonoValido = (nuevoTelefono != null) ? nuevoTelefono.replaceAll("\\D", "") : "";

                // Si no tiene 10 dígitos, solicitamos la corrección en bucle
                while (telefonoValido.length() != 10) {
                    System.out.println("Número inválido. El número ingresado debe tener 10 dígitos.");
                    System.out.print("Ingresa el nuevo número: ");
                    telefonoValido = sc.nextLine().replaceAll("\\D", "");
                }

                // Guardamos el número hasta que cumpla la condición de 10 digitos
                persona.setTelefono(telefonoValido);
                System.out.println("Teléfono actualizado con éxito.");
                return;
            }
        }

        //si nombre y apellido no hacen match con los contactos guardados, enviamos mensaje
        System.out.println("Ese contacto no existe en tu agenda.");
    }
}