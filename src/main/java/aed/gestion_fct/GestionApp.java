package aed.gestion_fct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionApp {

    // Insertar
    public void createAlumno(String nombre, String programa, String telefono, String correo) {
        // Validaciones
        if (telefono != null && !telefono.matches("^[0-9 ]+$")) {
            throw new IllegalArgumentException("El teléfono solo puede contener números y espacios.");
        }

        // Validar correo: debe contener un '@'
        if (correo != null && !correo.contains("@")) {
            throw new IllegalArgumentException("El correo debe contener un '@'.");
        }

        String insertQuery = "INSERT INTO alumno (nombre, programa, telefono, correo) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConnectionPool.getConnection(); // Usar el pool
                 PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, programa);
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, correo);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Alumno creado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear alumno: " + e.getMessage());
        }
    }

    // Leer
    public void leerAlumno() {
        String query = "SELECT * FROM alumno";

        try (Connection connection = ConnectionPool.getConnection(); // Usar el pool
                 Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_alumno"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Programa: " + resultSet.getString("programa"));
                System.out.println("Teléfono: " + resultSet.getString("telefono"));
                System.out.println("Correo: " + resultSet.getString("correo"));
                System.out.println("-----------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Error al leer los alumnos: " + e.getMessage());
        }
    }

    // Modificar
    public void actualizarAlumno(int id_alumno, String nombre, String programa, String telefono, String correo) {
        // Validaciones
        if (telefono != null && !telefono.matches("^[0-9 ]+$")) {
            throw new IllegalArgumentException("El teléfono solo puede contener números y espacios.");
        }

        // Validar correo: debe contener un '@'
        if (correo != null && !correo.contains("@")) {
            throw new IllegalArgumentException("El correo debe contener un '@'.");
        }

        String updateQuery = "UPDATE alumno SET nombre = ?, programa = ?, telefono = ?, correo = ? WHERE id_alumno = ?";

        try (Connection connection = ConnectionPool.getConnection(); // Usar el pool
                 PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, programa);
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, correo);
            preparedStatement.setInt(5, id_alumno);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Alumno actualizado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al actualizar el alumno: " + e.getMessage());
        }
    }

    public void borrarAlumno(int id_alumno) {

        String deleteQuery = "DELETE FROM alumno WHERE id_alumno = ?";

        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id_alumno);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Alumno eliminado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al eliminar el alumno: " + e.getMessage());
        }
    }
    
    // CRUD tutordocente
    public void crearTutorDocente(String nombre, String telefono, String correo) {
        // Restricciones reutilizadas de alumno
        if (telefono != null && !telefono.matches("^[0-9 ]+$")) {
            throw new IllegalArgumentException("El teléfono solo puede contener números y espacios.");
        }
        
        if (correo != null && !correo.contains("@")) {
            throw new IllegalArgumentException("El correo debe contener un '@'.");
        }
        
        String insertQuery = "INSERT INTO tutordocente (nombre, telefono, correo) VALUES (?, ?, ?)";

        try (Connection connection = ConnectionPool.getConnection(); // Usar el pool
                 PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, telefono);
            preparedStatement.setString(3, correo);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Tutor docente creado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear tutor docente: " + e.getMessage());
        }
        
        
    }
    
    public void leerTutorDocente() {
        String query = "SELECT * FROM tutordocente";

        try (Connection connection = ConnectionPool.getConnection(); // Usar el pool
                 Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_tutor_docente"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Teléfono: " + resultSet.getString("telefono"));
                System.out.println("Correo: " + resultSet.getString("correo"));
                System.out.println("-----------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Error al leer los tutores docentes: " + e.getMessage());
        }
    }
    
    public void actualizarTutorDocente(int id, String nombre, String telefono, String correo) {
        // Restricciones reutilizadas de alumno
        if (telefono != null && !telefono.matches("^[0-9 ]+$")) {
            throw new IllegalArgumentException("El teléfono solo puede contener números y espacios.");
        }

       
        if (correo != null && !correo.contains("@")) {
            throw new IllegalArgumentException("El correo debe contener un '@'.");
        }

        String updateQuery = "UPDATE tutordocente SET nombre = ?, telefono = ?, correo = ? WHERE id_tutor_docente = ?";

        try (Connection connection = ConnectionPool.getConnection(); // Usar el pool
                 PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, telefono);
            preparedStatement.setString(3, correo);
            preparedStatement.setInt(4, id);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Tutor docente actualizado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al actualizar al tutor docente: " + e.getMessage());
        }
    }
    
    public void eliminarTutorDocente(int id) {
        String deleteQuery = "DELETE FROM tutordocente WHERE id_tutor_docente = ?";

        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Tutor docente eliminado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al eliminar al tutor docente: " + e.getMessage());
        }
    }

    // EMPRESA
    
    // Crear Empresa
    public void createEmpresa(String nombre, String direccion, String telefono, String correo) {
        // Validaciones
        if (telefono != null && !telefono.matches("^[0-9 ]+$")) {
            throw new IllegalArgumentException("El teléfono solo puede contener números y espacios.");
        }

        // Validar correo: debe contener un '@'
        if (correo != null && !correo.contains("@")) {
            throw new IllegalArgumentException("El correo debe contener un '@'.");
        }

        String insertQuery = "INSERT INTO empresa (nombre, direccion, telefono, correo) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConnectionPool.getConnection(); // Usar el pool
                 PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, direccion);
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, correo);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Empresa creada. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear empresa: " + e.getMessage());
        }
    }
    
    // Leer empresa
    public void leerEmpresa() {
        String query = "SELECT * FROM empresa";

        try (Connection connection = ConnectionPool.getConnection(); // Usar el pool
                 Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_empresa"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Direccion: " + resultSet.getString("direccion"));
                System.out.println("Teléfono: " + resultSet.getString("telefono"));
                System.out.println("Correo: " + resultSet.getString("correo"));
                System.out.println("-----------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Error al leer las empresas: " + e.getMessage());
        }
    }
    
    // Modificar empresa
    public void actualizarEmpresa(int id_empresa, String nombre, String direccion, String telefono, String correo) {
        // Validaciones
        if (telefono != null && !telefono.matches("^[0-9 ]+$")) {
            throw new IllegalArgumentException("El teléfono solo puede contener números y espacios.");
        }

        // Validar correo: debe contener un '@'
        if (correo != null && !correo.contains("@")) {
            throw new IllegalArgumentException("El correo debe contener un '@'.");
        }

        String updateQuery = "UPDATE empresa SET nombre = ?, direccion = ?, telefono = ?, correo = ? WHERE id_empresa = ?";

        try (Connection connection = ConnectionPool.getConnection(); // Usar el pool
                 PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, direccion);
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, correo);
            preparedStatement.setInt(5, id_empresa);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Alumno actualizado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al actualizar la empresa: " + e.getMessage());
        }
    }
    
    // Borrar Empresa
    public void borrarEmpresa(int id_Empresa) {

        String deleteQuery = "DELETE FROM empresa WHERE id_empresa = ?";

        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id_Empresa);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Empresa eliminada. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al eliminar la empresa: " + e.getMessage());
        }
    }
    
    // TUTOR EMPRESA
    
    // Insertar Tutor Empresa
    public void createTutorEmpresa(String nombre, String telefono, String correo) {
        // Validaciones
        if (telefono != null && !telefono.matches("^[0-9 ]+$")) {
            throw new IllegalArgumentException("El teléfono solo puede contener números y espacios.");
        }

        // Validar correo: debe contener un '@'
        if (correo != null && !correo.contains("@")) {
            throw new IllegalArgumentException("El correo debe contener un '@'.");
        }

        String insertQuery = "INSERT INTO tutorempresa (nombre, telefono, correo) VALUES (?, ?, ?)";

        try (Connection connection = ConnectionPool.getConnection(); // Usar el pool
                 PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, telefono);
            preparedStatement.setString(3, correo);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Tutor Empresa creado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear tutor empresa: " + e.getMessage());
        }
    }
    
    // Leer Tutor Empresa
    public void leerTutorEmpresa() {
        String query = "SELECT * FROM tutorempresa";

        try (Connection connection = ConnectionPool.getConnection(); // Usar el pool
                 Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id_tutor_empresa"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Teléfono: " + resultSet.getString("telefono"));
                System.out.println("Correo: " + resultSet.getString("correo"));
                System.out.println("-----------------------------------");
            }

        } catch (SQLException e) {
            System.err.println("Error al leer los tutores empresa: " + e.getMessage());
        }
    }
    
    // Modificar Tutor Empresa
    public void actualizarTutorEmpresa(int id_tutor_empresa, String nombre, String telefono, String correo) {
        // Validaciones
        if (telefono != null && !telefono.matches("^[0-9 ]+$")) {
            throw new IllegalArgumentException("El teléfono solo puede contener números y espacios.");
        }

        // Validar correo: debe contener un '@'
        if (correo != null && !correo.contains("@")) {
            throw new IllegalArgumentException("El correo debe contener un '@'.");
        }

        String updateQuery = "UPDATE tutorempresa SET nombre = ?, telefono = ?, correo = ? WHERE id_tutor_empresa = ?";

        try (Connection connection = ConnectionPool.getConnection(); // Usar el pool
                 PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, telefono);
            preparedStatement.setString(3, correo);
            preparedStatement.setInt(4, id_tutor_empresa);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Tutor Empresa actualizado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al actualizar el tutor empresa: " + e.getMessage());
        }
    }
    
    // Borrar Tutor Empresa
    public void borrarTutorEmpresa(int id_tutor_empresa) {

        String deleteQuery = "DELETE FROM tutorempresa WHERE id_tutor_empresa = ?";

        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id_tutor_empresa);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Tutor Empresa eliminado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al eliminar el Tutor Empresa: " + e.getMessage());
        }
    }
    
}