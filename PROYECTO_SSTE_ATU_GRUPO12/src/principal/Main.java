package principal;

import controlador.GestorTramite;
import modelo.*;

public class Main {
    /*
     * LÓGICA CENTRAL DE PRUEBA:
     * Este es el botón de encendido del programa. Creamos datos de prueba para
     * simular lo que un empleado escribiría en la interfaz y vemos si el sistema fluye.
     */
    public static void main(String[] args) {
        GestorTramite gestor = new GestorTramite();
        
        try {
            // Se instancian los objetos (las validaciones actúan automáticamente aquí)
            Usuario evaluador = new Usuario(1, "EVAL-01", "claveSegura");
            Empresa nuevaEmpresa = new Empresa("20123456789", "Transportes Lima Sur SAC", "ACTIVO");
            Recibo pago = new Recibo(1, "REC-4567", 150.0);
            
            System.out.println("Procesando el registro de la nueva empresa...");
            
            // Se ejecuta la lógica del controlador
            Expediente expedienteGenerado = gestor.registrarEmpresa(nuevaEmpresa, pago, evaluador);
            
            if (expedienteGenerado != null) {
                System.out.println("¡Registro exitoso! Número de trámite asignado: " + expedienteGenerado.getNumeroExpediente());
            } else {
                System.out.println("Error de conexión: Verifica que tu base de datos local esté encendida.");
            }
            
        } catch (IllegalArgumentException e) {
            // Si alguna regla de negocio (como RUC corto o pago cero) falla, el error es atrapado aquí.
            System.out.println("Trámite rechazado por validación de datos: " + e.getMessage());
        }
    }
}