package aed.gestion_fct;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Crear una instancia de la clase Operaciones
        GestionApp gestionApp = new GestionApp();
        Scanner sc = new Scanner(System.in);

        System.out.println("Elije que tabla quieres modificar");
        System.out.println("1. Alumno");
        System.out.println("2. Práctica");
        System.out.println("3. Empresa");
        System.out.println("4. TutorDocente");
        System.out.println("5. TutorEmpresa");
        System.out.println("6. Visita");
        System.out.println("7. Comentario");
        System.out.println("8. Cerrar");

        int opcion = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        while (opcion != 8) {

            switch (opcion) {
                case 1:
                    int opcionAlumno;
                    String nombre;
                    String programa;
                    String telefono;
                    String correo;
                    int id_alumno;

                    do {
                        System.out.println("\n--- Menú ---");
                        System.out.println("1. Crear alumno");
                        System.out.println("2. Leer alumno");
                        System.out.println("3. Modificar alumno");
                        System.out.println("4. Borrar alumno");
                        System.out.println("5. Volver");
                        System.out.print("Seleccione una opción: ");
                        opcionAlumno = sc.nextInt();
                        sc.nextLine(); // Limpiar el buffer

                        switch (opcionAlumno) {
                            case 1:
                                System.out.println("Nombre: ");
                                nombre = sc.nextLine();
                                System.out.println("Programa: ");
                                programa = sc.nextLine();

                                // Validar teléfono
                                do {
                                    System.out.println("Teléfono (Solo números): ");
                                    telefono = sc.nextLine();
                                    if (!telefono.matches("^[0-9 ]+$")) {
                                        System.out.println("El teléfono solo puede contener números y espacios.");
                                    }
                                } while (!telefono.matches("^[0-9 ]+$"));

                                // Validar correo
                                do {
                                    System.out.println("Correo (Debe contener @): ");
                                    correo = sc.nextLine();
                                    if (!correo.contains("@")) {
                                        System.out.println("El correo debe contener un '@'.");
                                    }
                                } while (!correo.contains("@"));

                                gestionApp.createAlumno(nombre, programa, telefono, correo);
                                break;

                            case 2:
                                gestionApp.leerAlumno();
                                break;

                            case 3:
                                System.out.println("ID del alumno a modificar: ");
                                id_alumno = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Nombre: ");
                                nombre = sc.nextLine();
                                System.out.println("Programa: ");
                                programa = sc.nextLine();

                                // Validar teléfono
                                do {
                                    System.out.println("Teléfono (Solo números): ");
                                    telefono = sc.nextLine();
                                    if (!telefono.matches("^[0-9 ]+$")) {
                                        System.out.println("El teléfono solo puede contener números y espacios.");
                                    }
                                } while (!telefono.matches("^[0-9 ]+$"));

                                // Validar correo
                                do {
                                    System.out.println("Correo (Debe contener @): ");
                                    correo = sc.nextLine();
                                    if (!correo.contains("@")) {
                                        System.out.println("El correo debe contener un '@'.");
                                    }
                                } while (!correo.contains("@"));

                                gestionApp.actualizarAlumno(id_alumno, nombre, programa, telefono, correo);
                                break;

                            case 4:
                                System.out.println("ID del alumno a eliminar: ");
                                id_alumno = sc.nextInt();
                                gestionApp.borrarLibro(id_alumno);
                                break;
                        }

                    } while (opcionAlumno != 5);

                    break;

                case 8:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

            System.out.println("\nElije que tabla quieres modificar");
            System.out.println("1. Alumno");
            System.out.println("2. Práctica");
            System.out.println("3. Empresa");
            System.out.println("4. TutorDocente");
            System.out.println("5. TutorEmpresa");
            System.out.println("6. Visita");
            System.out.println("7. Comentario");
            System.out.println("8. Cerrar");

            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
        }

        sc.close();
    }
}
