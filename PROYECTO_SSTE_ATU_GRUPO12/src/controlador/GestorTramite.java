package controlador;

import conexion.ConexionBD;
import modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class GestorTramite {

    /*
     * LÓGICA DE GUARDADO EN BASE DE DATOS (PERSISTENCIA):
     * Aquí tomamos nuestros objetos (ya validados por sus propios constructores)
     * y los "inyectamos" en las tablas de la base de datos usando sentencias SQL.
     * Es un proceso directo y lógico: Abrimos conexión -> Guardamos -> Cerramos.
     */
    public Expediente registrarEmpresa(Empresa empresa, Recibo recibo, Usuario usuarioActual) {
        
        String sqlEmpresa = "INSERT INTO Empresa (ruc, razonSocial, estado) VALUES (?, ?, ?)";
        String sqlExpediente = "INSERT INTO Expediente (numeroExpediente, ruc_empresa, id_usuario, id_recibo) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConexionBD.obtenerConexion()) {
            
            // 1. Disparamos la inserción de la empresa en MySQL
            try (PreparedStatement psEmp = conn.prepareStatement(sqlEmpresa)) {
                psEmp.setString(1, empresa.getRuc());
                psEmp.setString(2, empresa.getRazonSocial());
                psEmp.setString(3, empresa.getEstado());
                psEmp.executeUpdate();
            }

            // 2. Armamos el expediente combinando todos los objetos reales
            String numExp = "EXP-" + System.currentTimeMillis();
            Expediente nuevoExpediente = new Expediente(numExp, LocalDate.now(), usuarioActual, empresa, recibo);

            // 3. Disparamos la inserción del expediente vinculando los IDs en la base de datos
            try (PreparedStatement psExp = conn.prepareStatement(sqlExpediente)) {
                psExp.setString(1, nuevoExpediente.getNumeroExpediente());
                psExp.setString(2, empresa.getRuc());
                psExp.setInt(3, usuarioActual.getIdUsuario());
                psExp.setInt(4, recibo.getIdRecibo());
                psExp.executeUpdate(); 
            }

            return nuevoExpediente; // Retornamos el objeto para mostrar éxito en pantalla

        } catch (SQLException e) {
            System.out.println("Proceso detenido: Problema al guardar en la base de datos (" + e.getMessage() + ")");
            return null;
        }
    }
}