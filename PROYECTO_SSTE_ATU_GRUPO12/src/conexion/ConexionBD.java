package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    /*
     * LÓGICA DE CONEXIÓN (NUESTRO PUENTE A LA BASE DE DATOS):
     * Aquí creamos un "puente" único para que nuestro sistema se comunique con MySQL mediante JDBC.
     * Centralizamos esto aquí para no repetir el código de conexión en cada registro del sistema.
     */
    public static Connection obtenerConexion() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/atu_db", "root", "123456");
        } catch (SQLException e) {
            System.out.println("Error crítico: No pudimos establecer el puente con la base de datos.");
            return null;
        }
    }