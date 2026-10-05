package modelo;

public class Recibo {
    private int idRecibo;
    private String numero;
    private double monto;

    /*
     * LÓGICA DE VALIDACIÓN DE PAGO:
     * Un pago falso o de cero soles no tiene validez.
     * Si el monto es cero o negativo, bloqueamos el registro del recibo.
     */
    public Recibo(int idRecibo, String numero, double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("Regla de negocio: El monto del recibo no puede ser nulo o negativo.");
        }
        this.idRecibo = idRecibo;
        this.numero = numero;
        this.monto = monto;
    }

    public int getIdRecibo() { return idRecibo; }
}