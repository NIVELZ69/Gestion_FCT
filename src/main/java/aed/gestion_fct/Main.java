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
                                System.out.println("Telefono: ");
                                telefono = sc.nextLine();
                                System.out.println("Correo: ");
                                correo = sc.nextLine();

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
                                gestionApp.borrarAlumno(id_alumno);
                                break;
                        }

                    } while (opcionAlumno != 5);

                    break;
                    
                case 4:
                    
                    int opcionTutorDocente;
                    String nombreTutorDocente;
                    String telefonoTutorDocente;
                    String correoTutorDocente;
                    int id_tutor_docente;

                    do {
                        System.out.println("\n--- Menú ---");
                        System.out.println("1. Crear tutor docente");
                        System.out.println("2. Leer tutor docente");
                        System.out.println("3. Modificar tutor docente");
                        System.out.println("4. Borrar tutor docente");
                        System.out.println("5. Volver");
                        System.out.print("Seleccione una opción: ");
                        opcionTutorDocente = sc.nextInt();
                        sc.nextLine(); // Limpiar el buffer

                        switch (opcionTutorDocente) {
                            case 1:
                                System.out.println("Nombre: ");
                                nombreTutorDocente = sc.nextLine();

                                // Validar teléfono
                                do {
                                    System.out.println("Teléfono (Solo números): ");
                                    telefonoTutorDocente = sc.nextLine();
                                    if (!telefonoTutorDocente.matches("^[0-9 ]+$")) {
                                        System.out.println("El teléfono solo puede contener números y espacios.");
                                    }
                                } while (!telefonoTutorDocente.matches("^[0-9 ]+$"));

                                // Validar correo
                                do {
                                    System.out.println("Correo (Debe contener @): ");
                                    correoTutorDocente = sc.nextLine();
                                    if (!correoTutorDocente.contains("@")) {
                                        System.out.println("El correo debe contener un '@'.");
                                    }
                                } while (!correoTutorDocente.contains("@"));

                                gestionApp.crearTutorDocente(nombreTutorDocente, telefonoTutorDocente, correoTutorDocente);
                                break;

                            case 2:
                                gestionApp.leerTutorDocente();
                                break;

                            case 3:
                                System.out.println("ID del tutor docente a modificar: ");
                                id_tutor_docente = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Nombre: ");
                                nombreTutorDocente = sc.nextLine();

                                // Validar teléfono
                                do {
                                    System.out.println("Teléfono (Solo números): ");
                                    telefonoTutorDocente = sc.nextLine();
                                    if (!telefonoTutorDocente.matches("^[0-9 ]+$")) {
                                        System.out.println("El teléfono solo puede contener números y espacios.");
                                    }
                                } while (!telefonoTutorDocente.matches("^[0-9 ]+$"));

                                // Validar correo
                                do {
                                    System.out.println("Correo (Debe contener @): ");
                                    correoTutorDocente = sc.nextLine();
                                    if (!correoTutorDocente.contains("@")) {
                                        System.out.println("El correo debe contener un '@'.");
                                    }
                                } while (!correoTutorDocente.contains("@"));

                                gestionApp.actualizarTutorDocente(id_tutor_docente, nombreTutorDocente, telefonoTutorDocente, correoTutorDocente);
                                break;

                            case 4:
                                System.out.println("ID del tutor docente a eliminar: ");
                                id_tutor_docente = sc.nextInt();
                                gestionApp.eliminarTutorDocente(id_tutor_docente);
                                break;
                        }

                    } while (opcionTutorDocente != 5);

                    break;

                case 3:
                    int opcionEmpresa;
                    String nombreEmpresa;
                    String direccionEmpresa;
                    String telefonoEmpresa;
                    String correoEmpresa;
                    int id_empresa;

                    do {
                        System.out.println("\n--- Menú ---");
                        System.out.println("1. Crear empresa");
                        System.out.println("2. Leer empresa");
                        System.out.println("3. Modificar empresa");
                        System.out.println("4. Borrar empresa");
                        System.out.println("5. Volver");
                        System.out.print("Seleccione una opción: ");
                        opcionEmpresa = sc.nextInt();
                        sc.nextLine(); // Limpiar el buffer

                        switch (opcionEmpresa) {
                            case 1:
                                System.out.println("Nombre: ");
                                nombreEmpresa = sc.nextLine();
                                System.out.println("Direccion: ");
                                direccionEmpresa = sc.nextLine();

                                // Validar teléfono
                                do {
                                    System.out.println("Teléfono (Solo números): ");
                                    telefonoEmpresa = sc.nextLine();
                                    if (!telefonoEmpresa.matches("^[0-9 ]+$")) {
                                        System.out.println("El teléfono solo puede contener números y espacios.");
                                    }
                                } while (!telefonoEmpresa.matches("^[0-9 ]+$"));

                                // Validar correo
                                do {
                                    System.out.println("Correo (Debe contener @): ");
                                    correoEmpresa = sc.nextLine();
                                    if (!correoEmpresa.contains("@")) {
                                        System.out.println("El correo debe contener un '@'.");
                                    }
                                } while (!correoEmpresa.contains("@"));

                                gestionApp.createEmpresa(nombreEmpresa, direccionEmpresa, telefonoEmpresa, correoEmpresa);
                                break;
                                
                            case 2:
                                gestionApp.leerEmpresa();
                                break;
                                
                            case 3:
                                System.out.println("ID de la empresa a modificar: ");
                                id_empresa = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Nombre: ");
                                nombreEmpresa = sc.nextLine();
                                System.out.println("Direccion: ");
                                direccionEmpresa = sc.nextLine();

                                // Validar teléfono
                                do {
                                    System.out.println("Teléfono (Solo números): ");
                                    telefonoEmpresa = sc.nextLine();
                                    if (!telefonoEmpresa.matches("^[0-9 ]+$")) {
                                        System.out.println("El teléfono solo puede contener números y espacios.");
                                    }
                                } while (!telefonoEmpresa.matches("^[0-9 ]+$"));

                                // Validar correo
                                do {
                                    System.out.println("Correo (Debe contener @): ");
                                    correoEmpresa = sc.nextLine();
                                    if (!correoEmpresa.contains("@")) {
                                        System.out.println("El correo debe contener un '@'.");
                                    }
                                } while (!correoEmpresa.contains("@"));

                                gestionApp.actualizarEmpresa(id_empresa, nombreEmpresa, direccionEmpresa, telefonoEmpresa, correoEmpresa);
                                break;
                                
                            case 4:
                                System.out.println("ID de la empresa a eliminar: ");
                                id_alumno = sc.nextInt();
                                gestionApp.borrarEmpresa(id_alumno);
                                break;
                        }
                    } while (opcionEmpresa != 5);
                    
                    break;
                    
                case 5:
                    int opcionTutorEmpresa;
                    String nombreTutorEmpresa;
                    String telefonoTutorEmpresa;
                    String correoTutorEmpresa;
                    int id_tutor_empresa;
                    
                    do {
                        System.out.println("\n--- Menú ---");
                        System.out.println("1. Crear tutor empresa");
                        System.out.println("2. Leer tutor empresa");
                        System.out.println("3. Modificar tutor empresa");
                        System.out.println("4. Borrar tutor empresa");
                        System.out.println("5. Volver");
                        System.out.print("Seleccione una opción: ");
                        opcionTutorEmpresa = sc.nextInt();
                        sc.nextLine(); // Limpiar el buffer
                        
                        switch (opcionTutorEmpresa) {
                            case 1:
                                System.out.println("Nombre: ");
                                nombreTutorEmpresa = sc.nextLine();

                                // Validar teléfono
                                do {
                                    System.out.println("Teléfono (Solo números): ");
                                    telefonoTutorEmpresa = sc.nextLine();
                                    if (!telefonoTutorEmpresa.matches("^[0-9 ]+$")) {
                                        System.out.println("El teléfono solo puede contener números y espacios.");
                                    }
                                } while (!telefonoTutorEmpresa.matches("^[0-9 ]+$"));

                                // Validar correo
                                do {
                                    System.out.println("Correo (Debe contener @): ");
                                    correoTutorEmpresa = sc.nextLine();
                                    if (!correoTutorEmpresa.contains("@")) {
                                        System.out.println("El correo debe contener un '@'.");
                                    }
                                } while (!correoTutorEmpresa.contains("@"));

                                gestionApp.createTutorEmpresa(nombreTutorEmpresa, telefonoTutorEmpresa, correoTutorEmpresa);
                                break;
                                
                            case 2:
                                gestionApp.leerTutorEmpresa();
                                break;
                                
                            case 3:
                                System.out.println("ID del tutor empresa a modificar: ");
                                id_tutor_empresa = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Nombre: ");
                                nombreTutorEmpresa = sc.nextLine();

                                // Validar teléfono
                                do {
                                    System.out.println("Teléfono (Solo números): ");
                                    telefonoTutorEmpresa = sc.nextLine();
                                    if (!telefonoTutorEmpresa.matches("^[0-9 ]+$")) {
                                        System.out.println("El teléfono solo puede contener números y espacios.");
                                    }
                                } while (!telefonoTutorEmpresa.matches("^[0-9 ]+$"));

                                // Validar correo
                                do {
                                    System.out.println("Correo (Debe contener @): ");
                                    correoTutorEmpresa = sc.nextLine();
                                    if (!correoTutorEmpresa.contains("@")) {
                                        System.out.println("El correo debe contener un '@'.");
                                    }
                                } while (!correoTutorEmpresa.contains("@"));

                                gestionApp.actualizarTutorEmpresa(id_tutor_empresa, nombreTutorEmpresa, telefonoTutorEmpresa, correoTutorEmpresa);
                                break;
                                
                            case 4:
                                System.out.println("ID del tutor empresa a eliminar: ");
                                id_tutor_empresa = sc.nextInt();
                                gestionApp.borrarTutorEmpresa(id_tutor_empresa);
                                break;
                        }
                        
                    } while (opcionTutorEmpresa != 5);
                    
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
