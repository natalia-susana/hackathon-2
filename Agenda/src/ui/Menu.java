package ui;

import model.Contacto;
import servicie.Agenda;
import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);
    private Agenda agenda = new Agenda();

    public void iniciar() {
        int opcion;

        do {
            System.out.println("\n1.Añadir 2.Existe 3.Ver contactos 4.Buscar 5.Eliminar 6.Modificar 7.Llena 8.Espacios libres 9.Salir");
            System.out.print("Opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1: {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Telefono: ");
                    String telefono = sc.nextLine();
                    agenda.añadirContacto(new Contacto(nombre, apellido, telefono));
                    break;
                }

                case 2: {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    boolean existe = agenda.existeContacto(new Contacto(nombre, apellido, ""));
                    System.out.println(existe ? "Existe." : "No existe.");
                    break;
                }

                case 3: {
                    System.out.println(agenda.verContactos());
                    break;
                }

                case 4: {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.println(agenda.buscarContacto(nombre, apellido));
                    break;
                }

                case 5: {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    agenda.eliminarContacto(new Contacto(nombre, apellido, ""));
                    break;
                }

                case 6: {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Nuevo telefono: ");
                    String nuevoTelefono = sc.nextLine();
                    agenda.modificarTelefono(nombre, apellido, nuevoTelefono);
                    break;
                }

                case 7: {
                    agenda.agendaLlena();
                    break;
                }

                case 8: {
                    agenda.espacioLibres();
                    break;
                }

                case 9:
                    break;

                default:
                    System.out.println("Opcion no valida");
            }

        } while (opcion != 9);

        System.out.println("Fin del programa.");
    }
}