package modelo;

public class Conductor {
    private String dni;
    private String categoriaLicencia;
    private String estado;

    /*
     * LÓGICA DE REGLA DE NEGOCIO (LICENCIA):
     * Verificamos que la licencia no sea básica (AI).
     * El conductor debe ser profesional para brindar el servicio especial.
     */
    public Conductor(String dni, String categoriaLicencia, String estado) {
        if (categoriaLicencia == null || categoriaLicencia.equalsIgnoreCase("AI")) {
            throw new IllegalArgumentException("Regla de negocio: La licencia debe ser superior a categoría AI.");
        }
        this.dni = dni;
        this.categoriaLicencia = categoriaLicencia;
        this.estado = estado;
    }

    public String getDni() { return dni; }
}