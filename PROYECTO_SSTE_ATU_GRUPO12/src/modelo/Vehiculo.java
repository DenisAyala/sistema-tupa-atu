package modelo;
import java.time.LocalDate;

public class Vehiculo {
    private String placa;
    private int anioModelo;
    private String estado;

    /*
     * LÓGICA DE REGLA DE NEGOCIO (ANTIGÜEDAD):
     * Calculamos la edad real del vehículo usando el año actual del sistema.
     * Si el cálculo nos dice que tiene más de 15 años, el vehículo no se puede registrar.
     */
    public Vehiculo(String placa, int anioModelo, String estado) {
        int anioActual = LocalDate.now().getYear();
        if ((anioActual - anioModelo) > 15) {
            throw new IllegalArgumentException("Regla de negocio: El vehículo excede el límite de 15 años de antigüedad.");
        }
        this.placa = placa;
        this.anioModelo = anioModelo;
        this.estado = estado;
    }

    public String getPlaca() { return placa; }
}