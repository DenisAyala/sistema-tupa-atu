package modelo;

public class Empresa {
    private String ruc;
    private String razonSocial;
    private String estado;

    /*
     * LÓGICA DE REGLA DE NEGOCIO (RUC):
     * Antes de que la empresa exista en la memoria, verificamos que el RUC sea válido.
     * Si no tiene 11 dígitos, se rechaza la creación de la empresa automáticamente.
     */
    public Empresa(String ruc, String razonSocial, String estado) {
        if (ruc == null || ruc.length() != 11) {
            throw new IllegalArgumentException("Regla de negocio: El RUC debe tener exactamente 11 dígitos.");
        }
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.estado = estado;
    }

    public String getRuc() { return ruc; }
    public String getRazonSocial() { return razonSocial; }
    public String getEstado() { return estado; }
}