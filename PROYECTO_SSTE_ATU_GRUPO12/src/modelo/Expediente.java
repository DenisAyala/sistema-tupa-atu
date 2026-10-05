package modelo;
import java.time.LocalDate;

public class Expediente {
    private String numeroExpediente;
    private LocalDate fechaRegistro;
    private Usuario usuario;
    private Empresa empresa;
    private Recibo recibo;

    /*
     * LÓGICA DE ASOCIACIÓN DE OBJETOS:
     * Un expediente no es solo un papel, es la unión de una persona, una empresa y un pago.
     * Por eso exigimos los objetos reales (Usuario, Empresa, Recibo) y no solo sus números ID.
     * Así respetamos al 100% el diseño del diagrama UML.
     */
    public Expediente(String numeroExpediente, LocalDate fechaRegistro, Usuario usuario, Empresa empresa, Recibo recibo) {
        if (usuario == null || empresa == null || recibo == null) {
            throw new IllegalArgumentException("Error de asociación: Todo expediente necesita un usuario, una empresa y un recibo obligatoriamente.");
        }
        this.numeroExpediente = numeroExpediente;
        this.fechaRegistro = fechaRegistro;
        this.usuario = usuario;
        this.empresa = empresa;
        this.recibo = recibo;
    }

    public String getNumeroExpediente() { return numeroExpediente; }
}