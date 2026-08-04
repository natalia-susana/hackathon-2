package ui;

import java.util.Scanner;
import model.Contacto;
import servicie.Agenda;

public class Menu {

    private Agenda agenda;
    private Scanner scanner;

    public Menu() {
        this.agenda = new Agenda();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = 0;

        do {
            System.out.println("    MENÚ AGENDA DE CONTACTOS     ");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Verificar si existe un contacto");
            System.out.println("3. Buscar teléfono de un contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Modificar teléfono");
            System.out.println("6. Ver todos los contactos");
            System.out.println("7. Verificar si la agenda está llena");
            System.out.println("8. Ver espacios libres");
            System.out.println("9. Salir");
            System.out.print("Selecciona una opción (1-9): ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingresa un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    opcionAñadirContacto();
                    break;
                case 2:
                    opcionExisteContacto();
                    break;
                case 3:
                    opcionBuscarContacto();
                    break;
                case 4:
                    opcionEliminarContacto();
                    break;
                case 5:
                    opcionModificarTelefono();
                    break;
                case 6:
                    opcionVerContactos();
                    break;
                case 7:
                    agenda.agendaLlena();
                    break;
                case 8:
                    agenda.espacioLibres();
                    break;
                case 9:
                    System.out.println("Saliendo de la agenda... ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }

        } while (opcion != 9);
    }

    private void opcionAñadirContacto() {
        System.out.println("\nAÑADIR CONTACTO");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine().trim();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine().trim();

        if (nombre.isEmpty() || apellido.isEmpty()) {
            System.out.println("El nombre y el apellido no pueden estar vacíos.");
            return;
        }

        Contacto nuevo = new Contacto(nombre, apellido, telefono);

        if (agenda.existeContacto(nuevo)) {
            System.out.println("No se puede añadir: El contacto ya existe en la agenda.");
        } else {
            agenda.añadirContacto(nuevo);
            System.out.println("Contacto añadido correctamente.");
        }
    }

    private void opcionExisteContacto() {
        System.out.println("\n--- VERIFICAR SI EXISTE CONTACTO ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine().trim();

        Contacto aux = new Contacto(nombre, apellido, "");
        if (agenda.existeContacto(aux)) {
            System.out.println("El contacto SI existe en la agenda.");
        } else {
            System.out.println("El contacto NO existe en la agenda.");
        }
    }

    private void opcionBuscarContacto() {
        System.out.println("\nBUSCAR TELÉFONO DE CONTACTO");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine().trim();

        String resultado = agenda.buscarContacto(nombre, apellido);
        System.out.println(resultado);
    }

    private void opcionEliminarContacto() {
        System.out.println("\nELIMINAR CONTACTO");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine().trim();

        Contacto aux = new Contacto(nombre, apellido, "");
        agenda.eliminarContacto(aux);
    }

    private void opcionModificarTelefono() {
        System.out.println("\nMODIFICAR TELÉFONO");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine().trim();
        System.out.print("Nuevo Teléfono (10 dígitos): ");
        String nuevoTelefono = scanner.nextLine().trim();

        agenda.modificarTelefono(nombre, apellido, nuevoTelefono);
    }

    private void opcionVerContactos() {
        System.out.println("\nLISTA DE CONTACTOS");
        String lista = agenda.verContactos();
        if (lista.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            System.out.print(lista);
        }
    }
}