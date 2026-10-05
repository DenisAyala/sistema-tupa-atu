package modelo;

public class Usuario {
    private int idUsuario;
    private String codigoUsuario;
    private String clave;

    /*
     * LÓGICA DE CREACIÓN SEGURA:
     * Obligamos a que todo usuario nazca con sus credenciales básicas.
     * Si el sistema intenta crear un usuario vacío, se bloquea al instante para evitar fallos.
     */
    public Usuario(int idUsuario, String codigoUsuario, String clave) {
        if (codigoUsuario == null || clave == null || codigoUsuario.isBlank()) {
            throw new IllegalArgumentException("Regla de negocio: El usuario y la clave son obligatorios.");
        }
        this.idUsuario = idUsuario;
        this.codigoUsuario = codigoUsuario;
        this.clave = clave;
    }

    public int getIdUsuario() { return idUsuario; }
}