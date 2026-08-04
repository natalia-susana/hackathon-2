package servicie;

import java.util.*;

import model.Contacto;

public class Agenda{


    private List<Contacto> contactos;
    private int capacidadMaxima;

    // Asignar capacidad máxima en 10
    public Agenda() {
        contactos = new ArrayList<>();
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
    //buscar contacto por nombre y apellido, si está, mandarle el número
    public String buscarContacto(String nombre, String apellido) {
        // Validación
        if (nombre == null || apellido == null || nombre.trim().isEmpty() || apellido.trim().isEmpty()) {
            return "El nombre y apellido no pueden estar vacíos.";
        }
        for (Contacto persona : contactos) {
            if (persona.getNombre().equalsIgnoreCase(nombre) && persona.getApellido().equalsIgnoreCase(apellido)) {
                return "Teléfono: " + persona.getTelefono();
            }
        }
        //por si no haya a nadie, q no le dé nada al usuario
        return "No se ha encontrado el contacto: " + nombre + " " + apellido;
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

    //metodo imprimir contactos
    public String verContactos() {
        contactos.sort(Comparator.comparing(Contacto::getNombre));

        String resultado = "";
        for (Contacto c : contactos) {
            resultado += "Nombre: " + c.getNombre() + ", Apellido: " + c.getApellido() + "\n";
        }
        return resultado;
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
    public int espacioLibres() {
        // contactos.size() nos da el número actual de elementos en la lista, q no se te olvide
        int ocupados = contactos.size();
        // saber la diferencia con una resta al total
        int disponibles = capacidadMaxima - ocupados;
        System.out.println("Espacios disponibles en la agenda: " + disponibles);
        return disponibles;
    }
}
