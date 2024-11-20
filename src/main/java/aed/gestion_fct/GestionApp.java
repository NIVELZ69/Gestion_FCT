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

    public static void borrarLibro(int id_alumno) {

        String deleteQuery = "DELETE FROM alumno WHERE id_alumno = ?";

        try (Connection connection = ConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id_alumno);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Alumno eliminado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al eliminar el alumno: " + e.getMessage());
        }
    }
}
