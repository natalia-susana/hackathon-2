
import agenda.model.Contacto; //
import agenda.service.Agenda;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        crearAgenda(); //para crar la agenda

        int opcion; //queremos que seleccione una opcion del menu

        do {
            mostrarOpciones();
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {

                case 1: // añadir contacto
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Telefono: ");
                    String telefono = sc.nextLine();
                    agenda.anadirContacto(new Contacto(nombre, apellido, telefono));
                    break;

                case 2: { //  si existe
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    boolean existe = agenda.existeContacto(new Contacto(nombre, apellido, ""));
                    System.out.println(existe ? "Existe." : "No existe.");
                    break;
                }
                case 3: { // Imprimir todos los contactos
                    agenda.listarContactos();
                    break;
                }
                case 4: { // buscar
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    agenda.buscarContacto(nombre, apellido);
                    break;
                }

                case 5: { // elimina contacto
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    agenda.eliminarContacto(new Contacto(nombre, apellido, ""));
                    break;
                }

                case 6: { // modificar el tel
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Nuevo telefono: ");
                    String nuevTelefono = sc.nextLine();
                    agenda.modificarTelefono(nombre, apellido, nuevTelefono);
                    break;
                }

                case 7: { // Ver si esta llena
                    agenda.agendaLlena();
                    break;
                }

                case 8: { // Ver espacios libres
                    agenda.espaciosLibres();
                    break;
                }
                case 9:
                    break;

                default:
                    System.out.println("Opción no valida");
            }

        } while (opcion != 9);
        System.out.println("Fin del programa.");


    }
}

