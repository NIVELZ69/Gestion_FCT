package aed.gestion_fct;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GestionApp {

    String url = "jdbc:mariadb://localhost:3306/fct_gestion";

    //Insertar
    public void createAlumno(int id_alumno, String nombre, String programa, String telefono, String correo) {
        String insertQuery = "INSERT INTO alumno (id_alumno, nombre, programa, telefono, correo) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, "root", ""); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setInt(1, id_alumno);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, programa);
            preparedStatement.setString(4, telefono);
            preparedStatement.setString(5, correo);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Alumno creado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear empleado: " + e.getMessage());
        }
    }

}
